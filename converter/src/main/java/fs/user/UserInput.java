package fs.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.Language;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserInput {

    public static final String PARTICIPANTS_FILE_FIELD = "participants_file";

    @JsonProperty("campus_participants")
    private List<String> campuses;

    @JsonProperty("participants_file")
    private String participantsFilename;

    @JsonProperty(value = "operation", defaultValue = "OTHER")
    private Operation operation;

    @JsonProperty("include_institute_in_acad_department")
    private String includeInstitut;

    @JsonIgnore
    private transient ParticipantsFile participantsFile;

    @JsonProperty("language_order")
    private List<Language> languageOrder;

    public UserInput() {
        this.operation = Operation.OTHER;
    }

    public List<Language> getLanguageOrder() {
        return languageOrder;
    }

    public UserInput setLanguageOrder(List<Language> languageOrder) {
        this.languageOrder = languageOrder;
        return this;
    }

    public UserInput initPartcipants() throws IOException {
        File file = new File(participantsFilename);
        BufferedInputStream inputStream = new BufferedInputStream(
            Files.newInputStream(file.toPath()));
        initPartcipants(inputStream);
        return this;
    }

    public UserInput initPartcipants(InputStream inputStream) throws FileNotFoundException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        participantsFile = new ParticipantsFile(bis);
        participantsFile.init();
        return this;
    }

    public List<String> getCampuses() {
        return campuses;
    }

    public UserInput setCampuses(List<String> campuses) {
        this.campuses = campuses;
        return this;
    }

    @JsonIgnore
    public Optional<String> getParticipants(String courseCode) {
        Objects.requireNonNull(participantsFile,
            "participants file not read. Call initParticipants first");
        return participantsFile.getPartcipants(courseCode);
    }

    public UserInput setParticipantsFilename(String participantsFile) {
        this.participantsFilename = participantsFile;
        return this;
    }

    public String getParticipantsFilename() {
        return participantsFilename;
    }

    public Operation getOperation() {
        return operation;
    }

    public UserInput setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public String getIncludeInstitut() {
        return includeInstitut;
    }

    public void setIncludeInstitut(String includeInstitut) {
        this.includeInstitut = includeInstitut;
    }
}
