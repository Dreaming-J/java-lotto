package lotto.utils;

import static lotto.enums.ErrorMsg.*;

import java.util.Comparator;
import java.util.List;

public class LottoValidator {

    private static final int LOTTO_SIZE = 6;
    private static final int LOWER_LOTTO_NUMBER_INCLUSIVE = 1;
    private static final int UPPER_LOTTO_NUMBER_INCLUSIVE = 45;

    public LottoValidator(List<Integer> numbers) {
        try {
            validateSize(numbers);
            validateDuplicate(numbers);
            validateCorrectRange(numbers);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_LOTTO_NUMBER_SIZE_IS_SIX.get());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_LOTTO_NUMBER_SIZE_IS_NOT_DUPLICATED.get());
        }
    }

    private void validateCorrectRange(List<Integer> numbers) {
        int max = numbers.stream().max(Comparator.comparing(x -> x)).get();
        int min = numbers.stream().min(Comparator.comparing(x -> x)).get();

        if (min < LOWER_LOTTO_NUMBER_INCLUSIVE || max > UPPER_LOTTO_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_LOTTO_NUMBER_IS_BETWEEN_ONE_AND_FOURTYFIVE.get());
        }
    }
}
