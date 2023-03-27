package baseball.inout;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    /**
     * 숫자 입력
     */
    public String getNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine().trim();
        return input;
    }

    /**
     * 게임 진행여부 입력
     */
    public String isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine().trim();
        return input;
    }

}
