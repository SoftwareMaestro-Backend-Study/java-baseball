package baseball.domain;

import baseball.domain.gamenumbercreator.GameNumberCreator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class GameNumbers {

    private static final int MAX_LENGTH = 3;
    private final List<GameNumber> numbers;

    private GameNumbers(List<GameNumber> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public static GameNumbers from(GameNumberCreator numberCreator) {
        return new GameNumbers(numberCreator.create(MAX_LENGTH));
    }

    private void validateLength(List<GameNumber> numbers) {
        if (numbers.size() != MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 게임 숫자는 %d 자리여야합니다.", MAX_LENGTH));
        }
    }

    private void validateDuplicate(List<GameNumber> numbers) {
        if (numbers.size() != new HashSet<>(numbers).size()) {
            throw new IllegalArgumentException("[ERROR] 게임 숫자는 중복된 값을 가질 수 없습니다.");
        }
    }

    public GameResult calculateResult(GameNumbers other) {
        int strike = (int) IntStream.range(0, other.numbers.size())
                .filter(i -> other.numbers.get(i).equals(this.numbers.get(i)))
                .count();

        int ball = (int) other.numbers.stream()
                .filter(this.numbers::contains)
                .count() - strike;

        return GameResult.find(strike, ball);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameNumbers that = (GameNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
