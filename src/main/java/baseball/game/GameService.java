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

    GameBall computer;

    public GameService() {
        computer = GameBall.createRandomBall();
    }

    public void playSingleGame() {
        boolean isContinue = true;

        while (isContinue) {
            GameBall playNum = GameBall.createBall(UserInput.getNum());
            GameStatus gameStatus = computer.getStatus(playNum);
            UserOutput.printStatus(gameStatus);
            isContinue = gameStatus.isContinue();
        }
        UserOutput.printEndMessage();
    }

    public GameCommand getCommand() {
        return GameCommand.getCommand(UserInput.isContinue());
    }

}
