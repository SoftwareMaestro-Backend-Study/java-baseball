package baseball;

import baseball.game.model.GameCommand;
import baseball.game.model.GameStatus;
import baseball.game.GameService;
import baseball.inout.UserInput;
import baseball.inout.UserOutput;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameCommand command = GameCommand.CONTINUE;

        while (command.isContinue()){
            GameService gameService = new GameService();
            gameService.playSingleGame();
            command = gameService.getCommand();
        }
    }

}
