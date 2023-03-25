package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {

    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NOTHING = 2;

    private List<GameNumber> gameNumbers;

    public GameNumbers(List<GameNumber> gameNumbers) {
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

    private boolean isStrike(List<Integer> computer, int order, int number) {
        return computer.contains(number) && computer.indexOf(number) == order;
    }

    private boolean isBall(List<Integer> computer, int order, int number) {
        return computer.contains(number) && computer.indexOf(number) != order;
    }
}
