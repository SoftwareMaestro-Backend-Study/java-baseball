package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;

public class GameNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int value;

    public GameNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(String.format("[ERROR] 야구게임 숫자는 %d일 수 없습니다", value));
        }
    }

    public static GameNumber createRandomNumber() {
        final int number = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
        return new GameNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameNumber that = (GameNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
