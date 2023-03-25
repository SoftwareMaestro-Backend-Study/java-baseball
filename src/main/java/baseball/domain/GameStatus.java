package baseball.domain;

public class GameStatus {

    private static final int RESTART = 1;

    private int status;

    public GameStatus(int status) {
        this.status = status;
    }

    public boolean isRestart() {
        return status == RESTART;
    }
}
