package baseball.domain;

import java.util.Arrays;

public enum GameResult {
    ZERO(0, 0),
    ZERO_STRIKE_ONE_BALL(0, 1),
    ZERO_STRIKE_TWO_BALL(0, 2),
    ZERO_STRIKE_THREE_BALL(0, 3),
    ONE_STRIKE_ZERO_BALL(1, 0),
    ONE_STRIKE_ONE_BALL(1, 1),
    ONE_STRIKE_TWO_BALL(1, 2),
    TWO_STRIKE_ZERO_BALL(2, 0),
    TWO_STRIKE_ONE_BALL(2, 1),
    THREE_STRIKE(3, 0);

    private final int strike;
    private final int ball;

    GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GameResult find(int strike, int ball) {
        return Arrays.stream(GameResult.values())
                .filter(gameResult -> gameResult.strike == strike && gameResult.ball == ball)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("[ERROR] %d 스트라이크 %d 볼에 해달하는 결과는 존재하지 않습니다.", strike, ball)));
    }

    public boolean isEnd() {
        return this == THREE_STRIKE;
    }

    public String getResultComment() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder answer = new StringBuilder();
        if (ball != 0) {
            answer.append(ball);
            answer.append("볼 ");
        }

        if (strike != 0) {
            answer.append(strike);
            answer.append("스트라이크");
        }

        return answer.toString();
    }
}
