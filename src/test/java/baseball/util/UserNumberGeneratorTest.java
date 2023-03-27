package baseball.util;

import baseball.domain.UserNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNumberGeneratorTest {

    @DisplayName("형식 외 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12-", "120", "122"})
    void 잘못된_입력(String input) {
        assertThatThrownBy(() -> UserNumberGenerator.generate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3자리 아닌 수 입력 시 통과")
    @ParameterizedTest
    @ValueSource(strings = {"123", "483", "679"})
    void 올바른_입력(String input) {
        assertThatCode(() -> UserNumberGenerator.generate(3))
                .doesNotThrowAnyException();
    }
}
