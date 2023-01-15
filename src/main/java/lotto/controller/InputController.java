package lotto.controller;

import lotto.view.InputView;
import lotto.utils.InputValidator;
import lotto.utils.LottoValidator;

import java.util.List;

import static lotto.utils.TypeConverter.convertStringToInt;
import static lotto.utils.TypeConverter.convertStringToIntList;

public class InputController {

    private final InputView inputView = new InputView();
    private final InputValidator inputValidator = new InputValidator();

    public int inputAmount() {
        try {
            int amount = convertStringToInt(inputView.readAmount());
            inputValidator.validateAmount(amount);

            return amount;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> winningNumbers = convertStringToIntList(inputView.readWinningNumbers());
        new LottoValidator(winningNumbers);

        return winningNumbers;
    }

    public int inputBonutNumbers(List<Integer> winningNumbers) {
        try {
            int bonusNumber = convertStringToInt(inputView.readBonusNumber());
            inputValidator.validateBonusNumber(bonusNumber, winningNumbers);

            return bonusNumber;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
}
