package utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class JsonUtilsTest {

    private static final String KEY_DELIMITER = ".";

    @Test
    void putKeyInNodeShouldPutASingleKeyInTheObjectNode() throws IOException {
        ObjectNode root = JsonUtils.newObjectNode();
        String key = "key";
        String value = "value";
        root = JsonUtils.putKeyInNode(key, value, root);
        String actualValue = root.get(key).asText();
        assertThat(actualValue, is(equalTo(value)));
    }

    @Test
    void putMultipleKeyInNodeShouldPutAMutlipleeKeyInTheObjectNode() throws IOException {
        ObjectNode root = JsonUtils.newObjectNode();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key = String.join(".", key1, key2, key3);
        String value = "value";
        root = JsonUtils.putKeyInNode(key, value, root);
        String actualValue = root.get(key1).get(key2).get(key3).asText();
        assertThat(actualValue, is(equalTo(value)));
    }

    @Test
    void putMKeyInNodeShouldMaintainCommonParentsInKeysInTheObjectNode() throws IOException {
        ObjectNode root = JsonUtils.newObjectNode();
        String key1 = "key1";
        String key2 = "key2";
        String key3 = "key3";
        String key4 = "key4";

        String keyA = String.join(KEY_DELIMITER, key1, key2, key3);
        String keyB = String.join(".", key1, key2, key4);

        String valueA = "valueA";
        String valueB = "valueB";
        root = JsonUtils.putKeyInNode(keyA, valueA, root);
        root = JsonUtils.putKeyInNode(keyB, valueB, root);
        String actualValueA = root.get(key1).get(key2).get(key3).asText();
        assertThat(actualValueA, is(equalTo(valueA)));
        String actualValueB = root.get(key1).get(key2).get(key4).asText();
        assertThat(actualValueB, is(equalTo(valueB)));
    }
}
