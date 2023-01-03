package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class BonusNumber {

    private static final String WRONG_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다.";
    private final LottoNumber bonusNo;

    public BonusNumber(int no, Lotto answer) {
        if (answer.contains(no)) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER);
        }
        this.bonusNo = new LottoNumber(no);
    }
}
