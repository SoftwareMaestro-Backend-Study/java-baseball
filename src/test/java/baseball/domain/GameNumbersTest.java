package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameNumbersTest {

    @Test
    void 게임_넘버가_3자리를_초과하면_예외를_던진다() {
        // given
        GameNumberCreator creator = () ->
                List.of(new GameNumber(1), new GameNumber(2), new GameNumber(3), new GameNumber(4));

        assertThatThrownBy(() -> GameNumbers.from(creator))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
