package baseball.util;

import baseball.domain.GameNumber;
import baseball.domain.GameNumbers;

import java.util.ArrayList;
import java.util.List;

public class GameNumberGenerator {

    private static final int THE_NUMBER_OF_GAME_NUMBER = 3;

    private GameNumberGenerator() {
    }

    public static GameNumbers generate(String input) {
        List<GameNumber> gameNumbers = new ArrayList<>();
        validateTheNumberOf(input);
        for (int i = 0; i < 3; i++) {
            int each = input.charAt(i) - '0';
            validateInteger(each);
            validateRange(each);
            gameNumbers.add(new GameNumber(each));
        }
        return new GameNumbers(gameNumbers);
    }

    private static void validateTheNumberOf(String input) {
        if (input.length() != THE_NUMBER_OF_GAME_NUMBER) {
            throw new IllegalArgumentException("3자리 값이 아닙니다.");
        }
    }

    private static void validateInteger(int each) {
        if (each < 0 || each > 9) {
            throw new IllegalArgumentException("정수가 아닌 값이 포함되어 있습니다.");
        }
    }

    private static void validateRange(int each) {
        if (each == 0) {
            throw new IllegalArgumentException("1~9 범위를 벗어나는 숫자가 포함되어 있습니다.");
        }
    }
}
