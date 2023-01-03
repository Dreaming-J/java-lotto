package lotto.model;

import java.util.stream.Stream;

public enum LottoPrize {

    NOTHING(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int count;
    private final int prize;

    LottoPrize(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoPrize from(int drawCount) {
        return Stream.of(values())
                .filter(prize -> prize.count == drawCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public boolean isThird() {
        return this == THIRD;
    }

    public LottoPrize isSecond(boolean correctBonusNumber) {
        if (correctBonusNumber) {
            return SECOND;
        }
        return this;
    }
}
