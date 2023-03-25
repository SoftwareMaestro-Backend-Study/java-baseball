package baseball.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SingleGameTest {
    SingleGame singleGame;

    @BeforeAll
    void setSingleGame() {
        singleGame = new SingleGame();
        singleGame.setComputer(List.of(1, 2, 3));
    }

    List<List<Integer>> inputs = new ArrayList<>(List.of(
            List.of(4, 5, 6), // n
            List.of(4, 5, 1), // 1b
            List.of(1, 5, 6), // 1s
            List.of(1, 5, 2), // 1b1s
            List.of(1, 2, 3)  // 3s
    ));
    List<GameStatus> expects = new ArrayList<>(List.of(
            new GameStatus(0, 0),
            new GameStatus(1, 0),
            new GameStatus(0, 1),
            new GameStatus(1, 1),
            new GameStatus(0, 3)
    ));

    @Test
    @DisplayName("singleTurn 동작 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void singleTurn(int i) {
        // when
        GameStatus status = singleGame.singleTurn(inputs.get(i));

        // then
        assertThat(status).isEqualTo(expects.get(i));
    }
}