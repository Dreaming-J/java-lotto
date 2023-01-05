package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String LINE_BREAK = "\n";
    private static final String LOTTO_COUNT_POSTFIX_MSG = "개를 구매했습니다.";

    public void printLottos(int count, List<Lotto> lottos) {
        System.out.println(LINE_BREAK + count + LOTTO_COUNT_POSTFIX_MSG);
        for (Lotto lotto: lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers().stream()
                    .map(LottoNumber::getNo)
                    .collect(Collectors.toList());
            System.out.println(lottoNumbers);
        }
    }
}