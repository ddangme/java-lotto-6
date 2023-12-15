package lotto.utils;

import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseUtil {

    public static int stringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INTEGER_TYPE_ERROR_MESSAGE);
        }
    }

    public static List<Integer> stringToIntegerList(String value) {
        List<String> splitValues = stringToStringList(value);
        return stringListToIntegerList(splitValues);
    }

    private static List<String> stringToStringList(String value) {
        return Arrays.stream(value.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static List<Integer> stringListToIntegerList(List<String> values) {
        List<Integer> numbers = new ArrayList<>();

        for (String value : values) {
            try {
                numbers.add(Integer.parseInt(value));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_REGEX_ERROR_MESSAGE);
            }
        }

        return numbers;
    }

}
