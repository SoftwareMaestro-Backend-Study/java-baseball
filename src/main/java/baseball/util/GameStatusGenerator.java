package baseball.util;

import baseball.domain.GameStatus;

public class GameStatusGenerator {

    public static final int THE_NUMBER_OF_GAME_STATUS = 1;

    private GameStatusGenerator() {
    }

    public static GameStatus generate(String input) {
        validateTheNumberOf(input);
        int status = Convertor.toInteger(input);
        validateRange(status);
        return new GameStatus(status);
    }

    private static void validateTheNumberOf(String input) {
        if (input.length() != THE_NUMBER_OF_GAME_STATUS) {
            throw new IllegalArgumentException("1자리 값이 아닙니다.");
        }
    }

    private static void validateRange(int status) {
        if (status != 1 && status != 2) {
            throw new IllegalArgumentException("1 또는 2 이외의 숫자가 포함되어 있습니다.");
        }
    }
}
