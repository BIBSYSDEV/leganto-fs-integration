package fs.user;

import java.io.InputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import utils.IoUtils;

public class ParticipantsFile {

    public static final String CSV_DELIMITER = ";";
    private static final int COURSE_CODE_INDEX = 0;
    private static final int PARTICIPANTS_INDEX = 1;

    private final transient InputStream participantsDataStream;
    private transient Map<String, String> participantsMap;

    public ParticipantsFile(InputStream participantsDataStream) {
        this.participantsDataStream = participantsDataStream;
    }

    public ParticipantsFile init() {
        List<String> lines = streamAsList();
        Map<String, String> map = lines.stream()
            .map(this::splitLine)
            .collect(Collectors.toMap(SimpleEntry::getKey, SimpleEntry::getValue));
        participantsMap = Collections.unmodifiableMap(map);
        return this;
    }

    private List<String> streamAsList() {
        return IoUtils.streamAsList(participantsDataStream);
    }

    private SimpleEntry<String, String> splitLine(String line) {
        String[] tokens = line.split(CSV_DELIMITER);
        String courseCode = tokens[COURSE_CODE_INDEX];
        String participants = tokens[PARTICIPANTS_INDEX];
        return new SimpleEntry<>(courseCode, participants);
    }


    public Optional<String> getPartcipants(String courseCode) {
        return Optional.ofNullable(participantsMap.get(courseCode));
    }
}
