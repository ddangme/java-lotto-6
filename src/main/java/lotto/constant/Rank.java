package lotto.constant;

import java.text.DecimalFormat;

public enum Rank {
    NO_RANK_0(0, null),
    NO_RANK_1(0, null),
    NO_RANK_2(0, null),
    FIFTH_RANK(5_000, "3개 일치"),
    FOURTH_RANK(50_000, "4개 일치"),
    THIRD_RANK(1_500_000, "5개 일치"),
    FIRST_RANK(2_000_000_000, "6개 일치"),
    SECOND_RANK(30_000_000, "5개 일치, 보너스 볼 일치");

    private int prizeMoney;
    private String condition;

    Rank(int prizeMoney, String condition) {
        this.prizeMoney = prizeMoney;
        this.condition = condition;
    }

    public boolean hasPrizeMoney() {
        return condition != null;
    }

    public String getRanktoString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return condition + " (" + decimalFormat.format(prizeMoney) + "원) ";
    }
}
