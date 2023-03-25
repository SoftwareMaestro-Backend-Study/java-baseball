package baseball.service;

import baseball.domain.GameNumbers;
import baseball.util.GameNumberGenerator;
import baseball.util.Input;
import baseball.util.Output;
import baseball.util.RandomNumberGenerator;
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
        GameNumbers gameNumbers = new GameNumbers(GameNumberGenerator.getGameNumbers(input));
        int[] comparingResult = gameNumbers.getComparingResult(computer);
        StringBuilder result = new StringBuilder();
        if (comparingResult[2] == 3) {
            result.append("낫싱");
        } else {
            if (comparingResult[0] != 0) {
                result.append(comparingResult[0]).append("볼 ");
            }
            if (comparingResult[1] != 0) {
                result.append(comparingResult[1]).append("스트라이크");
            }
        }
        if (comparingResult[1] == 3) {
            result.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println(result);
        if (comparingResult[1] == 3) {
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
