package lotto.model;

public class WinningLotto {

    private final Lotto winningNumber;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, BonusNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoPrize draw(Lotto lotto) {
        LottoPrize prize = LottoPrize.from(lotto.draw(winningNumber));

        if (prize.isThird()) {
            return prize.isSecond(lotto.draw(bonusNumber.getBonusNo()));
        }

        return prize;
    }
}
