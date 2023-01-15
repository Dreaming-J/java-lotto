package lotto.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.enums.ErrorMsg.*;

public class TypeConverter {

    private static final String COMMA = ",";

    public static int convertStringToInt(String data) {
        try {
            return Integer.parseInt(data);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_AMOUNT_IS_NUMBER.get());
        }
    }

    public static List<Integer> convertStringToIntList(String data) {
        try {
            return Stream.of(data.split(COMMA))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_WINNING_NUMBER_IS_NUMBER.get());
        }
    }
}
