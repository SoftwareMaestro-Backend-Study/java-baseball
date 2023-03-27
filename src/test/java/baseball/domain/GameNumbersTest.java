package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameNumbersTest {

    private GameNumbers computer;

    @BeforeEach
    void setUp() {
        GameNumberGenerator gameNumberGenerator = new UserNumberGenerator("123");
        computer = GameNumbers.from(gameNumberGenerator);
    }

    @DisplayName("게임 종료")
    @Test
    void 스트라이크_세번이면_게임_종료() {
        // given
        GameNumberGenerator userNumberGenerator = new UserNumberGenerator("123");
        GameNumbers user = GameNumbers.from(userNumberGenerator);
        // when
        GameResult gameResult = user.compare(computer);
        // then
        assertThat(gameResult.isEnd()).isTrue();
    }

    @DisplayName("게임 재시작")
    @Test
    void 스트라이크_세번_아니면_게임_재시작() {
        // given
        GameNumberGenerator userNumberGenerator = new UserNumberGenerator("124");
        GameNumbers user = GameNumbers.from(userNumberGenerator);
        // when
        GameResult gameResult = user.compare(computer);
        // then
        assertThat(gameResult.isEnd()).isFalse();
    }
}
