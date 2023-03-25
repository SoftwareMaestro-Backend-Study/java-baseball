package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameStatusGeneratorTest {

    @DisplayName("1자리 아닌 수 입력 시 예외 발생")
    @Test
    void 잘못된_입력_길이() {
        assertThatThrownBy(() -> GameStatusGenerator.generate("12"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1자리 수 입력 시 통과")
    @Test
    void 올바른_입력_길이() {
        assertThatCode(() -> GameStatusGenerator.generate("1"))
                .doesNotThrowAnyException();
    }

    @DisplayName("정수 아닌 값 입력 시 예외 발생")
    @Test
    void 정수_아닌_값_포함() {
        assertThatThrownBy(() -> GameStatusGenerator.generate("-"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위 벗어난 정수 입력 시 예외 발생")
    @Test
    void 범위_내_정수_아닌_값_포함() {
        assertThatThrownBy(() -> GameStatusGenerator.generate("3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수만 입력 시 통과")
    @Test
    void 정수만_입력() {
        assertThatCode(() -> GameStatusGenerator.generate("1"))
                .doesNotThrowAnyException();
    }
}
