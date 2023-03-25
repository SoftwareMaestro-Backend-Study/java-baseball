package baseball.util;

import baseball.domain.GameNumber;
import baseball.domain.GameNumbers;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGenerator {

    private static final int THE_NUMBER_OF_GAME_NUMBER = 3;
    private static final String DELIMITER = "";

    private GameNumberGenerator() {
    }

    public static GameNumbers generate(String input) {
        List<GameNumber> gameNumbers = new ArrayList<>();
        validateTheNumberOf(input);
        for (String each : input.split(DELIMITER)) {
            int gameNumber = Convertor.toInteger(each);
            validateRange(gameNumber);
            gameNumbers.add(new GameNumber(gameNumber));
        }
        return new GameNumbers(gameNumbers);
    }

    private static void validateTheNumberOf(String input) {
        if (input.length() != THE_NUMBER_OF_GAME_NUMBER) {
            throw new IllegalArgumentException("3자리 값이 아닙니다.");
        }
    }

    private static void validateRange(int each) {
        if (each == 0) {
            throw new IllegalArgumentException("1~9 범위를 벗어나는 숫자가 포함되어 있습니다.");
        }
    }
}
