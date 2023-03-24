package baseball.domain.gamenumbercreator;

import baseball.domain.GameNumber;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerToGameNumberCreator implements GameNumberCreator {
    private final List<Integer> values;

    public IntegerToGameNumberCreator(List<Integer> values) {
        this.values = values;
    }

    @Override
    public List<GameNumber> create() {
        return values.stream()
                .map(GameNumber::new)
                .collect(Collectors.toList());
    }
}
