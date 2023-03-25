package baseball.service;

import baseball.domain.GameNumbers;
import baseball.domain.GameResult;
import baseball.util.*;

import java.util.List;

public class NumberBaseballGame implements Game {

    public void run() {
        Output.printStartMessage();
        start();
    }

    private void start() {
        play(RandomNumberGenerator.generate());
        askPlayAgain();
    }

    private void play(List<Integer> computer) {
        String input = Input.readGameNumber();
        GameNumbers gameNumbers = new GameNumbers(GameNumberGenerator.generate(input));
        GameResult gameResult = new GameResult(GameResultGenerator.generate(gameNumbers.getComparingResult(computer)));
        Output.printResult(gameResult.getValue());
        if (gameResult.isEnd()) {
            return;
        }
        play(computer);
    }

    private void askPlayAgain() {
        String gameProgressStatus = Input.readGameStatus();
        if (gameProgressStatus.length() != 1) {
            throw new IllegalArgumentException("1자리 값이 아닙니다.");
        }
        int gameProgressStatusValue = gameProgressStatus.charAt(0) - '0';
        if (gameProgressStatusValue < 0 || gameProgressStatusValue > 9) {
            throw new IllegalArgumentException("정수가 아닌 값이 포함되어 있습니다.");
        }
        if (gameProgressStatusValue != 1 && gameProgressStatusValue != 2) {
            throw new IllegalArgumentException("1 또는 2 이외의 숫자가 포함되어 있습니다.");
        }
        if (gameProgressStatusValue == 1) {
            start();
        }
    }
}
