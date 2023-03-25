package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private Input() {
    }

    public static String readGameNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
}
