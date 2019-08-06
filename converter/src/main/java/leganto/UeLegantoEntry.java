package leganto;

import fs.common.Language;
import fs.common.UEmne;
import fs.personroller.UndervisningReference;
import fs.ua.SemesterCode;
import fs.ua.USemester;
import fs.ue.UeCourseTitleFormat;
import fs.ue.UndervisiningEntry;
import fs.user.Operation;
import fs.user.UserInput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UeLegantoEntry extends LegantoEntry {

  private static final String COURSE_CODE_DELIMITER = "-";
  private static final String UE_ID_PREFIX = "UE";
  private static final String UA_ID_PREFIX = "UA";
  private static final int PREVIOUS_YEAR = 1;

  private final transient UndervisiningEntry ue;
  private transient String[] id_seg;

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
        .toString());

    return String.join(DEFAULT_DELIMITER, UE_ID_PREFIX, suffix);
  }

  private String getCode() {
    String[] id_segs = getIdSegs();
    return id_segs[0] + COURSE_CODE_DELIMITER + id_segs[1];
  }

  private String getVersion() {
    String[] id_segs = getIdSegs();
    return id_segs[2];
  }

  private String[] getIdSegs() {
    if (id_seg == null){
      id_seg = ue.getHref().substring(ue.getHref().lastIndexOf('/') + 1 ).split(",");
    }
    return id_seg;
  }

  @Override
  public String getCourseTitle() {
    String emneNavn = Language.getValueForLanguagePref(emne.getNavn(), userInput.getLanguageOrder())
      .orElse(getRandomValue(emne.getNavn()));

    return UeCourseTitleFormat
      .fromInteger(userInput.getCourseTitleFormat())
      .formatUaCourseTitle(emneNavn,
        getCode(),
        ue.getSemester()
          .getSemesterCode(),
        ue.getSemester()
          .getYear());
  }

  @Override
  public String getSectionId() {
    return getUeEmne().getVersion();
  }

  @Override
  public String getTerm1() {
    return getUeSemester().getSemesterCode()
      .toEnglishString();
  }

  @Override
  public String getStartDate() {
    LocalDate startDate = getUeSemester().getSemesterCode()
      .semesterStartDate(getUeSemester().getYear());
    return dateToString(startDate);
  }

  @Override
  public String getEndDate() {

    int year = getUeSemester().getYear();
    if (SemesterCode.AUTUMN.equals(getUeSemester().getSemesterCode())) {
      year = getUeSemester().getYear() + 1;
    }

    LocalDate endDate = getUeSemester().getSemesterCode()
      .semesterEndDate(year);
    return dateToString(endDate);
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

    String searchableId3String = ue.getEmne()
      .getCode();

    return String.join(SEARCHABLE_IDS_DELIMITER, searchableId1String, searchableId2String, searchableId3String);
  }

  private List<String> searchableIdSuffix() {
    return Arrays.asList(
      organizationEntity.getInstitution()
        .toString(),
      getUeEmne().getCode(),
      getUeEmne().getVersion(),
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
      return ue.getEmne()
        .getVersion();
    } else {
      return EMPTY_STRING;
    }
  }

  @Override
  protected UndervisningReference undervisningsReference() {
    return new UndervisningReference(ue.getHref());
  }

  private UEmne getUeEmne() {
    return ue.getEmne();
  }

  private USemester getUeSemester() {
    return ue.getSemester();
  }
}
