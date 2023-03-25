package baseball.inout;


import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    /**
     * 숫자 입력
     */
    public List<Integer> getNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine().trim();

//        CheckRegex.isPlayball

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            numbers.add(input.charAt(i) - '0');

        return numbers;
    }

    /**
     * 게임 진행여부 입력
     */
    public boolean isContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = readLine().trim();
        // regex

        return input.equals("1");
    }

}
