package baseball;

import baseball.service.Game;
import baseball.service.NumberBaseballGame;

public class Application {

    public static void main(String[] args) {
        Game game = new NumberBaseballGame();
        game.run();
    }
}
