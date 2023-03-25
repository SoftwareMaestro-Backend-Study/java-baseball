package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String BLANK = " ";
    private static final String DELETE = "";

    private Input() {
    }

    public static String readGameNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return removeBlank(Console.readLine());
    }

    private static String removeBlank(String input) {
        return input.replaceAll(BLANK, DELETE);
    }
}
