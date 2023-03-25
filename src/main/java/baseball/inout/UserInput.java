package baseball.inout;


import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInput {

    /**
     * 숫자 입력
     */
    public List<Integer> getNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = readLine();

//        CheckRegex.isPlayball
//        Integer.parseInt(input);
        return List.of(0,0,0);
    }

    /**
     * 게임 진행여부 입력
     */
    public boolean isContinue() {
        return false;
    }

}
