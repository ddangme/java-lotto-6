package lotto.controller;

import lotto.constants.Message;
import lotto.constants.Value;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.LottoResultService;
import lotto.service.LottoService;
import lotto.utils.InputUtils;

import java.util.List;

public class Controller {

    InputUtils inputUtils = new InputUtils();

    LottoService lottoService = new LottoService();
    LottoResultService lottoResultService = new LottoResultService();

    public void run() {
        buyLotto();
        createWinningLotto();
        showResult();
    }


    private void buyLotto() {
        System.out.println(Message.PAY_MONEY_REQUEST_MESSAGE);
        while (true) {
            try {
                int payMoney = inputUtils.inputPayMoney();
                lottoService.setBuyLotto(payMoney);
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        lottoService.showBuyLottos();
    }

    private void createWinningLotto() {
        System.out.println(Message.WINNING_NUMBER_REQUEST_MESSAGE);
        while (true) {
            try {
                List<Integer> winningLottoNumbers = inputUtils.inputWinningLottoNumbers();
                WinningLotto winningLotto = new WinningLotto(winningLottoNumbers);
                createWinningLottoBonus(winningLotto);
                lottoResultService.setWinningLotto(winningLotto);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createWinningLottoBonus(WinningLotto winningLotto) {
        System.out.println(Message.BONUS_NUMBER_REQUEST_MESSAGE);
        while (true) {
            try {
                int winningBonusNumber = inputUtils.inputWinningBonusNumber();
                winningLotto.setBonusNumber(winningBonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void showResult() {
        List<Lotto> buyLottos = lottoService.getBuyLottos();

        lottoResultService.showRank(buyLottos);

        int payMoney = buyLottos.size() * Value.LOTTO_TICKET_PRICE;
        lottoResultService.showProfitRate(payMoney);
    }
}
