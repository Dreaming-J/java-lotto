package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.module.RepeatModule;
import lotto.util.TypeConverter;

public class InputView extends RepeatModule {

    private static final String COST_INPUT_MSG = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MSG = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MSG = "\n보너스 번호를 입력해 주세요.";

    public LottoResult readCost() {
        System.out.println(COST_INPUT_MSG);
        return new LottoResult(TypeConverter.toInt(Console.readLine()));
    }

    public Lotto readWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_MSG);
        return new Lotto(TypeConverter.toIntList(Console.readLine()));
    }

    public WinningLotto readBonusNumber(Lotto winningNumber) {
        System.out.println(BONUS_NUMBER_INPUT_MSG);
        int bonusNumber = TypeConverter.toInt(Console.readLine());
        return new WinningLotto(winningNumber, bonusNumber);
    }
}
