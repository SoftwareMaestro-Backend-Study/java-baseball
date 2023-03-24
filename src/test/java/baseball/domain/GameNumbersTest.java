package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.gamenumbercreator.GameNumberCreator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameNumbersTest {

    public static Stream<Arguments> invalidGameNumbers() {
        return Stream.of(
                Arguments.of(List.of(new GameNumber(1), new GameNumber(2), new GameNumber(3), new GameNumber(4))),
                Arguments.of(List.of(new GameNumber(1), new GameNumber(2)))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidGameNumbers")
    void 게임_넘버가_3자리가_아니면_예외를_던진다(List<GameNumber> gameNumbers) {
        // given
        GameNumberCreator creator = () -> gameNumbers;

        assertThatThrownBy(() -> GameNumbers.from(creator))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
