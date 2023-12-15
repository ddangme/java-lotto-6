package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConst;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public String getNumbersToString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
    }

    // TODO: 추가 기능 구현
}
