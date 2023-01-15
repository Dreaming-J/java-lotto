package lotto;

import lotto.model.Lotto;
import lotto.utils.InputValidator;
import lotto.utils.LottoValidator;
import static lotto.utils.TypeConverter.convertStringToInt;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {

    InputValidator inputValidator = new InputValidator();

    @DisplayName("컨버터")
    @Nested
    class Converter {

        @DisplayName("숫자 형식이 아닐 경우 컨버터에서 예외가 발생한다.")
        @Test
        void convertNotNumberStringToNumber() {
            assertThatThrownBy(() -> convertStringToInt("1a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }    }

    @DisplayName("구입 금액")
    @Nested
    class Amount {

        @DisplayName("로또 구입 금액이 1000원 단위가 아닐 경우 예외가 발생한다.")
        @Test
        void createAmountNotDivided1000() {
            assertThatThrownBy(() -> inputValidator.validateAmount(1500))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("로또 구입 금액이 1000원 이하일 경우 예외가 발생한다.")
        @Test
        void createAmountUnder1000() {
            assertThatThrownBy(() -> inputValidator.validateAmount(100))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("당첨번호")
    @Nested
    class WinningNumber {

        @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> new LottoValidator(List.of(1,2,3,4,5,6,7)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoByDuplicatedNumber() {
            assertThatThrownBy(() -> new LottoValidator(List.of(1, 2, 3, 4, 5, 5)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("당첨 번호에 범위 외의 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoOutOfRangeNumber() {
            assertThatThrownBy(() -> new LottoValidator(List.of(0, 2, 3, 4, 5, 45)))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> new LottoValidator(List.of(1, 2, 3, 4, 5, 46)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("보너스번호")
    @Nested
    class BonusNumber {

        List<Integer> winningNumber = List.of(1,2,3,4,5,6);

        @DisplayName("보너스 번호가 당첨 번호에 포함되는 숫자이면 예외가 발생한다.")
        @Test
        void createLottoByOverSize() {
            assertThatThrownBy(() -> inputValidator.validateBonusNumber(5, winningNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("보너스 번호에 범위 외의 숫자가 있으면 예외가 발생한다.")
        @Test
        void createLottoOutOfRangeNumber() {
            assertThatThrownBy(() -> inputValidator.validateBonusNumber(0, winningNumber))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> inputValidator.validateBonusNumber(0, winningNumber))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
