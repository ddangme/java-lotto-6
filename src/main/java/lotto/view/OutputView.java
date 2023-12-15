package lotto.view;

import lotto.constant.Rank;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String BUY_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OPENING_BRACKET = "[";
    private static final String CLOSING_BRACKET = "]";

    private static final String THREE_HYPHEN = "---";
    private static final String ONE_HYPHEN = "- ";
    private static final String LOTTO_PRIZE_RESULT_MESSAGE = "당첨 통계";

    private static final String COUNT = "개";

    public void printBuyLottos(List<String> buyLottosNumbers) {
        System.out.println("\n" + buyLottosNumbers.size() + BUY_LOTTO_COUNT_MESSAGE);

        for (String buyLotto : buyLottosNumbers) {
            System.out.println(OPENING_BRACKET + buyLotto + CLOSING_BRACKET);
        }
        System.out.println();
    }

    public void printLottoPrizeResult(Map<Rank, Integer> lottoResult) {
        System.out.println(LOTTO_PRIZE_RESULT_MESSAGE);
        System.out.println(THREE_HYPHEN);
        printLottoRank(lottoResult);
    }

    private void printLottoRank(Map<Rank, Integer> lottoResult) {
        Set<Rank> ranks = lottoResult.keySet();

        for (Rank rank : ranks) {
            if (rank.hasPrizeMoney()) {
                System.out.println(rank.getRanktoString() + ONE_HYPHEN + lottoResult.get(rank) + COUNT);
            }
        }
    }
}
