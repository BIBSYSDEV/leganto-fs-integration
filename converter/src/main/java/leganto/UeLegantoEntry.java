package leganto;

import fs.common.Language;
import fs.common.UEmne;
import fs.ua.USemester;
import fs.ue.UndervisiningEntry;
import fs.user.UserInput;

public class UeLegantoEntry extends LegantoEntry {

    private static final String COURSE_CODE_DELIMITER = "-";
    private final transient UndervisiningEntry ue;

    public UeLegantoEntry(UndervisiningEntry ue, UserInput userInput) {
        super(userInput);
        this.ue = ue;
    }

    @Override
    public String getCourseCode() {
        return String.join(COURSE_CODE_DELIMITER,
            getUeEmne().getCode(),
            getUeEmne().getVersion(),
            getUeSemester().getYear().toString(),
            getUeSemester().getSemesterCode().toString());
    }

    @Override
    public String getCourseTitle() {
        return Language
            .getValueForLanguagePref(emne.getNavn(), userInput.getLanguageOrder())
            .orElse(getRandomValue(emne.getNavn()));
    }

    @Override
    public String getSectionId() {
        return getUeEmne().getVersion();
    }

    private UEmne getUeEmne() {
        return ue.getEmne();
    }

    private USemester getUeSemester() {
        return ue.getSemester();
    }
}
