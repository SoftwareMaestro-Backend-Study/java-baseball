package baseball.domain.gamenumbercreator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringToGameNumberCreatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"12 ", "-12", "ㅁ12", "1a3", "87?"})
    void 입력값에_숫자가_아닌_값이_존재하면_GameNumber생성_시_예외를_던진다(String values) {
        // given
        final StringToGameNumberCreator creator = new StringToGameNumberCreator(values);

        // when & then
        Assertions.assertThatThrownBy(() -> creator.create(3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_수로_게임_넘버를_만들_수_있다() {
        // given
        final StringToGameNumberCreator creator = new StringToGameNumberCreator("123");

        // when & then
        Assertions.assertThatCode(() -> creator.create(3))
                .doesNotThrowAnyException();
    }
}
