package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public final class IoUtils {

    private static final int END_OF_STREAM = -1;

    private IoUtils() {
    }

    public static InputStream resourceAsStream(Path path) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(path.toString());
    }

    public static List<String> resourceAsList(Path path) {
        List<String> list = new BufferedReader(new InputStreamReader(resourceAsStream(path)))
            .lines()
            .collect(Collectors.toList());

        return list;
    }

    public static String resourceAsString(Path path) {
        return String.join(System.lineSeparator(), resourceAsList(path));
    }

    public static List<String> streamAsList(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream))
            .lines().collect(Collectors.toList());
    }

    public static InputStream emptyStream() {
        return new InputStream() {
            @Override
            public int read() throws IOException {
                return END_OF_STREAM;
            }
        };
    }
}
