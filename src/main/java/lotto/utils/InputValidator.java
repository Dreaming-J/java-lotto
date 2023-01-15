package lotto.utils;

import java.util.Comparator;
import java.util.List;

import static lotto.enums.ErrorMsg.*;

public class InputValidator {

    private static final int AMOUNT_UNIT_VALUE = 1000;
    private static final int LOWER_LOTTO_NUMBER_INCLUSIVE = 1;
    private static final int UPPER_LOTTO_NUMBER_INCLUSIVE = 45;


    public void validateAmount(int amount) {
        validateAmountOverUnitValue(amount);
        validateAmountDividedByUnitValue(amount);
    }

    private void validateAmountOverUnitValue(int amount) {
        if (amount < AMOUNT_UNIT_VALUE) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_AMOUNT_IS_OVER_ONE_THOUSAND.get());
        }
    }

    private void validateAmountDividedByUnitValue(int amount) {
        if (amount % AMOUNT_UNIT_VALUE != 0) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_AMOUNT_IS_DIVIDED_ONE_THOUSAND.get());
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumber) {
        validateBonusNumberCorrectRange(bonusNumber);
        validateBonusNumberIsIncludedInWinningNumber(bonusNumber, winningNumber);
    }

    private void validateBonusNumberCorrectRange(int bonusNumber) {
        if (bonusNumber < LOWER_LOTTO_NUMBER_INCLUSIVE || bonusNumber > UPPER_LOTTO_NUMBER_INCLUSIVE) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_LOTTO_NUMBER_IS_BETWEEN_ONE_AND_FOURTYFIVE.get());
        }
    }

    private void validateBonusNumberIsIncludedInWinningNumber(int bonusNumber, List<Integer> winningNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX.get() + ERROR_MSG_BONUS_NUMBER_IS_NOT_INCLUDED_IN_WINNING_NUMBER.get());
        }
    }
}
