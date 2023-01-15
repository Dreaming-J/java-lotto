package lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TypeConverter {

    private static final String WRONG_NUMBER_INPUT = "올바른 숫자로 입력해주세요.";
    private static final String COMMA = ",";

    public static Integer toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_INPUT);
        }
    }

    public static List<Integer> toIntList(String input) {
        try {
            return Stream.of(input.split(COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_INPUT);
        }
    }
}
