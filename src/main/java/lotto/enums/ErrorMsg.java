package lotto.enums;

public enum ErrorMsg {
    ERROR_PREFIX("[ERROR] "),
    ERROR_MSG_LOTTO_NUMBER_SIZE_IS_SIX("로또 번호는 6개의 숫자 조합이어야 합니다."),
    ERROR_MSG_LOTTO_NUMBER_SIZE_IS_NOT_DUPLICATED("로또 번호는 중복 없는 숫자의 조합이어야 합니다."),
    ERROR_MSG_LOTTO_NUMBER_IS_BETWEEN_ONE_AND_FOURTYFIVE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_MSG_AMOUNT_IS_NUMBER("구입 금액은 숫자로 입력해주세요."),
    ERROR_MSG_AMOUNT_IS_OVER_ONE_THOUSAND("구입 금액은 최소 1,000원 이상이어야 합니다."),
    ERROR_MSG_AMOUNT_IS_DIVIDED_ONE_THOUSAND("구입 금액은 1,000원 단위의 숫자여야 합니다."),
    ERROR_MSG_WINNING_NUMBER_IS_NUMBER("당첨 번호는 쉼표를 기준으로 구분된 숫자여야 합니다."),
    ERROR_MSG_BONUS_NUMBER_IS_NOT_INCLUDED_IN_WINNING_NUMBER("보너스 번호는 당첨 번호에 포함되지 않은 숫자여야 합니다.");

    private final String message;

    ErrorMsg(String message) {
        this.message = message;
    }

    public String get() {
        return this.message;
    }
}
