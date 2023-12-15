package lotto.constant;

public enum Rank {
    NO_RANK_0(0),
    NO_RANK_1(0),
    NO_RANK_2(0),
    FIFTH_RANK(5_000),
    FOURTH_RANK(50_000),
    THIRD_RANK(1_500_000),
    FIRST_RANK(2_000_000_000),
    SECOND_RANK(30_000_000);

    private int prizeMoney;

    Rank(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
}
