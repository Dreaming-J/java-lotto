package lotto;

import lotto.enums.Ranking;
import lotto.model.Lotto;
import lotto.service.LottoCalculator;
import lotto.service.LottoComparator;
import lotto.utils.DataExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 범위 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoOutOfRangeNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 결과 판단 테스트")
    @Test
    void createSecondLotto() {
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        LottoComparator lottoComparator = new LottoComparator(List.of(lotto1));

        List<Integer> winningNumbers = List.of(1,2,3,4,5,7);
        int bonusNumber = 6;
        List<Ranking> resultComparingLotto = lottoComparator.compareLottoNumbers(winningNumbers, bonusNumber);

        assertThat(resultComparingLotto.get(0)).isEqualTo(Ranking.Second);
    }

    @DisplayName("로또 당첨 통계 금액 테스트")
    @Test
    void calculateLottoPrize() {
        int amount = 3000;
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,8));
        Lotto lotto4 = new Lotto(List.of(1,2,3,4,9,8));
        Lotto lotto5 = new Lotto(List.of(1,2,3,10,9,8));
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        LottoComparator lottoComparator = new LottoComparator(List.of(lotto3, lotto4, lotto5));
        List<Ranking> resultComparingLotto = lottoComparator.compareLottoNumbers(winningNumbers, bonusNumber);

        LottoCalculator lottoCalculator = new LottoCalculator(amount);
        lottoCalculator.calResultLotto(resultComparingLotto);

        assertThat(lottoCalculator.calTotalPrize()).isEqualTo(1555000f);
    }

    @DisplayName("로또 수익률 테스트")
    @Test
    void calculateLottoRateOfReturn() {
        int amount = 3000;
        LottoCalculator lottoCalculator = new LottoCalculator(amount);
        double totalPrize = 1555000f;

        assertThat(lottoCalculator.calRateOfReturn(totalPrize)).isEqualTo(51833.33);
    }

    @DisplayName("수익률 정수, 소수 분리 테스트")
    @Test
    void extractNumber() {
        DataExtractor dataExtractor = new DataExtractor();
        double number1 = 1234567.05;
        double number2 = 123456.05;
        double number3 = 12345.05;

        assertThat(dataExtractor.extractIntegerPart(number1) + dataExtractor.extractDecimalPart(number1)).isEqualTo("1,234,567.05");
        assertThat(dataExtractor.extractIntegerPart(number2) + dataExtractor.extractDecimalPart(number2)).isEqualTo("123,456.05");
        assertThat(dataExtractor.extractIntegerPart(number3) + dataExtractor.extractDecimalPart(number3)).isEqualTo("12,345.05");
    }
}
