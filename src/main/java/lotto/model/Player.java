package lotto.model;

import java.util.List;

public class Player {
    private int purchaseAmount;
    private int lottoCount;
    private List<Lotto> lottoNumbers;
    private List<Integer> winningNumber;
    private int bonusNumber;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }

    public void setLottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return this.lottoCount;
    }

    public void setLottoNumbers(List<Lotto> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Lotto> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public List<Integer> getWinningNumber() {
        return this.winningNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    private int compareLottoAndWinningNumber(Lotto lotto) {
        int matchingNumbers = 0;

        for (int number : this.winningNumber) {
            if (lotto.getNumbers().contains(number)) {
                matchingNumbers++;
            }
        }
        if (lotto.getNumbers().contains(this.bonusNumber)) {
            matchingNumbers += 10;
        }

        return matchingNumbers;
    }
}
