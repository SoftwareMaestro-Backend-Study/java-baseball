package baseball.util;

import baseball.domain.GameNumber;
import baseball.domain.GameNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameNumberGenerator {

    private static final String DELIMITER = "";

    private GameNumberGenerator() {
    }

    public static GameNumbers generate(String input) {
        List<GameNumber> gameNumbers = Arrays.stream(input.split(DELIMITER))
                .map(each -> new GameNumber(Convertor.toInteger(each)))
                .collect(Collectors.toList());
        return new GameNumbers(gameNumbers);
    }
}
