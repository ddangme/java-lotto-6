package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConst;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoAutoGenerateService {

    public List<Lotto> generateLottos(int payLottoCount) {
        List<Lotto> autoGenerateLotto = new ArrayList<>();
        for (int i = 0; i < payLottoCount; i++) {
            autoGenerateLotto.add(generateLotto());
        }

        return autoGenerateLotto;
    }

    private Lotto generateLotto() {
        List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LottoConst.MIN_LOTTO_NUMBER, LottoConst.MAX_LOTTO_NUMBER, LottoConst.LOTTO_NUMBER_COUNT));
        return new Lotto(randomNumbers);
    }
}
