package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGenerator {

    private static final int LOWER_LOTTO_NUMBER_INCLUSIVE = 1;
    private static final int UPPER_LOTTO_NUMBER_INCLUSIVE = 45;
    private static final int NUMBER_COUNT_IN_ONE_LOTTO = 6;


    public List<Lotto> createLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = pickRandomLottoNumber().stream()
                    .sorted()
                    .collect(Collectors.toList());
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> pickRandomLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(LOWER_LOTTO_NUMBER_INCLUSIVE, UPPER_LOTTO_NUMBER_INCLUSIVE, NUMBER_COUNT_IN_ONE_LOTTO);
    }
}
