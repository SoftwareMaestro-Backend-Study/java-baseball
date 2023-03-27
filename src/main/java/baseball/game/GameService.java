package baseball.game;

import baseball.game.model.GameBall;
import baseball.game.model.GameCommand;
import baseball.game.model.GameStatus;
import baseball.inout.UserInput;
import baseball.inout.UserOutput;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    private static UserInput userInput;
    private static UserOutput userOutput;

    GameBall computer;

    public GameService() {
        computer = GameBall.createRandomBall();
        userInput = new UserInput();
        userOutput = new UserOutput();
    }

    public void playSingleGame() {
        boolean isContinue = true;

        while (isContinue) {
            GameBall playNum = GameBall.createBall(userInput.getNum());
            GameStatus gameStatus = computer.getStatus(playNum);
            userOutput.printStatus(gameStatus);
            isContinue = gameStatus.isContinue();
        }
        userOutput.printEndMessage();
    }

    public GameCommand getCommand() {
        return GameCommand.getCommand(userInput.isContinue());
    }

}
