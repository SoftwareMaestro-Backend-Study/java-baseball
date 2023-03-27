package baseball;

import baseball.domain.GameResult;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        while (true) {
            playGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            final RestartMessage restartMessage = new RestartMessage(Console.readLine());
            if (restartMessage.isEnd()) {
                System.out.println("게임 종료");
                break;
            }
        }
    }

    private static void playGame() {
        GameService gameService = new GameService();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerInput = Console.readLine();

            GameResult result = gameService.findResult(playerInput);

            System.out.println(result.getResultComment());
            if (result.isEnd()) {
                break;
            }
        }
    }
}
