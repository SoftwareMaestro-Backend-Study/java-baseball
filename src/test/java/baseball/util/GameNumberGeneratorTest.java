package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameNumberGeneratorTest {

    @DisplayName("3자리 아닌 수 입력 시 예외 발생")
    @Test
    void 잘못된_입력_길이() {
        assertThatThrownBy(() -> GameNumberGenerator.generate("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3자리 아닌 수 입력 시 통과")
    @Test
    void 올바른_입력_길이() {
        assertThatCode(() -> GameNumberGenerator.generate("123"))
                .doesNotThrowAnyException();
    }

    @DisplayName("정수 아닌 값 입력 시 예외 발생")
    @Test
    void 정수_아닌_값_포함() {
        assertThatThrownBy(() -> GameNumberGenerator.generate("12-"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위 벗어난 정수 입력 시 예외 발생")
    @Test
    void 범위_내_정수_아닌_값_포함() {
        assertThatThrownBy(() -> GameNumberGenerator.generate("120"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수만 입력 시 통과")
    @Test
    void 정수만_입력() {
        assertThatCode(() -> GameNumberGenerator.generate("123"))
                .doesNotThrowAnyException();
    }
}
