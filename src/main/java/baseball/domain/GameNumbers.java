package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameNumbers {

    private static final int THE_NUMBER_OF_GAME_NUMBER = 3;

    private final List<GameNumber> gameNumbers;

    private GameNumbers(List<GameNumber> gameNumbers) {
        validateTheNumberOf(gameNumbers);
        validateDuplication(gameNumbers);
        this.gameNumbers = new ArrayList<>(gameNumbers);
    }

    public static GameNumbers from(GameNumberGenerator gameNumberGenerator) {
        return new GameNumbers(gameNumberGenerator.generate(THE_NUMBER_OF_GAME_NUMBER));
    }

    public GameResult compare(GameNumbers other) {
        int strike = 0;
        int ball = 0;
        for (int order = 0; order < THE_NUMBER_OF_GAME_NUMBER; order++) {
            if (isStrike(other, order)) {
                strike++;
            } else if (isBall(other, gameNumbers.get(order))) {
                ball++;
            }
        }
        return GameResult.from(strike, ball, THE_NUMBER_OF_GAME_NUMBER);
    }

    private static void validateTheNumberOf(List<GameNumber> gameNumbers) {
        if (gameNumbers.size() != THE_NUMBER_OF_GAME_NUMBER) {
            throw new IllegalArgumentException(String.format("%d자리 값이 아닙니다.", THE_NUMBER_OF_GAME_NUMBER));
        }
    }

    private void validateDuplication(List<GameNumber> gameNumbers) {
        if (new HashSet<>(gameNumbers).size() != THE_NUMBER_OF_GAME_NUMBER) {
            throw new IllegalArgumentException("중복되는 값이 포함되어 있습니다.");
        }
    }

    private boolean isStrike(GameNumbers other, int order) {
        return this.gameNumbers.get(order).equals(other.gameNumbers.get(order));
    }

    private boolean isBall(GameNumbers computer, GameNumber gameNumber) {
        return computer.gameNumbers.contains(gameNumber);
    }
}
