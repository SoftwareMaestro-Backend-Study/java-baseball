package baseball.service;

import baseball.domain.GameNumbers;
import baseball.domain.GameResult;
import baseball.domain.GameStatus;
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
        GameNumbers gameNumbers = GameNumberGenerator.generate(input);
        GameResult gameResult = GameResult.from(gameNumbers.getComparingResult(computer));
        Output.printResult(gameResult.getValue());
        if (gameResult.isEnd()) {
            return;
        }
        play(computer);
    }

    private void askPlayAgain() {
        GameStatus gameStatus = new GameStatus(Convertor.toInteger(Input.readGameStatus()));
        if (gameStatus.isRestart()) {
            start();
        }
    }
}
