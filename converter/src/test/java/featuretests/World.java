package featuretests;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.List;
import utils.JsonUtils;

public class World {

    private ObjectNode userInput;

    private ObjectNode emneResponse;

    private List<String> courseParticipants;



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

    public void initCoursePartcipants() {
        courseParticipants = new ArrayList<>();
    }

    public void addToCourseParticipants(String line) {
        courseParticipants.add(line);
    }
}
