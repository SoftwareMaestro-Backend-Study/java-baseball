package baseball.service;

import baseball.domain.*;
import baseball.util.Input;
import baseball.util.Output;

public class NumberBaseballGame implements Game {

    private static final GameNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void run() {
        Output.printStartMessage();
        start();
    }

    private void start() {
        play(GameNumbers.from(randomNumberGenerator));
        askPlayAgain();
    }

    private void play(GameNumbers computer) {
        while (true) {
            GameNumberGenerator userNumberGenerator = new UserNumberGenerator(Input.readGameNumber());
            GameNumbers user = GameNumbers.from(userNumberGenerator);
            GameResult gameResult = user.compare(computer);
            Output.printResult(gameResult.getValue());
            if (gameResult.isEnd()) {
                break;
            }
        }
    }

    private void askPlayAgain() {
        if (GameStatus.from(Input.readGameStatus()).isRestart()) {
            start();
        }
    }
}
