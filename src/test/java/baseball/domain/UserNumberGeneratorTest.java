package baseball.domain;

import baseball.domain.GameNumberGenerator;
import baseball.domain.UserNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserNumberGeneratorTest {

    private static final int LIMIT = 3;

    @DisplayName("형식 외 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12-", "120"})
    void 잘못된_입력(String input) {
        // given
        GameNumberGenerator userNumberGenerator = new UserNumberGenerator(input);
        // when & then
        assertThatThrownBy(() -> userNumberGenerator.generate(LIMIT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3자리 아닌 수 입력 시 통과")
    @ParameterizedTest
    @ValueSource(strings = {"123", "483", "679"})
    void 올바른_입력(String input) {
        // given
        GameNumberGenerator userNumberGenerator = new UserNumberGenerator(input);
        // when & then
        assertThatCode(() -> userNumberGenerator.generate(LIMIT))
                .doesNotThrowAnyException();
    }
}
