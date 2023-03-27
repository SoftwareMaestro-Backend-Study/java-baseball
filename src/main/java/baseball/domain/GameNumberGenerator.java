package baseball.domain;

import java.util.List;

public interface GameNumberGenerator {

    List<GameNumber> generate(int limit);
}
