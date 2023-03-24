package baseball.domain;

import baseball.domain.gamenumbercreator.GameNumberCreator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class GameNumbers {

    private static final int MAX_LENGTH = 3;
    private final List<GameNumber> numbers;

    private GameNumbers(List<GameNumber> numbers) {
        validateLength(numbers);
        this.numbers = numbers;
    }

    public static GameNumbers from(GameNumberCreator numberCreator) {
        return new GameNumbers(numberCreator.create());
    }

    private void validateLength(List<GameNumber> numbers) {
        if (numbers.size() != MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 게임 숫자는 %d 자리를 초과할 수 없습니다.", MAX_LENGTH));
        }
    }
}
