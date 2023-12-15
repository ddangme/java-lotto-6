package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PAY_LOTTO_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PRIZE_LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPayLottoAmountMessage() {
        System.out.println(INPUT_PAY_LOTTO_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String inputPrizeLottoNumberMessage() {
        System.out.println(INPUT_PRIZE_LOTTO_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusLottoNumberMessage() {
        System.out.println(INPUT_BONUS_LOTTO_NUMBER_MESSAGE);
        return Console.readLine();
    }

}
