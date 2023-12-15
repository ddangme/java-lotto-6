package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BUY_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";
    public void printBuyLottos(List<String> buyLottosNumbers) {
        System.out.println("\n" + buyLottosNumbers.size() + BUY_LOTTO_COUNT_MESSAGE);

        for (String buyLotto : buyLottosNumbers) {
            System.out.println(OPENING_BRACKET + buyLotto + CLOSING_BRACKET);
        }
        System.out.println();
    }
}
