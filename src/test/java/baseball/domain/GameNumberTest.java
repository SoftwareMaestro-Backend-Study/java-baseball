package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 게임_숫자가_1이상_9이하의_자연수가_아니면_예외를_던진다(int number) {
        Assertions.assertThatThrownBy(() -> new GameNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void 게임_숫자는_1이상_9이하의_자연수여야한다(int number) {
        Assertions.assertThatCode(() -> new GameNumber(number))
                .doesNotThrowAnyException();
    }
}
