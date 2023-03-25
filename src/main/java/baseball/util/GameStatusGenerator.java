package baseball.util;

import baseball.domain.GameStatus;

public class GameStatusGenerator {

    public static final int THE_NUMBER_OF_GAME_STATUS = 1;

    private GameStatusGenerator() {
    }

    public static GameStatus generate(String input) {
        validateTheNumberOf(input);
        int status = input.charAt(0) - '0';
        validateInteger(status);
        validateRange(status);
        return new GameStatus(status);
    }

    private static void validateTheNumberOf(String input) {
        if (input.length() != THE_NUMBER_OF_GAME_STATUS) {
            throw new IllegalArgumentException("1자리 값이 아닙니다.");
        }
    }

    private static void validateInteger(int status) {
        if (status < 0 || status > 9) {
            throw new IllegalArgumentException("정수가 아닌 값이 포함되어 있습니다.");
        }
    }

    private static void validateRange(int status) {
        if (status != 1 && status != 2) {
            throw new IllegalArgumentException("1 또는 2 이외의 숫자가 포함되어 있습니다.");
        }
    }
}
