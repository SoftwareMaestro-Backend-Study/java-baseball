package baseball.inout;


import camp.nextstep.edu.missionutils.Console;

public class UserInput {

    private UserInput() {
    }

    /**
     * 숫자 입력
     */
    public static String getNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine().trim();
        return input;
    }

    /**
     * 게임 진행여부 입력
     */
    public static String isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine().trim();
        return input;
    }

}
