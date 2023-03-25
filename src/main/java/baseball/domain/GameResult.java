package baseball.domain;

public class GameResult {

    private static final String GAME_END_CONDITION = "3스트라이크";

    private String value;

    public GameResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isEnd() {
        return value.contains(GAME_END_CONDITION);
    }
}
