package lotto.util;

public class TypeConverter {

    private static final String WRONG_NUMBER_INPUT = "올바른 숫자로 입력해주세요.";

    public static Integer toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_INPUT);
        }
    }
}
