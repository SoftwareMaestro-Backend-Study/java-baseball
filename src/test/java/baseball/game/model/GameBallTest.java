package baseball.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameBallTest {

    @ParameterizedTest
    @DisplayName("GameBall 생성 동작 테스트")
    @ValueSource(strings = {"123", "145", "671"})
    void createBall(String input) {
        // given

        // when & then
        assertThatCode( () -> {
            GameBall.createBall(input);
        }).doesNotThrowAnyException();
    }


    @ParameterizedTest
    @DisplayName("GameBall 생성 예외 테스트")
    @ValueSource(strings = {"111", "122", "1325", "a11"})
    void createBallErrors(String input) {
        // given

        // when & then
        assertThatThrownBy( () -> {
            GameBall.createBall(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("getStatus 생성 동작 테스트")
    @CsvSource(value = {"456:0:0",
            "516:1:0", "156:0:1", "231:3:0", "123:0:3"}, delimiter = ':'
    )
    void getStatus(String input, int ball, int strike) {
        // given
        GameBall computer = GameBall.createBall("123");
        GameBall player = GameBall.createBall(input);

        // when
        GameStatus gameStatus = computer.getStatus(player);

        // then
        assertThat(gameStatus).isEqualTo(new GameStatus(ball, strike));
    }

}