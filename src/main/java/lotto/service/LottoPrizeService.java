package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConst;
import lotto.constant.Rank;
import lotto.domain.Lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeService {

    private Lotto prizeLotto;
    private int bonusNumber;
    private Map<Rank, Integer> ranks = new LinkedHashMap<>();

    public void setPrizeLotto(List<Integer> numbers) {
        this.prizeLotto = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplicateWithLottoNumber(bonusNumber);
    }

    private void validateBonusNumberDuplicateWithLottoNumber(int bonusNumber) {
        if (prizeLotto.containNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < LottoConst.MIN_LOTTO_NUMBER || bonusNumber > LottoConst.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public void calculateRank(List<Lotto> buyLottos) {
        for (Lotto buyLotto : buyLottos) {
            int sameNumberCount = buyLotto.getSameNumberCount(prizeLotto);
            addRank(sameNumberCount, buyLotto);
        }
    }

    private void addRank(int sameNumberCount, Lotto buyLotto) {
        Rank rank = Rank.values()[sameNumberCount];

        if (rank.equals(Rank.THIRD_RANK) && buyLotto.containNumber(bonusNumber)) {
            ranks.merge(Rank.SECOND_RANK, 1, Integer::sum);
            return;
        }
        ranks.merge(rank, 1, Integer::sum);
    }
}
