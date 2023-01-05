package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.LottoResult;
import lotto.util.TypeConverter;

public class InputView {

    private static final String COST_INPUT_MSG = "구입금액을 입력해 주세요.";

    public LottoResult readCost() {
        System.out.println(COST_INPUT_MSG);
        return new LottoResult(TypeConverter.toInt(Console.readLine()));
    }
}
