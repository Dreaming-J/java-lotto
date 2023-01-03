package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final String WRONG_FORMAT_OF_LOTTO_NUMBER = "로또는 중복되지 않는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(WRONG_FORMAT_OF_LOTTO_NUMBER);
        }
    }

    public int draw(Lotto lotto) {
        return (int) numbers.stream()
                .map(lotto::draw)
                .filter(bool -> bool)
                .count();
    }

    public boolean draw(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }
}
