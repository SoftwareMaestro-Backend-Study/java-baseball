package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameResultTest {

    @ParameterizedTest
    @CsvSource(value = {"0, -1", "-1, 1"})
    void 올바르지않은_strike나_ball값으로_결과를_찾으면_예외를_던진다(int strike, int ball) {
        Assertions.assertThatThrownBy(() -> GameResult.find(strike, ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 0", "0, 1", "0, 2", "0, 3", "1, 0", "1, 1", "1, 2", "2, 0", "2, 1", "3, 0"})
    void 올바른_strike_ball값으로_결과를_찾을_수_있다(int strike, int ball) {
        Assertions.assertThatCode(() -> GameResult.find(strike, ball))
                .doesNotThrowAnyException();
    }

}
