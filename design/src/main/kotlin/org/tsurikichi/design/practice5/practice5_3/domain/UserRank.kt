package org.tsurikichi.design.practice5.practice5_3.domain

class UserRank private constructor(
    val rankType: UserRankType,
) {
    companion object {
        fun create(
            previousMonthlyTotalAmount: Int
        ): UserRank {
            return when {
                previousMonthlyTotalAmount >= 10_000 -> UserRank(UserRankType.GOLD)
                previousMonthlyTotalAmount >= 1_000 -> UserRank(UserRankType.SILVER)
                else -> UserRank(UserRankType.NORMAL)
            }
        }
    }

}
