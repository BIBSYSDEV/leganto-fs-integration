package fs.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInput {

    public static final String PARTICIPANTS_FILE_FIELD = "participants_file";


    @JsonProperty("campus_participants")
    private List<String> campuses;


    @JsonProperty("participants_file")
    private String participantsFilename;

    @JsonIgnore
    private transient ParticipantsFile participantsFile;
    @JsonIgnore
    private transient List<Language> languageOrder;

    public List<String> getLanguageOrder() {
        return languageOrder.stream()
            .map(Language::toString).collect(Collectors.toList());
    }

    @JsonProperty("language_order")
    public UserInput setLanguageOrder(List<String> languageOrder) {
        this.languageOrder = languageOrder.stream()
            .map(Language::fromString)
            .collect(Collectors.toList());
        return this;
    }

    public UserInput initPartcipants() throws IOException {
        File file = new File(participantsFilename);
        BufferedInputStream inputStream = new BufferedInputStream(
            Files.newInputStream(file.toPath()));
        participantsFile = new ParticipantsFile(inputStream);
        participantsFile.init();
        return this;
    }

    public UserInput initPartcipants(InputStream inputStream) throws FileNotFoundException {
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        participantsFile = new ParticipantsFile(bis);
        participantsFile.init();
        return this;
    }


    @JsonIgnore
    public List<Language> getLanguages() {
        return languageOrder;
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
}
