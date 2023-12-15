package lotto.service;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConst;
import lotto.domain.Lotto;

import java.util.List;

public class LottoPrizeService {

    private Lotto prizeLotto;
    private int bonusNumber;

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
}
