package baseball.domain;

public class GameResult {

    private static final int THE_NUMBER_OF_GAME_NUMBER = 3;
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NOTHING = 2;
    private static final String GAME_END_CONDITION = THE_NUMBER_OF_GAME_NUMBER + "스트라이크";

    private final String value;

    private GameResult(String value) {
        this.value = value;
    }

    public static GameResult from(int[] comparingResult) {
        if (comparingResult[NOTHING] == THE_NUMBER_OF_GAME_NUMBER) {
            return new GameResult("낫싱");
        }
        StringBuilder result = new StringBuilder();
        if (comparingResult[BALL] != 0) {
            result.append(comparingResult[BALL]).append("볼 ");
        }
        if (comparingResult[STRIKE] != 0) {
            result.append(comparingResult[STRIKE]).append("스트라이크");
        }
        if (comparingResult[STRIKE] == THE_NUMBER_OF_GAME_NUMBER) {
            result.append("\n").append(THE_NUMBER_OF_GAME_NUMBER).append("개의 숫자를 모두 맞히셨습니다! 게임 종료");
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
