package fs.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import utils.IoUtils;

public class ParticipantsFile {

    private static final String CSV_DELIMITER = ",";
    private static final int COURSE_CODE_INDEX = 0;
    private static final int PARTICIPANTS_INDEX = 1;
    private static File participantsFile;
    private Map<String, String> participantsMap;

    public ParticipantsFile(String participantsFilename) {
        participantsFile = new File(participantsFilename);
    }

    public void init(String participantsFilename) throws FileNotFoundException {
        participantsFile = new File(participantsFilename);
        List<String> lines = fileAsList();
        Map<String, String> map = lines.stream()
            .map(this::splitLine)
            .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
        participantsMap = Collections.unmodifiableMap(map);
    }

    private List<String> fileAsList() throws FileNotFoundException {
        return IoUtils.fileAsList(participantsFile);
    }

    private SimpleEntry<String, String> splitLine(String line) {
        String[] tokens = line.split(CSV_DELIMITER);
        String courseCode = tokens[COURSE_CODE_INDEX];
        String participants = tokens[PARTICIPANTS_INDEX];
        return new SimpleEntry<>(courseCode, participants);
    }

    public Map<String, String> getParticipantsMap() {
        return participantsMap;
    }
}
