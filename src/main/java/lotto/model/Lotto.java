package lotto.model;

import lotto.enums.Ranking;
import lotto.utils.LottoValidator;

import java.util.List;

public class Lotto {

    private static final int ZERO = 0;
    private static final int MATCH_WINNING_NUMBER = 1;
    private static final int MATCH_BONUS_NUMMBER = 10;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        new LottoValidator(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public Ranking countMatchingNumber(List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = countMatchingWinningNumbers(winningNumbers) + countMatchingBonusNumbers(bonusNumber);

        return Ranking.getRankingByMatchingCount(matchingCount);
    }

    private int countMatchingWinningNumbers(List<Integer> winningNumbers) {
        int count = ZERO;

        for (int winningNumber : winningNumbers) {
            if (this.numbers.contains(winningNumber)) {
                count += MATCH_WINNING_NUMBER;
            }
        }

        return count;
    }

    private int countMatchingBonusNumbers(int bonusNumber) {
        int count = ZERO;

        if (this.numbers.contains(bonusNumber)) {
            count += MATCH_BONUS_NUMMBER;
        }

        return count;
    }
}
