package lotto.model;

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

        @BeforeEach
        void setUp() {
            winningNumber = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        }

        @Test
        void draw_단일_비교() {
            assertThat(winningNumber.draw(new LottoNumber(1))).isTrue();
            assertThat(winningNumber.draw(new LottoNumber(5))).isTrue();
            assertThat(winningNumber.draw(new LottoNumber(10))).isFalse();
        }

        @Test
        void draw_전체_일치_개수_0_6() {
            assertThat(winningNumber.draw(new Lotto(List.of(11, 12, 13, 14, 15, 16)))).isEqualTo(0);
            assertThat(winningNumber.draw(new Lotto(List.of(1, 12, 13, 14, 15, 16)))).isEqualTo(1);
            assertThat(winningNumber.draw(new Lotto(List.of(1, 2, 13, 14, 15, 16)))).isEqualTo(2);
            assertThat(winningNumber.draw(new Lotto(List.of(1, 2, 3, 14, 15, 16)))).isEqualTo(3);
            assertThat(winningNumber.draw(new Lotto(List.of(1, 2, 3, 4, 15, 16)))).isEqualTo(4);
            assertThat(winningNumber.draw(new Lotto(List.of(1, 2, 3, 4, 5, 16)))).isEqualTo(5);
            assertThat(winningNumber.draw(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
        }
    }
}
