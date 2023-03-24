package baseball.domain.gamenumbercreator;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IntegerToGameNumberCreatorTest {

    @Test
    void 숫자들을_통해_게임_숫자를_만들_수_있다() {
        // given
        final List<Integer> values = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final IntegerToGameNumberCreator creator = new IntegerToGameNumberCreator(values);

        // when & then
        Assertions.assertThatCode(creator::create)
                .doesNotThrowAnyException();
    }
}
