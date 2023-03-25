package baseball.game;

import java.util.Objects;

public class GameStatus {
    public int ball;
    public int strike;

    public GameStatus(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameStatus that = (GameStatus) o;
        return ball == that.ball && strike == that.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }
}
