package lotto.service;

import lotto.enums.Ranking;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoComparator {

    private final List<Lotto> lottos;

    public LottoComparator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Ranking> compareLottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        List<Ranking> resultComparingLotto = new ArrayList<>();

        for (Lotto lotto : lottos) {
            Ranking rank = lotto.countMatchingNumber(winningNumbers, bonusNumber);
            if (Ranking.getRealRanking().contains(rank)) {
                resultComparingLotto.add(rank);
            }
        }

        return resultComparingLotto;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
