package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameNumbers {

    private static final int THE_NUMBER_OF_GAME_NUMBER = 3;
    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NOTHING = 2;

    private final List<GameNumber> gameNumbers;

    public GameNumbers(List<GameNumber> gameNumbers) {
        validateTheNumberOf(gameNumbers);
        validateDuplication(gameNumbers);
        this.gameNumbers = new ArrayList<>(gameNumbers);
    }

    public int[] getComparingResult(List<Integer> computer) {
        int[] comparingResult = new int[3];
        for (int order = 0; order < 3; order++) {
            int number = gameNumbers.get(order).getValue();
            if (isBall(computer, order, number)) {
                comparingResult[BALL]++;
            } else if (isStrike(computer, order, number)) {
                comparingResult[STRIKE]++;
            } else {
                comparingResult[NOTHING]++;
            }
        }
        return comparingResult;
    }

    private static void validateTheNumberOf(List<GameNumber> gameNumbers) {
        if (gameNumbers.size() != THE_NUMBER_OF_GAME_NUMBER) {
            throw new IllegalArgumentException("3자리 값이 아닙니다.");
        }
    }

    private void validateDuplication(List<GameNumber> gameNumbers) {
        if (gameNumbers.size() != new HashSet<>(gameNumbers).size()) {
            throw new IllegalArgumentException("중복되는 값이 포함되어 있습니다.");
        }
    }

    private boolean isStrike(List<Integer> computer, int order, int number) {
        return computer.contains(number) && computer.indexOf(number) == order;
    }

    private boolean isBall(List<Integer> computer, int order, int number) {
        return computer.contains(number) && computer.indexOf(number) != order;
    }
}
