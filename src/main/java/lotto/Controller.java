package lotto;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConst;
import lotto.domain.Lotto;
import lotto.service.AutoGenerateLottoService;
import lotto.utils.ParseUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    AutoGenerateLottoService autoGenerateLottoService = new AutoGenerateLottoService();

    public void run() {
        int payLottoAmount = getPayLottoAmount();
        List<Lotto> buyLottos = getBuyLottos(payLottoAmount);
        showBuyLottoNumbers(buyLottos);
    }

    private int getPayLottoAmount() {
        while (true) {
            try {
                String inputPayLottoAmount = inputView.inputPayLottoAmountMessage();
                int payLottoAmount = ParseUtil.stringToInt(inputPayLottoAmount);
                validatePayLottoAmount(payLottoAmount);

                return payLottoAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePayLottoAmount(int payLottoAmount) {
        if (payLottoAmount % LottoConst.UNIT_PAY_LOTTO_MONEY != 0) {
            throw new IllegalArgumentException(ErrorMessage.PAY_LOTTO_AMOUNT_UNIT_ERROR_MESSAGE);
        }
        if (payLottoAmount > LottoConst.MAX_PAY_LOTTO_MONEY) {
            throw new IllegalArgumentException(ErrorMessage.PAY_LOTTO_AMOUNT_RANGE_ERROR_MESSAGE);
        }
    }

    private List<Lotto> getBuyLottos(int payLottoAmount) {
        int payLottoCount = payLottoAmount / LottoConst.UNIT_PAY_LOTTO_MONEY;
        return autoGenerateLottoService.generateLottos(payLottoCount);
    }

    private void showBuyLottoNumbers(List<Lotto> lottos) {
        List<String> buyLottoNumbers = new ArrayList<>();

        for (Lotto lotto : lottos) {
            buyLottoNumbers.add(lotto.getNumbersToString());
        }

        outputView.printBuyLottos(buyLottoNumbers);
    }

}
