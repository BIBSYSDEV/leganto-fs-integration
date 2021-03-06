package leganto;

import fs.common.Language;
import fs.personroller.UndervisningReference;

import fs.ua.USemester;
import fs.ue.UeCourseTitleFormat;
import fs.ue.UndervisiningEntry;
import fs.user.Operation;
import fs.user.UserInput;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UeLegantoEntry extends LegantoEntry {

    private static final String COURSE_CODE_DELIMITER = "_";
    private static final String UE_ID_PREFIX = "UE";
    private static final String UA_ID_PREFIX = "UA";
    private static final int PREVIOUS_YEAR = 1;

    private final transient UndervisiningEntry ue;
    private transient String[] idSeg;

    public UeLegantoEntry(UndervisiningEntry ue, UserInput userInput) {
        super(userInput);
        this.ue = ue;
    }

    @Override
    public String getCourseCode() {
        return generateCourseCode(ue.getSemester()
            .getYear());
    }

    private String generateCourseCode(Integer year) {

        String suffix = String.join(COURSE_CODE_DELIMITER,
            getCode(),
            getVersion(),
            year.toString(),
            getUeSemester().getSemesterCode()
                .toString(),
            ue.getTerminNummer());

        return String.join(DEFAULT_DELIMITER, UE_ID_PREFIX, suffix);
    }

    private String getOnlyCode() {
        return getIdSegs()[1];
    }

    private String getCode() {
        String[] idSegs = getIdSegs();
        return idSegs[0] + COURSE_CODE_DELIMITER + idSegs[1];
    }

    private String getVersion() {
        return getIdSegs()[2];
    }

    private String[] getIdSegs() {
        if (idSeg == null) {
            String href = URLDecoder.decode(ue.getHref());
            idSeg = href
                .substring(href
                    .lastIndexOf('/') + 1)
                .split(",");
        }
        return idSeg;
    }

    @Override
    public String getCourseTitle() {
        String emneNavn = Language.getValueForLanguagePref(emne.getNavn(), userInput.getLanguageOrder())
            .orElse(getRandomValue(emne.getNavn()));

        return UeCourseTitleFormat
            .fromInteger(userInput.getCourseTitleFormat())
            .formatUaCourseTitle(emneNavn,
                getOnlyCode(),
                ue.getSemester()
                    .getSemesterCode(),
                ue.getSemester()
                    .getYear());
    }

    @Override
    public String getSectionId() {
        return getVersion();
    }

    @Override
    public String getTerm1() {
        return getUeSemester().getSemesterCode()
            .toEnglishString();
    }
    @Override
    public USemester getSemester(){
        return getUeSemester();
    }

    @Override
    public Integer getYear() {
        return getUeSemester().getYear();
    }

    @Override
    public String getAllSearchableIds() {

        List<String> searchableId1 = new ArrayList<>();
        searchableId1.add(UE_ID_PREFIX);
        searchableId1.addAll(searchableIdSuffix());
        String searchableId1String = String.join(DEFAULT_DELIMITER, searchableId1);

        List<String> searchableId2 = new ArrayList<>();
        searchableId2.add(UA_ID_PREFIX);
        searchableId2.addAll(searchableIdSuffix());
        String searchableId2String = String.join(DEFAULT_DELIMITER, searchableId2);

        String searchableId3String = getOnlyCode();

        return String.join(SEARCHABLE_IDS_DELIMITER, searchableId1String, searchableId2String, searchableId3String);
    }

    private List<String> searchableIdSuffix() {
        return Arrays.asList(
            getCode(),
            getVersion(),
            getYear().toString(),
            getUeSemester().getSemesterCode()
                .toString(),
            ue.getTerminNummer()
        );
    }

    @Override
    public String getNumberOfParticipants() {
        return userInput.getNumberOfParticipants(getCourseCode())
            .orElse(EMPTY_STRING);
    }

    @Override
    public String getOldCourseCode() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return generateCourseCode(getUeSemester().getYear() - PREVIOUS_YEAR);
        } else {
            return EMPTY_STRING;
        }
    }

    @Override
    public String getOldCourseSectionId() {
        if (Operation.ROLLOVER.equals(userInput.getOperation())) {
            return getVersion();
        } else {
            return EMPTY_STRING;
        }
    }

    @Override
    protected UndervisningReference undervisningsReference() {
        return new UndervisningReference(ue.getHref());
    }

    private USemester getUeSemester() {
        return ue.getSemester();
    }
}
