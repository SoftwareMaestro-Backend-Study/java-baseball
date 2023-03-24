package baseball.service;

import baseball.domain.GameNumbers;
import baseball.domain.GameResult;
import baseball.domain.gamenumbercreator.RandomIntegerToGameNumberCreator;
import baseball.domain.gamenumbercreator.StringToGameNumberCreator;

public class GameService {

    private final GameNumbers answerNumbers;

    public GameService() {
        this.answerNumbers = GameNumbers.from(new RandomIntegerToGameNumberCreator());
    }

    public GameResult findResult(String playerRequest) {
        final StringToGameNumberCreator creator = new StringToGameNumberCreator(playerRequest);
        final GameNumbers playerNumbers = GameNumbers.from(creator);
        return answerNumbers.calculateResult(playerNumbers);
    }
}
