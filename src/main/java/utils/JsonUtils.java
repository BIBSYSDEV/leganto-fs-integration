package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class JsonUtils {

    public  static ObjectMapper mapper = jsonParser();
    public static ObjectWriter writer = mapper.writer();
    public static ObjectReader reader = mapper.reader();

    private JsonUtils(){}

    private static ObjectMapper jsonParser() {
        JsonFactory jsonFactory = new JsonFactory()
            .configure(Feature.ALLOW_COMMENTS, true)
            .configure(Feature.ALLOW_YAML_COMMENTS, true);
        return new ObjectMapper(jsonFactory);
    }


    public static String write(Object item) throws JsonProcessingException {
        return writer.writeValueAsString(item);
    }

    public static ObjectNode newObjectNode(){
       return  mapper.createObjectNode();
    }

    public static ArrayNode newArrayNode(){
        return mapper.createArrayNode();
    }


    public static ObjectNode putKeyInNode(String key,String value,ObjectNode  root) throws IOException {
        List<String> keys = Arrays.asList(key.split("\\."));
        ObjectNode currentNode=root;
        for(int i=0; i<keys.size()-1; i++){
            String currentKey=keys.get(i);
            if(!hasKey(root, keys.subList(0,i+1))) {
                currentNode.set(currentKey, JsonUtils.newObjectNode());
            }
            currentNode = (ObjectNode) currentNode.get(currentKey);
        }

        String currentKey=keys.get(keys.size()-1);
        currentNode.put(currentKey,value);
        return root;
    }



    private static boolean hasKey(ObjectNode root,List<String>keys) throws IOException {
        ObjectNode currentNode=root;

        for(int i=0;i<keys.size();i++){
            String currentKey=keys.get(i);
            if(currentNode.has(currentKey)){
                currentNode=(ObjectNode)currentNode.get(currentKey);
            }
            else{
                return false;
            }
        }
        return true;



    }
}
