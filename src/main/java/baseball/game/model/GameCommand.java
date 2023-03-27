package baseball.game.model;

import java.util.Arrays;

public enum GameCommand {
    QUIT(2),
    CONTINUE(1);

    private final int number;

    GameCommand(int number) {
        this.number = number;
    }

    public static GameCommand getCommand (String userInput) {
        int commandNumber ;
        try{
            commandNumber = Integer.parseInt(userInput);
        }
        catch (NumberFormatException ex){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }

        GameCommand command = Arrays.stream(values())
                .filter(value -> value.number == commandNumber)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 숫자가 입력되지 않았습니다."));

        return command;
    }

    public boolean isContinue() {
        return this == CONTINUE;
    }
}
