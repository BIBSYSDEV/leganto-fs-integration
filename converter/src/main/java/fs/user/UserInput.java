package fs.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import fs.common.IgnoreValidable;
import fs.common.Language;
import fs.common.Validable;
import utils.JsonUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@SuppressWarnings("PMD.TooManyFields")
public class UserInput extends Validable {

    public static final String CAMPUS_PARTICIPANTS_FILE_FIELD = "campus_participants_file";
    public static final String NUMBER_OF_PARTICIPANTS_FILE = "number_of_participants_file";

    @JsonProperty("include_campus_participants")
    private Boolean includeCampusParticipants;

    @JsonProperty(CAMPUS_PARTICIPANTS_FILE_FIELD)
    private String campusParticipantsFilename;

    @JsonProperty("include_number_of_participants")
    private Boolean includeNumberOfParticipants;

    @JsonProperty(NUMBER_OF_PARTICIPANTS_FILE)
    private String numberOfParticipantsFilename;

    @JsonProperty(value = "operation", defaultValue = "NORMAL")
    private Operation operation;

    @JsonProperty(value = "include_institute_in_acad_department", required = true)
    private Boolean includeInstitute;

    @JsonProperty("language_order")
    private List<Language> languageOrder;

    @JsonProperty("course_title_format")
    private Integer courseTitleFormat;

    @JsonProperty("include_ua")
    private Boolean includeUA;

    @JsonProperty("role_codes")
    private List<String> roleCodes;

    @JsonProperty("ims_codes")
    private List<Integer> imsCodes = new ArrayList<>();

    @JsonProperty("feide_domain")
    private String feideDomain;

    @JsonProperty(value = "start_dato_modifier", defaultValue = "0")
    private Integer startDateModifier;

    @JsonProperty(value = "slutt_dato_modifier", defaultValue = "0")
    private Integer endDateModifier;

    @JsonIgnore
    private transient ParticipantsFile campusParticipantsFile;

    @JsonIgnore
    private transient ParticipantsFile numberOfPartipantsFile;

    public UserInput() {
        super();
        this.operation = Operation.NORMAL;
    }

    public static UserInput fromJson(String emneJson) throws IOException {
        return JsonUtils.mapper.readValue(emneJson, UserInput.class);
    }

    public List<Language> getLanguageOrder() {
        return languageOrder;
    }

    public UserInput setLanguageOrder(List<Language> languageOrder) {
        this.languageOrder = languageOrder;
        return this;
    }

    public UserInput initFiles() throws IOException {
        InputStream campusParticipantsInputStream = null;
        InputStream numberOfParticipantsInputStream = null;

        if (includeCampusParticipants) {
            File campusParticipantsFile = new File(campusParticipantsFilename);
            campusParticipantsInputStream = new BufferedInputStream(
                Files.newInputStream(campusParticipantsFile.toPath()));
        }

        if (includeNumberOfParticipants) {
            File numberOfParticipantsFile = new File(numberOfParticipantsFilename);
            numberOfParticipantsInputStream = new BufferedInputStream(
                Files.newInputStream(numberOfParticipantsFile.toPath()));
        }

        initFiles(campusParticipantsInputStream, numberOfParticipantsInputStream);
        return this;
    }

    public UserInput initFiles(InputStream campusParticipnatsInputStream, InputStream numberOfParticipantsInputSteam) {
        if (campusParticipnatsInputStream != null) {
            BufferedInputStream campusParticipantsStream = new BufferedInputStream(campusParticipnatsInputStream);
            campusParticipantsFile = new ParticipantsFile(campusParticipantsStream).init();
        }
        if (numberOfParticipantsInputSteam != null) {
            BufferedInputStream numberOfParticipantsStream = new BufferedInputStream(numberOfParticipantsInputSteam);
            numberOfPartipantsFile = new ParticipantsFile(numberOfParticipantsStream).init();
        }
        return this;
    }

    @JsonIgnore
    public Optional<String> getCampusParticipants(String courseCode) {

        if (includeCampusParticipants) {
            Objects.requireNonNull(campusParticipantsFile,
                "campus participants file not read. Call initParticipants first");

            return campusParticipantsFile.getPartcipants(courseCode);
        } else {
            return Optional.empty();
        }
    }

    @JsonIgnore
    public Optional<String> getNumberOfParticipants(String courseCode) {

        if (includeNumberOfParticipants && Objects.nonNull(numberOfPartipantsFile)) {
            return numberOfPartipantsFile.getPartcipants(courseCode);
        } else {
            return Optional.empty();
        }
    }

    public String getCampusParticipantsFilename() {
        return campusParticipantsFilename;
    }

    public UserInput setCampusParticipantsFilename(String participantsFile) {
        this.campusParticipantsFilename = participantsFile;
        return this;
    }

    @SuppressWarnings("PMD")
    public Boolean getIncludeCampusParticipants() {
        return includeCampusParticipants;
    }

    public UserInput setIncludeCampusParticipants(Boolean includeCampusParticipants) {
        this.includeCampusParticipants = includeCampusParticipants;
        return this;
    }

    public Operation getOperation() {
        return operation;
    }

    public UserInput setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    @SuppressWarnings("PMD")
    public Boolean getIncludeInstitute() {
        return includeInstitute;
    }

    public UserInput setIncludeInstitute(Boolean includeInstitute) {
        this.includeInstitute = includeInstitute;
        return this;
    }

    @SuppressWarnings("PMD")
    public Boolean getIncludeNumberOfParticipants() {
        return includeNumberOfParticipants;
    }

    public UserInput setIncludeNumberOfParticipants(Boolean includeNumberOfParticipants) {
        this.includeNumberOfParticipants = includeNumberOfParticipants;
        return this;
    }

    public String getNumberOfParticipantsFilename() {
        return numberOfParticipantsFilename;
    }

    public UserInput setNumberOfParticipantsFilename(String numberOfParticipantsFilename) {
        this.numberOfParticipantsFilename = numberOfParticipantsFilename;
        return this;
    }

    public Integer getCourseTitleFormat() {
        return courseTitleFormat;
    }

    public UserInput setCourseTitleFormat(Integer courseTitleFormat) {
        this.courseTitleFormat = courseTitleFormat;
        return this;
    }

    public List<String> getRoleCodes() {
        return roleCodes;
    }

    public UserInput setRoleCodes(List<String> roleCodes) {
        this.roleCodes = roleCodes;
        return this;
    }

    public List<Integer> getImsCodes() {
        return imsCodes;
    }

    public UserInput setImsCodes(List<Integer> roleCodes) {
        this.imsCodes = roleCodes;
        return this;
    }

    @SuppressWarnings("PMD")
    public Boolean getIncludeUA() {
        return includeUA;
    }

    public UserInput setIncludeUA(Boolean includeUA) {
        this.includeUA = includeUA;
        return this;
    }

    @IgnoreValidable
    public String getFeideDomain() {
        return feideDomain;
    }

    public void setFeideDomain(String feideDomain) {
        this.feideDomain = feideDomain;
    }

    @IgnoreValidable
    public Integer getStartDateModifier() { return startDateModifier; }

    public UserInput setStartDateModifier(Integer dateModifier) { startDateModifier = dateModifier; return this; }

    @IgnoreValidable
    public Integer getEndDateModifier() { return endDateModifier; }

    public UserInput setEndDateModifier(Integer dateModifier) { endDateModifier = dateModifier; return this; }
}
