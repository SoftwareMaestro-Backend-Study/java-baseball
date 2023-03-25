package baseball.service;

import baseball.domain.GameNumbers;
import baseball.domain.GameResult;
import baseball.util.*;
import camp.nextstep.edu.missionutils.Console;

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
        System.out.println(gameResult.getValue());
        if (gameResult.isEnd()) {
            return;
        }
        play(computer);
    }

    private void askPlayAgain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String gameProgressStatus = Console.readLine();
        String gameProgressStatusWithoutBlank = gameProgressStatus.replaceAll(" ", "");
        if (gameProgressStatusWithoutBlank.length() != 1) {
            throw new IllegalArgumentException("1자리 값이 아닙니다.");
        }
        int gameProgressStatusValue = gameProgressStatusWithoutBlank.charAt(0) - '0';
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
