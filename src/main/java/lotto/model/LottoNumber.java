package lotto.model;

import java.util.Objects;

public class LottoNumber {

    private static final String WRONG_RANGE_OF_NUMBER = "로또는 1에서 45사이의 숫자로 이루어져야 합니다.";
    private static final int MIN_NO = 1;
    private static final int MAX_NO = 45;

    private final int no;

    public LottoNumber(int no) {
        if (no < MIN_NO || no > MAX_NO) {
            throw new IllegalArgumentException(WRONG_RANGE_OF_NUMBER);
        }

        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return no == that.no;
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }
}
