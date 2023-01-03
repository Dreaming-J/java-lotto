package lotto.model;

import java.util.List;

public class LottoResult {
    private static final String WRONG_COST_BY_NEGATIVE_INTEGER = "구입금액은 양수만 입력 가능합니다.";
    private static final int ZERO = 0;
    private static final int UNIT_COST = 1000;
    private static final String WRONG_COST_BY_NOT_DIVIDED_TO_1000 = "구입금액은 1,000단위로 입력해야 합니다.";
    private final int cost;

    public LottoResult(int cost) {
        validate(cost);
        this.cost = cost;
    }

    private void validate(int cost) {
        if (cost <= ZERO) {
            throw new IllegalArgumentException(WRONG_COST_BY_NEGATIVE_INTEGER);
        }
        if (cost % UNIT_COST != ZERO) {
            throw new IllegalArgumentException(WRONG_COST_BY_NOT_DIVIDED_TO_1000);
        }
    }
}
