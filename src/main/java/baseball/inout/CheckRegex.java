package baseball.inout;

public class CheckRegex {

    public static boolean isThreeDigit (String test) {
        String pattern = "\\d{3}";
        return test.matches(pattern);
    }
    public static boolean isBaseball (String test) {
        String pattern = "^(?!.*(.).*\\1)\\d{3}$";
        return test.matches(pattern);
    }

    public static boolean isCommand (String test) {
        String pattern = "[12]";
        return test.matches(pattern);
    }
}
