package fs.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Validable {

    private static final String INVALID_RESULT_MESSAGE = "Method {} in class {} is  not a valid result";
    private static final String NUL_VALUE_MESSAGE = "Method {} in class {} return null result";
    private static final String PRIMITIVE_VALUE_ERROR = "Method %s returns probably a primitive value";
    private static final String INVOKING_METHOD_ERROR = "Error invoking method %s. Does it return primitive values?";
    private static final String GETTER_PREFIX_REGEX = "^(get|is)[A-Z].*";
    private static final Logger logger = LoggerFactory.getLogger(Validable.class);
    private static final String ILLEGAL_STATE_MESSAGE = "Undefined boolean result";

    protected Validable() {
    }

    public static boolean isGetter(Method method) {
        boolean zeroParamaters = method.getParameterCount() == 0;
        boolean matchesPattern = matchesGetterPattern(method.getName());
        return zeroParamaters && matchesPattern;
    }

    protected static boolean matchesGetterPattern(String methodName) {
        return methodName.matches(GETTER_PREFIX_REGEX);
    }

    @JsonIgnore
    public boolean isValid() {
        List<Method> methods = Arrays.asList(this.getClass()
            .getDeclaredMethods());
        Boolean validity = methods.stream()
            .filter(Validable::isGetter)
            .filter(this::shouldNotIgnore)
            .map(this::getValue)
            .map(this::isValid)
            .reduce(this::combineAllResults)
            .orElseThrow(() -> new IllegalStateException(ILLEGAL_STATE_MESSAGE));
        return validity;
    }

    private boolean isValid(Entry<String, Object> nameValuePair) {
        Object value = nameValuePair.getValue();
        String methodName = nameValuePair.getKey();
        boolean result = false;

        if (value instanceof Validable) {
            result = ((Validable) value).isValid();
            if (!result) {
                logger.error(INVALID_RESULT_MESSAGE, methodName, this.getClass()
                    .getName());
            }
        } else {
            result = Objects.nonNull(value);
            if (!result) {
                logger.error(NUL_VALUE_MESSAGE, methodName, this.getClass()
                    .getName());
            }
        }
        if (Objects.nonNull(value) && value.getClass()
            .isPrimitive()) {
            throw new IllegalArgumentException(String.format(PRIMITIVE_VALUE_ERROR, methodName));
        }
        return result;
    }

    private boolean shouldNotIgnore(Method method) {
        boolean noParameters = method.getParameterCount() == 0;
        boolean notIgnorable = !method.isAnnotationPresent(IgnoreValidable.class);
        return noParameters && notIgnorable;
    }

    private boolean combineAllResults(Boolean bool1, Boolean bool2) {
        return bool1 && bool2;
    }

    private Entry<String, Object> getValue(Method method) {
        try {
            return new SimpleEntry<>(method.getName(), method.invoke(this));
        } catch (InvocationTargetException | IllegalAccessException e) {
            // escalate Exceptions because Java 8 does not support exceptions inside maps
            // If we get any exception of public getters it would be a critical mistake
            // and should fix it
            logger.error(INVOKING_METHOD_ERROR, method.getName());
            throw new RuntimeException(e);
        }
    }
}
