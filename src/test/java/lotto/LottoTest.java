package lotto;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

    @Test
    void 로또_번호_1_45_검증() {
        assertDoesNotThrow(() -> new Lotto(List.of(1, 2, 3, 4, 5, 45)));
        assertThatThrownBy(() -> new Lotto(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Nested
    class drawTest {

        private Lotto winningNumber;
        private BonusNumber bonusNumber;

        @BeforeEach
        void setUp() {
            winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            bonusNumber = new BonusNumber(7, winningNumber);
        }

        @Test
        void draw() {
            assertThat(winningNumber.draw(new LottoNumber(1))).isTrue();
            assertThat(winningNumber.draw(new LottoNumber(5))).isTrue();
            assertThat(winningNumber.draw(new LottoNumber(10))).isFalse();
        }

        @Test
        void draw_count_0() {
            Lotto lotto = new Lotto(List.of(11, 12, 13, 14, 15, 16));

            assertThat(winningNumber.draw(lotto)).isEqualTo(0);
        }

        @Test
        void draw_count_5() {
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 16));

            assertThat(winningNumber.draw(lotto)).isEqualTo(5);
        }
    }
}
