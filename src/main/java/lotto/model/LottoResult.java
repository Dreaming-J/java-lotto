package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class LottoResult {
    private static final String WRONG_COST_BY_NEGATIVE_INTEGER = "구입금액은 양수만 입력 가능합니다.";
    private static final String WRONG_COST_BY_NOT_DIVIDED_TO_1000 = "구입금액은 1,000단위로 입력해야 합니다.";
    private static final String DECIMAL_POINT = ".";
    private static final String COMMA = ",";
    private static final int ZERO = 0;
    private static final int UNIT_COST = 1000;
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

    public int calTotalPrize(List<LottoPrize> prize) {
        return prize.stream()
                .map(LottoPrize::getPrize)
                .reduce(Integer::sum)
                .get();
    }

    public String yield(int totalPrize) {
        String yield = new BigDecimal((double) totalPrize / cost * 100)
                .setScale(2, RoundingMode.HALF_UP)
                .stripTrailingZeros()
                .toString();
        return modifyYieldForamt(yield);
    }

    private String modifyYieldForamt(String yield) {
        int indexDecimalPoint = yield.indexOf(DECIMAL_POINT);
        StringBuilder integerPart = new StringBuilder(yield.substring(ZERO, indexDecimalPoint));
        String decimalPart = yield.substring(indexDecimalPoint);

        return insertComma(integerPart) + decimalPart;
    }

    private String insertComma(StringBuilder integerPart) {
        int indexOfInsertComma = integerPart.length() - 3;

        while (indexOfInsertComma > ZERO) {
            integerPart.insert(indexOfInsertComma, COMMA);
            indexOfInsertComma -= 3;
        }
        return integerPart.toString();
    }
}
