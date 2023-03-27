package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Objects;

public class GameNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int value;

    private GameNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    public static GameNumber from(int input) {
        return new GameNumber(input);
    }

    public static GameNumber create() {
        return new GameNumber(Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE));
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameNumber that = (GameNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private static void validateRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("%d~%d 범위를 벗어나는 숫자가 포함되어 있습니다.", MIN_VALUE, MAX_VALUE));
        }
    }
}
