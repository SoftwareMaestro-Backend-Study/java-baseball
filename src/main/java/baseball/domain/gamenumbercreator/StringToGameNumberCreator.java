package baseball.domain.gamenumbercreator;

import baseball.domain.GameNumber;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToGameNumberCreator implements GameNumberCreator {

    private final String values;

    public StringToGameNumberCreator(String values) {
        this.values = values;
    }

    @Override
    public List<GameNumber> create(int maxLength) {
        validteLength(maxLength);

        return Arrays.stream(values.split(""))
                .map(this::parseInt)
                .map(GameNumber::new)
                .collect(Collectors.toList());
    }

    private void validteLength(int maxLength) {
        if (values.length() != maxLength) {
            throw new IllegalArgumentException(String.format("[ERROR] %s는 %d 자리수가 아닙니다.", values, maxLength));
        }
    }

    private Integer parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("[ERROR] 입력값 %s는 숫자가 아닙니다.", value));
        }
    }
}
