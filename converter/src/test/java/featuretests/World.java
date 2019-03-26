package featuretests;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import utils.JsonUtils;

public class World {

    public static final int PREFIX = 0;
    public static final int SUFFIX = 1;
    private static final boolean APPEND_TRUE = true;
    private static final String PREFIX_SUFFIX_SEPARATOR_REGEX = "\\.";

    private ObjectNode userInput;
    private ObjectNode emneResponse;
    private ObjectNode orgnanizationEntity;
    private ObjectNode personRoleEntry;
    private ObjectNode role;

    private File campusParticipantsFile;
    private File numberOfParticipantsFile;


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

    public void initCampusParticipants(String filename) {
        campusParticipantsFile = new File(filename);
        if (campusParticipantsFile.exists()) {
            campusParticipantsFile.delete();
        }
        campusParticipantsFile.deleteOnExit();
    }

    public void addToCourseParticipants(String line) throws IOException {
        addToFile(campusParticipantsFile, line);
    }

    private void addToFile(File file, String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, APPEND_TRUE));
        writer.write(line);
        writer.flush();
        writer.close();
    }

    public void addToNumberOfParticipantsFile(String line) throws IOException {
        addToFile(numberOfParticipantsFile, line);
    }

    public ObjectNode getOrganizationEntity() {
        return this.orgnanizationEntity;
    }

    public void setOrganizationEntity(ObjectNode objectNode) {
        this.orgnanizationEntity = objectNode;
    }

    public void initNumberOfParticipantsFile(String filename) {
        numberOfParticipantsFile = new File(filename);
        if (numberOfParticipantsFile.exists()) {
            numberOfParticipantsFile.delete();
        }
        numberOfParticipantsFile.deleteOnExit();
    }

    public void setPersonRoleEntry(ObjectNode personRoleEntry) {
        this.personRoleEntry = personRoleEntry;
    }

    public ArrayNode getPersonRolleEntries() {
        return this.personRoleEntry;
    }

    public ObjectNode getRole() {
        return role;
    }

    public void setRole(ObjectNode roleJson) {
        this.role = roleJson;
    }
}
