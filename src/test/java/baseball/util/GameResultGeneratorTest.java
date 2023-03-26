package baseball.util;

import baseball.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultGeneratorTest {

    @DisplayName("같은 수가 없으면 낫싱 출력")
    @Test
    void 같은_수_없으면_낫싱() {
        // given
        int[] comparingResult = {0, 0, 3};
        // when
        GameResult gameResult = GameResult.from(comparingResult);
        // then
        assertThat(gameResult.getValue())
                .isEqualTo("낫싱");
    }

    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    @Test
    void 같은_수_같은_자리면_스트라이크() {
        // given
        int[] comparingResult = {0, 2, 0};
        // when
        GameResult gameResult = GameResult.from(comparingResult);
        // then
        assertThat(gameResult.getValue())
                .isEqualTo("2스트라이크");
    }

    @DisplayName("같은 수가 다른 자리에 있으면 볼")
    @Test
    void 같은_수_다른_자리면_볼() {
        // given
        int[] comparingResult = {1, 0, 0};
        // when
        GameResult gameResult = GameResult.from(comparingResult);
        // then
        assertThat(gameResult.getValue())
                .isEqualTo("1볼 ");
    }
}
