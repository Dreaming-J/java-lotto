package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        Lotto winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winningNumber);
        winningLotto = new WinningLotto(winningNumber, bonusNumber);
    }

    @Test
    void draw_First() {
        assertThat(winningLotto.draw(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(LottoPrize.FIRST);
    }

    @Test
    void draw_Second() {
        assertThat(winningLotto.draw(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    void draw_Third() {
        assertThat(winningLotto.draw(new Lotto(List.of(1, 2, 3, 4, 5, 10)))).isEqualTo(LottoPrize.THIRD);
    }

    @Test
    void draw_Nothing() {
        assertThat(winningLotto.draw(new Lotto(List.of(11, 12, 13, 14, 15, 16)))).isEqualTo(LottoPrize.NOTHING);
        assertThat(winningLotto.draw(new Lotto(List.of(1, 12, 13, 14, 15, 16)))).isEqualTo(LottoPrize.NOTHING);
        assertThat(winningLotto.draw(new Lotto(List.of(1, 2, 13, 14, 15, 16)))).isEqualTo(LottoPrize.NOTHING);
    }
}
