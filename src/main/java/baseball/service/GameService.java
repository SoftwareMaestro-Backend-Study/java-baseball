package baseball.service;

import baseball.domain.GameNumbers;
import baseball.domain.GameResult;
import baseball.domain.gamenumbercreator.GameNumberCreator;
import baseball.domain.gamenumbercreator.RandomIntegerToGameNumberCreator;
import baseball.domain.gamenumbercreator.StringToGameNumberCreator;

public class GameService {

    private static final GameNumberCreator NUMBER_CREATOR = new RandomIntegerToGameNumberCreator();
    private final GameNumbers answerNumbers;

    public GameService() {
        this.answerNumbers = GameNumbers.from(NUMBER_CREATOR);
    }

    public GameResult findResult(String playerRequest) {
        final StringToGameNumberCreator creator = new StringToGameNumberCreator(playerRequest);
        final GameNumbers playerNumbers = GameNumbers.from(creator);
        return answerNumbers.calculateResult(playerNumbers);
    }
}
