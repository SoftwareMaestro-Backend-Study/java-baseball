package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class SingleGame {
    List<Integer> computer = new ArrayList<>();

    public SingleGame() {
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber))
                computer.add(randomNumber);
        }
    }

    public void setComputer (List<Integer> list) {
        computer = list;
    }


    public GameStatus singleTurn(List<Integer> player){


        return new GameStatus(0,0);
    }


}
