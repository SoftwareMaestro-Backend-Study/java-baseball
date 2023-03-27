package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.gamenumbercreator.GameNumberCreator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
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

    public static Stream<Arguments> numbers() {
        final List<GameNumber> computerNumbers = List.of(new GameNumber(1), new GameNumber(2), new GameNumber(3));

        return Stream.of(
                Arguments.of(
                        computerNumbers,
                        List.of(new GameNumber(1), new GameNumber(2), new GameNumber(3)),
                        GameResult.THREE_STRIKE),
                Arguments.of(
                        computerNumbers,
                        List.of(new GameNumber(2), new GameNumber(1), new GameNumber(3)),
                        GameResult.ONE_STRIKE_TWO_BALL),
                Arguments.of(
                        computerNumbers,
                        List.of(new GameNumber(7), new GameNumber(8), new GameNumber(9)),
                        GameResult.ZERO)
        );

    }

    @ParameterizedTest
    @MethodSource("invalidGameNumbers")
    void 게임_넘버가_3자리가_아니면_예외를_던진다(List<GameNumber> gameNumbers) {
        // given
        GameNumberCreator creator = maxLength -> gameNumbers;

        assertThatThrownBy(() -> GameNumbers.from(creator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_게임_넘버가_존재하면_예외를_던진다() {
        // given
        final List<GameNumber> gameNumbers = List.of(new GameNumber(2), new GameNumber(2), new GameNumber(3));
        GameNumberCreator creator = maxLength -> gameNumbers;

        // when & then
        assertThatThrownBy(() -> GameNumbers.from(creator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("numbers")
    void 게임_넘버들로_게임_결과를_생성할_수_있다(List<GameNumber> com, List<GameNumber> player, GameResult result) {
        // given
        final GameNumbers computerNumber = GameNumbers.from(maxLength -> com);
        final GameNumbers playerNumber = GameNumbers.from(maxLength -> player);

        // when & then
        assertThat(computerNumber.calculateResult(playerNumber))
                .isEqualTo(result);
    }
}
