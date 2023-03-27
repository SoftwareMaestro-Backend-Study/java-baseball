package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameStatusTest {

    @DisplayName("형식 외 입력 시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "-", "3"})
    void 잘못된_입력(String input) {
        assertThatThrownBy(() -> GameStatus.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 입력 시 재시작")
    @Test
    void 입력값_1이면_재시작() {
        assertThat(GameStatus.from("1").isRestart()).isTrue();
    }

    @DisplayName("2 입력 시 종료")
    @Test
    void 입력값_2이면_종료() {
        assertThat(GameStatus.from("2").isRestart()).isFalse();
    }
}
