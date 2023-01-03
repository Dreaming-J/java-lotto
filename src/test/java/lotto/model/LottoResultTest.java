package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoResultTest {

    @Test
    void 구입_금액_1000_단위_검증() {
        assertDoesNotThrow(() -> new LottoResult(5000));
        assertThatThrownBy(() -> new LottoResult((500)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상금_계산() {
        List<LottoPrize> prize = List.of(LottoPrize.FIFTH, LottoPrize.FIRST, LottoPrize.SECOND);
        LottoResult result = new LottoResult(10000);
        assertThat(result.calTotalPrize(prize)).isEqualTo(2030005000);
    }
}
