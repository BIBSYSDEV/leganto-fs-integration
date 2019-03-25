package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class JsonUtils {

    public static final String JSON_FIELDS_DELIMITER = ".";
    private static final String UNSUPPORTED_CLASS_EXCEPTION = "Class %s is not yet supported. Add it in JsonTools";
    private static final int EXCLUDE_LAST_KEY = 1;
    private static final String JSON_FIELDS_SPlIT_REGEX = "\\.";
    public static ObjectMapper mapper = jsonParser();
    private static ObjectWriter writer = mapper.writer();

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

    public static <T> ObjectNode putKeyInNode(ObjectNode root, String key, T value) {
        List<String> keys = Arrays.asList(key.split(JSON_FIELDS_SPlIT_REGEX));
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

    private static <T> ObjectNode putKey(String key, T value, ObjectNode node) {

        if (value instanceof String) {
            node.put(key, (String) value);
        } else if (value instanceof Integer) {
            node.put(key, (Integer) value);
        } else if (value instanceof Boolean) {
            node.put(key, (Boolean) value);
        } else if (value instanceof ArrayNode) {
            node.set(key, (ArrayNode) value);
        } else {
            throw new IllegalArgumentException(String.format(UNSUPPORTED_CLASS_EXCEPTION, value.getClass().toString()));
        }
        return node;
    }

    public static boolean hasKey(ObjectNode root, String key) {
        List<String> keys = Arrays.asList(key.split(JSON_FIELDS_SPlIT_REGEX));
        return hasKey(root, keys);
    }

    private static boolean hasKey(ObjectNode root, List<String> keys) {
        ObjectNode currentNode = root;

        for (int i = 0; i < keys.size() - EXCLUDE_LAST_KEY; i++) {
            String currentKey = keys.get(i);
            if (currentNode.has(currentKey)) {
                currentNode = (ObjectNode) currentNode.get(currentKey);
            } else {
                return false;
            }
        }
        String lastKey = keys.get(keys.size() - 1);
        return currentNode.has(lastKey);
    }

    public static JsonNode traverseCompositeKey(ObjectNode root, String key) {
        List<String> keys = Arrays.asList(key.split(JSON_FIELDS_SPlIT_REGEX));
        return traverseCompositeKey(root, keys);
    }

    private static JsonNode traverseCompositeKey(ObjectNode root, List<String> keys) {
        JsonNode current = root;
        for (String currentKey : keys) {
            current = current.get(currentKey);
        }
        return current;
    }

    public static ObjectNode removeKeyFromNode(ObjectNode root, String key) {
        if (hasKey(root, key)) {
            List<String> keys = Arrays.asList(key.split(JSON_FIELDS_SPlIT_REGEX));
            List<String> secondToLastKey = keys.subList(0, keys.size() - EXCLUDE_LAST_KEY);
            ObjectNode parent = (ObjectNode) traverseCompositeKey(root, secondToLastKey);
            String lastKey = keys.get(keys.size() - 1);
            parent.remove(lastKey);
        }
        return root;
    }

    public static ObjectNode putElementArrayInNode(ObjectNode root, String key, List<ObjectNode> arrayValues) {
        ArrayNode arrayNode = newArrayNode();
        putKeyInNode(root, key, arrayNode);
        arrayValues.forEach(arrayNode::add);
        return root;
    }

    public static <T> T readValue(ObjectNode root, Class<T> clazz) throws JsonProcessingException {
        return mapper.treeToValue(root, clazz);

    }

    public static <T> T readValue(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);

    }
}
