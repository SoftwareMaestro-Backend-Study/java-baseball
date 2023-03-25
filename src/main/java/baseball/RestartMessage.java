package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RestartMessage {

    private static final String RESTART_MESSAGE = "1";
    private static final String END_MESSAGE = "2";
    private static final Pattern PATTERN = Pattern.compile(String.format("[%s%s]", RESTART_MESSAGE, END_MESSAGE));
    private final String value;

    public RestartMessage(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        final Matcher matcher = PATTERN.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format("[ERROR] 재시작 입력 값은 %s 일 수 없습니다.", value));
        }
    }

    public boolean isEnd() {
        return this.value.equals(END_MESSAGE);
    }
}
