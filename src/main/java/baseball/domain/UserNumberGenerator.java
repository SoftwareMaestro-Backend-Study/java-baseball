package baseball.domain;

import baseball.util.Convertor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserNumberGenerator implements GameNumberGenerator {

    private static final String DELIMITER = "";

    private final String input;

    public UserNumberGenerator(String input) {
        this.input = input;
    }

    public List<GameNumber> generate(int limit) {
        String[] inputNumbers = input.split(DELIMITER);
        validateTheNumberOf(inputNumbers, limit);
        return Arrays.stream(inputNumbers)
                .map(Convertor::toInteger)
                .map(GameNumber::from)
                .collect(Collectors.toList());
    }

    private void validateTheNumberOf(String[] inputNumbers, int limit) {
        if (inputNumbers.length != limit) {
            throw new IllegalArgumentException(String.format("%d자리 값이 아닙니다.", limit));
        }
    }
}
