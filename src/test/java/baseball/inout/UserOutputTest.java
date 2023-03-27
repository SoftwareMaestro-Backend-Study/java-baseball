package baseball.inout;

import baseball.game.model.GameStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class UserOutputTest {
    private static ByteArrayOutputStream outputMessage;
    private static UserOutput output;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정

        output = new UserOutput();
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    void initMessage() {
        // when
        output.initMessage();

        // then
        assertThat(outputMessage.toString().trim()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }


    @ParameterizedTest
    @DisplayName("statusMessage 테스트 - 1볼")
    @ValueSource(ints = {0, 1, 2})
    void statusMessage(int strike) {
        // when
        output.printStatus(new GameStatus(1, strike));

        // then
        if (strike == 0)
            assertThat(outputMessage.toString().trim()).isEqualTo("1볼");
        else
            assertThat(outputMessage.toString().trim()).isEqualTo("1볼 " + strike + "스트라이크");
    }


    @ParameterizedTest
    @DisplayName("statusMessage 테스트 - 3스트라이크, 낫싱")
    @ValueSource(ints = {0, 3})
    void statusMessage2(int strike) {
        // when
        output.printStatus(new GameStatus(0, strike));

        // then
        if (strike == 0)
            assertThat(outputMessage.toString().trim()).isEqualTo("낫싱");
        else
            assertThat(outputMessage.toString().trim()).isEqualTo("3스트라이크");
    }

    @Test
    void endMessage() {
        // when
        output.printEndMessage();

        // then
        assertThat(outputMessage.toString().trim()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}