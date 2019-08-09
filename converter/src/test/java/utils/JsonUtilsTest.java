package utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;
import static utils.JsonUtils.hasKey;
import static utils.JsonUtils.newObjectNode;
import static utils.JsonUtils.putKeyInNode;
import static utils.JsonUtils.traverseCompositeKey;
import static utils.JsonUtils.write;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JsonUtilsTest {

    private static final String KEY_DELIMITER = ".";
    private static final String KEY_1 = "key1";
    private static final String KEY_2 = "key2";
    private static final String KEY_3A = "key3";
    private static final String KEY_A = String.join(KEY_DELIMITER, KEY_1, KEY_2, KEY_3A);
    private static final String KEY_3B = "key4";
    private static final String KEY_B = String.join(KEY_DELIMITER, KEY_1, KEY_2, KEY_3B);
    private static final String KEY_A_VALUE = "valueA";
    private static final String KEY_B_VALUE = "valueB";
    private static final double UNSUPPORTED_CLASS = 3.4;
    private static final String NON_EXISTING_KEY = String.join(KEY_DELIMITER, KEY_1, "nonexisting");

    @Test
    public void putKeyInNodeShouldPutASingleKeyInTheObjectNode() {
        ObjectNode root = newObjectNode();
        String key = "key";
        String value = "value";
        putKeyInNode(root, key, value);
        String actualValue = root.get(key)
            .asText();

        assertThat(actualValue, is(equalTo(value)));
    }

    @Test
    public void putKeyInNodeShouldPutAnIntegerValueInTheObjectNode() {
        ObjectNode root = newObjectNode();
        String key = "key";
        int value = 1;
        putKeyInNode(root, key, value);
        int actualValue = root.get(key)
            .asInt();

        assertThat(actualValue, is(equalTo(value)));
    }

    @Test
    public void putKeyInNodeShouldPutAnBooleanValueKeyInTheObjectNode() {
        ObjectNode root = newObjectNode();
        String key = "key";
        boolean value = true;
        putKeyInNode(root, key, value);
        boolean actualValue = root.get(key)
            .asBoolean();

        assertThat(actualValue, is(equalTo(value)));
    }

    @Test
    public void putMultipleKeyInNodeShouldPutAMutlipleKeyInTheObjectNode() {
        ObjectNode root = newObjectNode();

        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        String actualValue = root.get(KEY_1)
            .get(KEY_2)
            .get(KEY_3A)
            .asText();
        assertThat(actualValue, is(equalTo(KEY_A_VALUE)));
    }

    @Test
    public void putMKeyInNodeShouldMaintainCommonParentsInKeysInTheObjectNode() {
        ObjectNode root = newObjectNode();

        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        putKeyInNode(root, KEY_B, KEY_B_VALUE);
        String actualValueA = root.get(KEY_1)
            .get(KEY_2)
            .get(KEY_3A)
            .asText();
        assertThat(actualValueA, is(equalTo(KEY_A_VALUE)));
        String actualValueB = root.get(KEY_1)
            .get(KEY_2)
            .get(KEY_3B)
            .asText();
        assertThat(actualValueB, is(equalTo(KEY_B_VALUE)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void putMKeyInNodeShouldThrowExceptionForUnsupportedClasses() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, UNSUPPORTED_CLASS);

    }

    @Test
    public void hasKeyShouldReturnTrueForExistingKeys() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        assertThat(hasKey(root, KEY_A), is(equalTo(true)));
    }

    @Test
    public void hasKeyShouldReturnFalseForNonExistingLeafLevelKey() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        assertThat(hasKey(root, KEY_B), is(equalTo(false)));
    }

    @Test
    public void hasKeyShouldReturnFalseForNonExistingNonLeafLevelKey() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);

        assertThat(hasKey(root, NON_EXISTING_KEY), is(equalTo(false)));
    }

    @Test
    public void removeKeyFromNodeShouldDoNothingIfKeyDoesNotExist() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        JsonUtils.removeKeyFromNode(root, KEY_B);
        assertThat(JsonUtils.hasKey(root, KEY_A), is(equalTo(true)));
        assertThat(JsonUtils.hasKey(root, KEY_B), is(equalTo(false)));
    }

    @Test
    public void removeKeyFromNodeShouldRemoveKeyIfKeyExists() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        putKeyInNode(root, KEY_B, KEY_B_VALUE);
        JsonUtils.removeKeyFromNode(root, KEY_B);
        assertThat(JsonUtils.hasKey(root, KEY_A), is(equalTo(true)));
        assertThat(JsonUtils.hasKey(root, KEY_B), is(equalTo(false)));
    }

    @Test
    public void putElementArrayInNodeShouldCreateAnArrayNodeForTheKey() {
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

    @Test
    public void traverseCompositeKeyShouldFindExistingCompositeKey() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        JsonNode value = traverseCompositeKey(root, KEY_A);
        assertThat(value.asText(), is(equalTo(KEY_A_VALUE)));
    }

    @Test
    public void traverseCompositeKeyShouldReturnNullForNonExistingKeys() {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        JsonNode value = traverseCompositeKey(root, KEY_B);
        assertThat(value, is(equalTo(null)));
    }

    @Test
    public void writeShouldWriteAnObjectAsAString() throws JsonProcessingException {
        ObjectNode root = newObjectNode();
        putKeyInNode(root, KEY_A, KEY_A_VALUE);
        String jsonString = write(root);
        assertThat(jsonString, containsString(KEY_1));
        assertThat(jsonString, containsString(KEY_2));
        assertThat(jsonString, containsString(KEY_3A));
        assertThat(jsonString, containsString(KEY_A_VALUE));
    }

    private void assertAllElementsInArrayElementAreContainedInInputLIst(List<ObjectNode> nodeList,
                                                                        ArrayNode node) {
        for (int i = 0; i < node.size(); i++) {
            ObjectNode arrayElement = (ObjectNode) node.get(i);
            assertThat(nodeList.contains(arrayElement), is(equalTo(true)));
        }
    }
}
