package featuretests;

import com.fasterxml.jackson.databind.node.ObjectNode;
import utils.JsonUtils;

public class World {

    private ObjectNode userInput;

    private ObjectNode emneResponse;


    public World() {
        userInput = JsonUtils.newObjectNode();
    }

    public ObjectNode getUserInput() {
        return userInput;
    }

    public void setUserInput(ObjectNode userInput) {
        this.userInput = userInput;
    }

    public ObjectNode getEmneResponse() {
        return emneResponse;
    }

    public void setEmneResponse(ObjectNode emneResponse) {
        this.emneResponse = emneResponse;
    }
}
