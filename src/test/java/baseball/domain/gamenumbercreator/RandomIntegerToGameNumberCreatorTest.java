package baseball.domain.gamenumbercreator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomIntegerToGameNumberCreatorTest {

    @Test
    void 숫자들을_통해_게임_숫자를_만들_수_있다() {
        // given
        final RandomIntegerToGameNumberCreator creator = new RandomIntegerToGameNumberCreator();

        // when & then
        Assertions.assertThatCode(() -> creator.create(3))
                .doesNotThrowAnyException();
    }
}
