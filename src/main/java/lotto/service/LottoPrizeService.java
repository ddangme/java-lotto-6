package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConst;
import lotto.constant.Rank;
import lotto.domain.Lotto;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeService {

    private Lotto prizeLotto;
    private int bonusNumber;
    private Map<Rank, Integer> lottoResult = new LinkedHashMap<>();

    public LottoPrizeService() {
        lottoResult.put(Rank.FIFTH_RANK, 0);
        lottoResult.put(Rank.FOURTH_RANK, 0);
        lottoResult.put(Rank.THIRD_RANK, 0);
        lottoResult.put(Rank.SECOND_RANK, 0);
        lottoResult.put(Rank.FIRST_RANK, 0);
    }

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
            lottoResult.merge(Rank.SECOND_RANK, 1, Integer::sum);
            return;
        }
        lottoResult.merge(rank, 1, Integer::sum);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
