package org.tsurikichi.design.practice3.practice3_2.domain

class Rank private constructor(val rankType: RankType) {
    companion object {
        fun create(previousMonthlyPurchaseAmount: Int, previousMonthlyPurchaseCount: Int): Rank {
            if (previousMonthlyPurchaseAmount > 10_000) return Rank(RankType.GOLD)
            if (previousMonthlyPurchaseCount > 10 && previousMonthlyPurchaseAmount > 5_000) return Rank(
                RankType.SILVER
            )
            return Rank(RankType.BRONZE)
        }
    }
}

enum class RankType {
    BRONZE,
    SILVER,
    GOLD
}
