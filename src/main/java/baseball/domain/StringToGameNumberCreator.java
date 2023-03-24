package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToGameNumberCreator implements GameNumberCreator {

    private final String values;

    public StringToGameNumberCreator(String values) {
        this.values = values;
    }

    @Override
    public List<GameNumber> create() {
        return Arrays.stream(values.split(""))
                .map(this::parseInt)
                .map(GameNumber::new)
                .collect(Collectors.toList());
    }

    private Integer parseInt(String value) {
        try {
            return Integer.parseInt(values);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[ERROR] 입력값 %s는 숫자가 아닙니다.", value));
        }
    }
}
