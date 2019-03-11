package utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static utils.JsonUtils.hasKey;
import static utils.JsonUtils.newObjectNode;
import static utils.JsonUtils.putKeyInNode;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class JsonUtilsTest {

    private static final String KEY_DELIMITER = ".";
    private static final String KEY_1 = "key1";
    private static final String KEY_2 = "key2";
    private static final String KEY_3A = "key3";
    private static final String KEY_A = String.join(".", KEY_1, KEY_2, KEY_3A);
    private static final String KEY_3B = "key4";
    private static final String KEY_B = String.join(".", KEY_1, KEY_2, KEY_3B);
    private static final String KEY_A_VALUE = "valueA";
    private static final String KEY_B_VALUE = "valueB";

    @Test
    void putKeyInNodeShouldPutASingleKeyInTheObjectNode() {
        ObjectNode root = newObjectNode();
        String key = "key";
        String value = "value";
        putKeyInNode(root, key, value);
        String actualValue = root.get(key).asText();
        assertThat(actualValue, is(equalTo(value)));
    }

    @Test
    void putMultipleKeyInNodeShouldPutAMutlipleeKeyInTheObjectNode() {
        ObjectNode root = newObjectNode();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key = String.join(".", key1, key2, key3);
        String value = "value";
        putKeyInNode(root, key, value);
        String actualValue = root.get(key1).get(key2).get(key3).asText();
        assertThat(actualValue, is(equalTo(value)));
    }

    @Test
    void putMKeyInNodeShouldMaintainCommonParentsInKeysInTheObjectNode() {
        ObjectNode root = newObjectNode();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";

        String keyA = String.join(KEY_DELIMITER, key1, key2, key3);
        String keyB = String.join(".", key1, key2, key4);

        String valueA = "valueA";
        String valueB = "valueB";
        putKeyInNode(root, keyA, valueA);
        putKeyInNode(root, keyB, valueB);
        String actualValueA = root.get(key1).get(key2).get(key3).asText();
        assertThat(actualValueA, is(equalTo(valueA)));
        String actualValueB = root.get(key1).get(key2).get(key4).asText();
        assertThat(actualValueB, is(equalTo(valueB)));
    }

    @Test
    void removeKeyFromNodeShouldDoNothingIfKeyDoesNotExist() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        JsonUtils.removeKeyFromNode(root, KEY_B);
        assertThat(JsonUtils.hasKey(root, KEY_A), is(equalTo(true)));
        assertThat(JsonUtils.hasKey(root, KEY_B), is(equalTo(false)));
    }

    @Test
    void removeKeyFromNodeShouldDoRemoveKeyIfKeyExists() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        putKeyInNode(root, KEY_B, KEY_B_VALUE);
        JsonUtils.removeKeyFromNode(root, KEY_B);
        assertThat(JsonUtils.hasKey(root, KEY_A), is(equalTo(true)));
        assertThat(JsonUtils.hasKey(root, KEY_B), is(equalTo(false)));
    }

    @Test
    void putElementArrayInNodeShouldCreateAnArrayNodeForTheKey() {
        ObjectNode root = newObjectNode();
        ObjectNode node1 = newObjectNode().put(KEY_3A, KEY_A_VALUE);
        ObjectNode node2 = newObjectNode().put(KEY_3B, KEY_B_VALUE);
        String key = String.join(JsonUtils.JSON_FIELDS_DELIMITER, KEY_1, KEY_2);
        List<ObjectNode> nodeList = new ArrayList<>();
        nodeList.add(node1);
        nodeList.add(node2);
        JsonUtils.putElementArrayInNode(root, key, nodeList);

        assertThat(hasKey(root, key), is(equalTo(true)));

        ArrayNode node = (ArrayNode) JsonUtils.traverseCompositeKey(root, key);
        assertThat(node.size(), is(equalTo(nodeList.size())));

        assertAllElementsInArrayElementAreContainedInInputLIst(nodeList, node);
    }

    private void assertAllElementsInArrayElementAreContainedInInputLIst(List<ObjectNode> nodeList, ArrayNode node) {
        for (int i = 0; i < node.size(); i++) {
            ObjectNode arrayElement = (ObjectNode) node.get(i);
            assertThat(nodeList.contains(arrayElement), is(equalTo(true)));
        }
    }
}
