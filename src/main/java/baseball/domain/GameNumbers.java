package baseball.domain;

import java.util.List;

public class GameNumbers {

    private static final int MAX_LENGTH = 3;
    private final List<GameNumber> numbers;

    public static GameNumbers from(GameNumberCreator numberCreator) {
        return new GameNumbers(numberCreator.create());
    }

    private GameNumbers(List<GameNumber> numbers) {
        validateLength(numbers);
        this.numbers = numbers;
    }

    private void validateLength(List<GameNumber> numbers) {
        if (numbers.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("[ERROR] 게임 숫자는 %d 자리를 초과할 수 없습니다.", MAX_LENGTH));
        }
    }
}
