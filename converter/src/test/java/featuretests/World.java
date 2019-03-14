package featuretests;

import com.fasterxml.jackson.databind.node.ObjectNode;
import fs.user.ParticipantsFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.JsonUtils;

public class World {

    public static final int PREFIX = 0;
    public static final int SUFFIX = 1;
    private static final boolean APPEND_TRUE = true;
    private static final String PREFIX_SUFFIX_SEPARATOR_REGEX = "\\.";
    private ObjectNode userInput;

    private ObjectNode emneResponse;

    private File courseParticipants;


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

    public void initCoursePartcipants(String filename) throws IOException {
        String[] splitFilenname = filename.split(PREFIX_SUFFIX_SEPARATOR_REGEX);
        courseParticipants = new File(filename);
//        if (courseParticipants.exists()) {
//            courseParticipants.delete();
//        }
        courseParticipants.deleteOnExit();
    }

    public void addToCourseParticipants(String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(courseParticipants, APPEND_TRUE));
        writer.write(line);
        writer.flush();
        writer.close();
    }
}
