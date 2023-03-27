package baseball.game.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class GameCommandTest {

    @Test
    void getCommand() {
    }

    @Test
    void isContinue() {
    }



    @ParameterizedTest
    @DisplayName("게임진행 입력 동작 테스트")
    @ValueSource(strings = {"1", "2"})
    void getCommand(String input) {
        // given

        // when
        GameCommand cmd = GameCommand.getCommand(input);

        // then
        if (input.equals("1"))
            assertThat(cmd).isEqualTo(GameCommand.CONTINUE);
        else
            assertThat(cmd).isEqualTo(GameCommand.QUIT);
    }


    @ParameterizedTest
    @DisplayName("게임진행 입력 예외 테스트")
    @ValueSource(strings = {"111", "3", "0", "a"})
    void getCommandError(String input) {
        // given

        // then
        assertThatThrownBy( () -> {
            GameCommand.getCommand(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}