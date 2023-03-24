package baseball.domain.gamenumbercreator;

import baseball.domain.GameNumber;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomIntegerToGameNumberCreator implements GameNumberCreator {

    @Override
    public List<GameNumber> create(int maxLength) {
        return Stream.generate(GameNumber::createRandomNumber)
                .distinct()
                .limit(maxLength)
                .collect(Collectors.toList());
    }
}
