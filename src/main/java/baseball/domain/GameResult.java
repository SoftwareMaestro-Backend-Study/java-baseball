package baseball.domain;

public class GameResult {

    private static final int THE_NUMBER_OF_GAME_NUMBER = 3;

    private final String value;

    private GameResult(String value) {
        this.value = value;
    }

    public static GameResult from(int strike, int ball, int theNumberOfGameNumber) {
        if (strike == 0 && ball == 0) {
            return new GameResult("낫싱", false);
        }
        StringBuilder result = new StringBuilder();
        if (ball != 0) {
            result.append(ball).append("볼 ");
        }
        if (strike != 0) {
            result.append(strike).append("스트라이크");
        }
        if (strike == theNumberOfGameNumber) {
            result.append("\n").append(theNumberOfGameNumber).append("개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return new GameResult(result.toString());
    }

    public String getValue() {
        return value;
    }

    public boolean isEnd() {
        return value.contains(GAME_END_CONDITION);
    }
}
