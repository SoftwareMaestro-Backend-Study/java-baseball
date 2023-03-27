package baseball.game.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameBall {

    private final static int BALL_MAX = 9;
    private final static int BALL_MIN = 1;
    private final static int BALL_NUM = 3;

    private List<Integer> ballNumbers;

    private GameBall(List<Integer> ballNumbers) {
        this.ballNumbers = ballNumbers;
    }

    public static GameBall createBall(String userInput){
        if (isInvalidLength(userInput))
            throw new IllegalArgumentException("3자리의 숫자를 입력해야 합니다.");
        if (isInvalidRange(userInput))
            throw new IllegalArgumentException("숫자의 범위가 올바르지 않습니다.");

        List<Integer> ball = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            ball.add(userInput.charAt(i) - '0');

        if (isDuplicated(ball))
            throw new IllegalArgumentException("중복이 없는 3자리의 숫자를 입력해야 합니다.");

        return new GameBall(ball);
    }

    public static GameBall createRandomBall (){
        Set<Integer> ball = new LinkedHashSet<>();

        while(ball.size() < BALL_NUM) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            ball.add(randomNumber);
        }

        return new GameBall(new ArrayList<>(ball));
    }

    public GameStatus getStatus(GameBall other) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < this.ballNumbers.size(); i++) {
            if (other.ballNumbers.get(i).equals(this.ballNumbers.get(i))) strike++;
            else if (other.ballNumbers.contains(this.ballNumbers.get(i))) ball++;
        }

        return new GameStatus(ball, strike);
    }

    private static boolean isInvalidLength(String input) {
        return input.length() != BALL_NUM;
    }

    private static boolean isDuplicated(List<Integer> input) {
        return input.size() != (new HashSet<Integer>(input)).size();
    }

    private static boolean isInvalidRange(String input) {
        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            if (num > BALL_MAX || num < BALL_MIN) return true;
        }
        return false;
    }

}
