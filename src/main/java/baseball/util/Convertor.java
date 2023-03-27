package baseball.util;

public class Convertor {

    private Convertor() {
    }

    public static int toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 포함되어 있습니다.");
        }
    }
}
