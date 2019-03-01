package utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonUtils {

    public  static ObjectMapper mapper = jsonParser();
    public static ObjectWriter writer = mapper.writer();
    public static ObjectReader reader = mapper.reader();

    private static ObjectMapper jsonParser() {
        JsonFactory jsonFactory = new JsonFactory()
            .configure(Feature.ALLOW_COMMENTS, true)
            .configure(Feature.ALLOW_YAML_COMMENTS, true);
        return new ObjectMapper(jsonFactory);
    }


    public static ObjectNode newObjectNode(){
       return  mapper.createObjectNode();
    }

    public static ArrayNode newArrayNode(){
        return mapper.createArrayNode();
    }
}
