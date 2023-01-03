package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @Nested
    class bonusNumberTest {
        @Test
        void 보너스_번호_1_45_검증() {
            assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 45), 0))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 45), 46))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 보너스_번호_중복_검증() {
            assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 1))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class drawTest {
        private WinningLotto winningLotto;

        @BeforeEach
        void setUp() {
            winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
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
}
