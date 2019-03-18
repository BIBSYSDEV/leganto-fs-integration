package leganto;

import fs.common.Language;
import fs.common.UEmne;
import fs.emne.Emne;
import fs.ua.USemester;
import fs.ue.UndervisiningEntry;
import fs.user.UserInput;

public class UeLegantoEntry extends LegantoEntry {

    private static final String COURSE_CODE_DELIMITER = "-";
    private static final String INVALID_EMNE_ENTRY_MESSAGE = "Emne entry without navn field";
    private final transient UndervisiningEntry ue;
    private transient Emne emne;

    public UeLegantoEntry(UndervisiningEntry ue, UserInput userInput) {
        super(userInput);
        this.ue = ue;
    }

    public UeLegantoEntry setEmne(Emne emne) {
        this.emne = emne;
        return this;
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

    private UEmne getUeEmne() {
        return ue.getEmne();
    }

    private USemester getUeSemester() {
        return ue.getSemester();
    }
}
