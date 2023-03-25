package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private static final int THE_NUMBER_OF_RANDOM_NUMBER = 3;

    private RandomNumberGenerator() {
    }

    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < THE_NUMBER_OF_RANDOM_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
