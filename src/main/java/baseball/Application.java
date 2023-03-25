package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        String input = Console.readLine();
        String inputWithoutBlank = input.replaceAll(" ", "");
        if (inputWithoutBlank.length() != 3) {
            throw new IllegalArgumentException("3자리 값이 아닙니다.");
        }
        for (int i = 0; i < 3; i++) {
            int each = inputWithoutBlank.charAt(i) - '0';
            if (each < 0 || each > 9) {
                throw new IllegalArgumentException("정수가 아닌 값이 포함되어 있습니다.");
            }
            if (each == 0) {
                throw new IllegalArgumentException("1~9 범위를 벗어나는 숫자가 포함되어 있습니다.");
            }
        }
        int[] comparingResult = new int[3];
        for (int i = 0; i < 3; i++) {
            int number = inputWithoutBlank.charAt(i) - '0';
            if (computer.contains(number) && computer.indexOf(number) != i) {
                comparingResult[0]++;
            } else if (computer.contains(number) && computer.indexOf(number) == i) {
                comparingResult[1]++;
            } else {
                comparingResult[2]++;
            }
        }
        StringBuilder result = new StringBuilder();
        if (comparingResult[2] == 3) {
            result.append("낫싱");
        } else {
            if (comparingResult[0] != 0) {
                result.append(comparingResult[0]).append("볼 ");
            }
            if (comparingResult[1] != 0) {
                result.append(comparingResult[1]).append("스트라이크");
            }
        }
        if (comparingResult[1] == 3) {
            result.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        System.out.println(result);
    }
}
