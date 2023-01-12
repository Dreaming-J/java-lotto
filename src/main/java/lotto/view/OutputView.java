package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.LottoPrize;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    private static final String LINE_BREAK = "\n";
    private static final String LOTTO_COUNT_POSTFIX_MSG = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_PREFIX = "당첨 통계\n---";
    private static final String COUNT_UNIT = "개";

    public void printLottos(int count, List<Lotto> lottos) {
        System.out.println(LINE_BREAK + count + LOTTO_COUNT_POSTFIX_MSG);
        for (Lotto lotto: lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers().stream()
                    .map(LottoNumber::getNo)
                    .collect(Collectors.toList());
            System.out.println(lottoNumbers);
        }
    }

    public void printLottoResult(List<LottoPrize> prizes) {
        System.out.println(LINE_BREAK + LOTTO_RESULT_PREFIX);

        for (LottoPrize lottoPrize : LottoPrize.valuesWithoutNothing()) {
            int count = (int) prizes.stream()
                    .filter(prize -> Objects.equals(prize, lottoPrize))
                    .count();
            System.out.println(PrizeMsg.findMessage(lottoPrize.toString()) + count + COUNT_UNIT);
        }
    }

    private enum PrizeMsg {
        NOTHING(""),
        FIFTH("3개 일치 (5,000원) - "),
        FOURTH("4개 일치 (50,000원) - "),
        THIRD("5개 일치 (1,500,000원) - "),
        SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        FIRST("6개 일치 (2,000,000,000원) - ");

        private final String message;

        PrizeMsg(String message) {
            this.message = message;
        }

        public static String findMessage(String message) {
            return Stream.of(values())
                    .filter(prizeMsg -> Objects.equals(prizeMsg.toString(), message))
                    .findFirst()
                    .orElse(NOTHING)
                    .message;
        }
    }
}