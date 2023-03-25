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
        int strike = 0, ball = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) strike ++;
            else if (computer.contains(player.get(i))) ball ++;
        }

        return new GameStatus(ball, strike);
    }
}
