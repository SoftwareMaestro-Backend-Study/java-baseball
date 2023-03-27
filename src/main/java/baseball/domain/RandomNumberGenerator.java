package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberGenerator및 implements GameNumberGenerator {

    public List<GameNumber> generate(int limit) {
        return Stream.generate(GameNumber::create)
                .distinct()
                .limit(limit)
                .collect(Collectors.toList());
    }
}
