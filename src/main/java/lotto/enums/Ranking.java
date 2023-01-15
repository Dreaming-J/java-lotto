package lotto.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Ranking {
    Fifth(3, 5000, "3개 일치 (5,000원)"),
    Fourth(4, 50000, "4개 일치 (50,000원)"),
    Third(5, 1500000, "5개 일치 (1,500,000원)"),
    Second(15, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    First(6,2000000000,  "6개 일치 (2,000,000,000원)"),
    None(0,999, "");

    private final int matchingCount;
    private final int prize;
    private final String message;

    Ranking(int matchingCount, int prize, String message) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.message = message;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getMessage() {
        return this.message;
    }
  
    public static Ranking getRankingByMatchingCount(int matchingCount) {
        return Stream.of(values())
                .filter(ranking -> ranking.matchingCount == matchingCount)
                .findFirst()
                .orElse(None);
    }

    public static List<Ranking> getRealRanking() {
        return Stream.of(values())
                .filter(ranking -> ranking.matchingCount > None.matchingCount)
                .collect(Collectors.toList());
    }
}
