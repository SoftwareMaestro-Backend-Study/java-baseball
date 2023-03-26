package baseball.domain;

public class GameNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int value;

    public GameNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private static void validateRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("1~9 범위를 벗어나는 숫자가 포함되어 있습니다.");
        }
    }
}
