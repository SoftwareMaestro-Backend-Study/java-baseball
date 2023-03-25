package baseball;

import baseball.game.GameStatus;
import baseball.game.SingleGame;
import baseball.inout.UserInput;
import baseball.inout.UserOutput;

import java.util.List;

public class Application {
    private static UserInput userInput;
    private static UserOutput userOutput;

    public static void main(String[] args) {
        boolean isContinue = true;

        startGame();
        while (isContinue)
            isContinue = playSingleGame();
    }

    private static void startGame() {
        userInput = new UserInput();
        userOutput = new UserOutput();

        userOutput.initMessage();
    }

    private static boolean playSingleGame() {
        SingleGame singleGame = new SingleGame();

        boolean isCorrect = false;

        while (!isCorrect) {
            List<Integer> playNum = userInput.getNum();
            GameStatus gameStatus = singleGame.singleTurn(playNum);
            userOutput.statusMessage(gameStatus);
            isCorrect = gameStatus.isCorrect();
        }

        userOutput.endMessage();
        return userInput.isContinue();
    }
}
