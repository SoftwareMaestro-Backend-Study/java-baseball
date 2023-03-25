package baseball.util;

public class GameResultGenerator {

    private static final int BALL = 0;
    private static final int STRIKE = 1;
    private static final int NOTHING = 2;

    private GameResultGenerator() {
    }

    public static String generate(int[] comparingResult) {
        if (comparingResult[NOTHING] == 3) {
            return "낫싱";
        }
        StringBuilder result = new StringBuilder();
        if (comparingResult[BALL] != 0) {
            result.append(comparingResult[BALL]).append("볼 ");
        }
        if (comparingResult[STRIKE] != 0) {
            result.append(comparingResult[STRIKE]).append("스트라이크");
        }
        if (comparingResult[STRIKE] == 3) {
            result.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return result.toString();
    }
}
