package fs.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Validable {

    public static final String ILLEGAL_STATE_MESSAGE = "Undefined boolean result";
    private static final String GETTER_PREFIX_REGEX = "^(get|is)[A-Z].*";

    protected boolean isValid() {
        List<Method> methods = Arrays.asList(this.getClass().getDeclaredMethods());
        Boolean validity = methods.stream()
            .filter(method -> isGetter(method.getName()))
            .map(this::getValue)
            .map(this::isValid)
            .reduce(this::combineAllResults)
            .orElseThrow(() -> new IllegalStateException(ILLEGAL_STATE_MESSAGE));
        return validity;
    }

    private boolean isValid(Object value) {
        if (value instanceof Validable) {
            return ((Validable) value).isValid();
        } else {
            return Objects.nonNull(value);
        }
    }

    private boolean combineAllResults(Boolean bool1, Boolean bool2) {
        return bool1 && bool2;
    }

    private Object getValue(Method method) {
        try {
            return method.invoke(this);
        } catch (InvocationTargetException | IllegalAccessException e) {
            // escalate Exceptions because Java 8 does not support exceptions inside maps
            // If we get any exception of public getters it would be a critical mistake
            // and should fix it
            throw new RuntimeException(e);
        }
    }

    public boolean isGetter(String methodName) {
        return methodName.matches(GETTER_PREFIX_REGEX);
    }
}
