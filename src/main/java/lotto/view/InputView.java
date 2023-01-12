package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.util.TypeConverter;

import java.util.List;

public class InputView {

    private static final String COST_INPUT_MSG = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MSG = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MSG = "\n보너스 번호를 입력해 주세요.";

    public LottoResult readCost() {
        System.out.println(COST_INPUT_MSG);
        return new LottoResult(TypeConverter.toInt(Console.readLine()));
    }

    public WinningLotto readWinningLotto() {
        Lotto winningNumber = readWinningNumber();
        int bonusNumber = readBonusNumber();
        return new WinningLotto(winningNumber, bonusNumber);
    }

    private Lotto readWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MSG);
        Lotto winningNumber = new Lotto(TypeConverter.toIntList(Console.readLine()));
        return winningNumber;
    }

    private int readBonusNumber() {
        System.out.println(BONUS_NUMBER_INPUT_MSG);
        return TypeConverter.toInt(Console.readLine());
    }
}
