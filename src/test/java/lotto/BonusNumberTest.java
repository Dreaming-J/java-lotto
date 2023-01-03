package lotto;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BonusNumberTest {

    private Lotto answer;

    @BeforeEach
    void setUp() {
        answer = new Lotto(List.of(11, 12, 13, 14, 15, 16));
    }

    @Test
    void 보너스_번호_1_45_검증() {
        assertDoesNotThrow(() -> new BonusNumber(1, answer));
        assertDoesNotThrow(() -> new BonusNumber(45, answer));
        assertThatThrownBy(() -> new BonusNumber(0, answer))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BonusNumber(46, answer))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_검증() {
        assertThatThrownBy(() -> new BonusNumber(15, answer))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
