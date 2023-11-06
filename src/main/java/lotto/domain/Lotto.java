package lotto.domain;

import lotto.constants.ErrorMessage;
import lotto.constants.Value;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Value.LOTTO_START_NUMBER || number > Value.LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_FORMAT.getMessage());
        }
    }

    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
