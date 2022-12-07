package lotto.view;

import lotto.enums.Ranking;
import lotto.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String MSG_LOTTOS_COUNT = "개를 구매했습니다.";
    private static final String MSG_RESULT_STATISTICS = "당첨 통계\n---";
    private static final String HYPON = " - ";
    private static final String UNIT_OF_COUNT = "개";
    private static final String MSG_RATE_OF_RETURN_PREFIX = "총 수익률은 ";
    private static final String MSG_RATE_OF_RETURN_POSTFIX = "%입니다.";

    public void printIssuedLottoCount(int count, List<Lotto> lottos) {
        System.out.println("\n" + count + MSG_LOTTOS_COUNT);

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResultStatistics(Map<String, Integer> resultComparingLotto) {
        System.out.println("\n" + MSG_RESULT_STATISTICS);

        for (Ranking ranking : Ranking.getRealRanking()) {
            System.out.println(ranking.getMessage() + HYPON + resultComparingLotto.get(ranking.name()) + UNIT_OF_COUNT);
        }
    }

    public void printRateOfReturn(String integerPart, String decimalPart) {
        System.out.println(MSG_RATE_OF_RETURN_PREFIX + integerPart + decimalPart + MSG_RATE_OF_RETURN_POSTFIX);
    }
}
