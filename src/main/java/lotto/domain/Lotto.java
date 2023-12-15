package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConst;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDuplicate(numbers);
    }

    private void validateLottoNumberDuplicate(List<Integer> numbers) {
        Set<Integer> noDuplicateNumbers = new HashSet<>(numbers);
        if (noDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LottoConst.MIN_LOTTO_NUMBER || number > LottoConst.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoConst.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
        }
    }

    public String getNumbersToString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public int getSameNumberCount(Lotto prizeLotto) {
        return (int) numbers.stream()
                .filter(prizeLotto::containNumber)
                .count();
    }
}
