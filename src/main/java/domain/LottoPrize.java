package domain;

import java.util.Arrays;

public enum LottoPrize {
    MISS(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean isMatchBonus;

    LottoPrize(final int matchCount, final int prize, final boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.isMatchBonus = isMatchBonus;
    }

    public static LottoPrize matchPrize(final int matchCount, final boolean isWithBonus) {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .filter(prize -> prize.isMatchBonus == isWithBonus)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }
}

