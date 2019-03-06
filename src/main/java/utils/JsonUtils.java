package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Arrays;
import java.util.List;

public final class JsonUtils {

    private static final String UNSUPPORTED_CLASS_EXCEPTION = "Class %s is not yet support it. Add it in JsonTools";
    public static ObjectMapper mapper = jsonParser();
    public static ObjectWriter writer = mapper.writer();
    public static ObjectReader reader = mapper.reader();

    private JsonUtils() {
    }

    private static ObjectMapper jsonParser() {
        JsonFactory jsonFactory = new JsonFactory()
            .configure(Feature.ALLOW_COMMENTS, true)
            .configure(Feature.ALLOW_YAML_COMMENTS, true);
        return new ObjectMapper(jsonFactory);
    }

    public static String write(Object item) throws JsonProcessingException {
        return writer.writeValueAsString(item);
    }

    public static ObjectNode newObjectNode() {
        return mapper.createObjectNode();
    }

    public static ArrayNode newArrayNode() {
        return mapper.createArrayNode();
    }

    public static <T> ObjectNode putKeyInNode(String key, T value, ObjectNode root) {
        List<String> keys = Arrays.asList(key.split("\\."));
        ObjectNode currentNode = root;
        for (int i = 0; i < keys.size() - 1; i++) {
            String currentKey = keys.get(i);
            if (!hasKey(root, keys.subList(0, i + 1))) {
                currentNode.set(currentKey, JsonUtils.newObjectNode());
            }
            currentNode = (ObjectNode) currentNode.get(currentKey);
        }

        String lastKey = keys.get(keys.size() - 1);
        putKey(lastKey, value, currentNode);

        return root;
    }

    private static <T> void putKey(String key, T value, ObjectNode node) {

        if (value instanceof String) {
            node.put(key, (String) value);
        } else if (value instanceof Integer) {
            node.put(key, (Integer) value);
        } else {
            throw new IllegalArgumentException(String.format(UNSUPPORTED_CLASS_EXCEPTION, value.getClass().toString()));
        }
    }

    private static boolean hasKey(ObjectNode root, List<String> keys) {
        ObjectNode currentNode = root;

        for (String currentKey : keys) {
            if (currentNode.has(currentKey)) {
                currentNode = (ObjectNode) currentNode.get(currentKey);
            } else {
                return false;
            }
        }
        return true;
    }
}
