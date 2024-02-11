package org.tsurikichi.design.practice5.version5.domain

class Rank private constructor(
    val rankType: RankType
) {
    companion object {
        fun create(
            previousMonthlyTotalAmount: Int
        ): Rank {
            return when {
                previousMonthlyTotalAmount >= 10_000 -> Rank(RankType.GOLD)
                previousMonthlyTotalAmount >= 1_000 -> Rank(RankType.SILVER)
                else -> Rank(RankType.NORMAL)
            }
        }
    }
}
