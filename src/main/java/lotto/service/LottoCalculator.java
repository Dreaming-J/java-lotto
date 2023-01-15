package lotto.service;

import lotto.enums.Ranking;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoCalculator {

    private static final int ZERO = 0;
    private static final int PERCENT = 100;
    private static final int ROUND_SECOND_DEMICAL_POINT = 100;
    private static final int LOTTO_PRICE = 1000;

    private final int amount;
    private Map<String, Integer> resultStatistics = new HashMap<>();

    public LottoCalculator(int amount) {
        this.amount = amount;
        for (Ranking ranking : Ranking.getRealRanking()) {
            resultStatistics.put(ranking.name(), ZERO);
        }
    }

    public int count() {
        return this.amount / LOTTO_PRICE;
    }

    public void calResultLotto(List<Ranking> resultComparingLotto) {
        for (Ranking ranking : resultComparingLotto) {
            resultStatistics.put(ranking.name(), resultStatistics.get(ranking.name()) + 1);
        }
    }

    public double calTotalPrize() {
        double totalPrize = ZERO;

        for (Ranking ranking : Ranking.getRealRanking()) {
            totalPrize += ranking.getPrize() * resultStatistics.get(ranking.name());
        }

        return totalPrize;
    }

    public double calRateOfReturn(double totalPrize) {
        return (double) Math.round(totalPrize / this.amount * PERCENT * ROUND_SECOND_DEMICAL_POINT) / ROUND_SECOND_DEMICAL_POINT;
    }

    public Map<String, Integer> getResultStatistics() {
        return this.resultStatistics;
    }
}
