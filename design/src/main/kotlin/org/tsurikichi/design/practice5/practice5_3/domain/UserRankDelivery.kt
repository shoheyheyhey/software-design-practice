package org.tsurikichi.design.practice5.practice5_3.domain

interface UserRankDelivery {
    companion object {
        private val map: Map<UserRankType, UserRankDelivery> = mapOf(
            UserRankType.NORMAL to NormalUserRankDelivery(),
            UserRankType.SILVER to SilverUserRankDelivery(),
            UserRankType.GOLD to GoldUserRankDelivery()
        )

        fun factory(userRankType: UserRankType): UserRankDelivery {
            return map[userRankType] ?: throw IllegalArgumentException()

        }
    }
    fun getPostage(purchaseAmount: Int): Int
    fun canTodayDelivery(): Boolean
}
