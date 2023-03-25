package baseball.inout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserInputTest {
    private static ByteArrayOutputStream outputMessage;
    private static ByteArrayInputStream inputMessage;
    private static UserInput userInput;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정

        userInput = new UserInput();
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    @DisplayName("숫자 입력 동작 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123", "145", "671"})
    void getNum(String input) {
        // given
        enterInput(input);
        List<Integer> compare = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            compare.add( input.charAt(i) - '0');

        // when
        List<Integer> list = userInput.getNum();

        // then
        assertThat(list).isEqualTo(compare);
    }

    @Test
    @DisplayName("숫자 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"111", "122", "1325", "a11"})
    void getNumErrors(String input) {
        // given
        enterInput(input);

        // then
        assertThatThrownBy( () -> {
            userInput.getNum();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임진행 입력 동작 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    void isContinue(String input) {
        // given
        enterInput(input);

        // when
        boolean cmd = userInput.isContinue();

        // then
        assertThat(cmd).isEqualTo( input.equals("1") );
    }

    @Test
    @DisplayName("게임진행 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"111", "2", "0", "a"})
    void isContinueError(String input) {
        // given
        enterInput(input);

        // then
        assertThatThrownBy( () -> {
            userInput.isContinue();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    void enterInput(String input){
        inputMessage = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputMessage);
    }
}