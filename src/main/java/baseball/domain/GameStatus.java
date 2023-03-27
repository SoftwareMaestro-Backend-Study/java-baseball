package baseball.domain;

import baseball.util.Convertor;

public class GameStatus {

    private static final int RESTART = 1;
    private static final int END = 2;

    private final int status;

    private GameStatus(int status) {
        validateRange(status);
        this.status = status;
    }

    public static GameStatus from(String input) {
        return new GameStatus(Convertor.toInteger(input));
    }

    public boolean isRestart() {
        return status == RESTART;
    }

    private static void validateRange(int status) {
        if (status != RESTART && status != END) {
            throw new IllegalArgumentException("1 또는 2 이외의 숫자가 포함되어 있습니다.");
        }
    }
}
