package baseball.inout;

import baseball.game.model.GameStatus;

public class UserOutput {

    private UserOutput() {
    }

    public static void initMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStatus(GameStatus status) {
        if (status.ball == 0 && status.strike == 0)
            System.out.println("낫싱");
        else if (status.ball == 0)
            System.out.println(status.strike + "스트라이크");
        else if (status.strike == 0)
            System.out.println(status.ball + "볼");
        else
            System.out.println(status.ball + "볼 " + status.strike + "스트라이크");

    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
