package lotto.model;

import java.util.List;

public class WinningLotto {

    private static final String WRONG_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다.";
    private final Lotto winningNumber;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = new Lotto(winningNumber);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (winningNumber.draw(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER);
        }
    }

    public LottoPrize draw(Lotto lotto) {
        LottoPrize prize = LottoPrize.from(lotto.draw(winningNumber));

        if (prize.isThird()) {
            return prize.isSecond(lotto.draw(bonusNumber));
        }

        return prize;
    }
}
