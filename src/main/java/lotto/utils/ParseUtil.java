package lotto.utils;

import lotto.constant.ErrorMessage;

public class ParseUtil {

    public static int stringToInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PAY_LOTTO_AMOUNT_TYPE_ERROR_MESSAGE);
        }
    }
}
