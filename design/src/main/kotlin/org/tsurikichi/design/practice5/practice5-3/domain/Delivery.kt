package org.tsurikichi.design.practice5.`practice5-3`.domain

interface Delivery {
    companion object {
        private val map: Map<RankType, Delivery> = mapOf(
            RankType.NORMAL to NormalRankDelivery(),
            RankType.SILVER to SilverRankDelivery(),
            RankType.GOLD to GoldRankDelivery()
        )

        fun factory(rankType: RankType): Delivery {
            return map[rankType] ?: throw IllegalArgumentException()
        }
    }
    fun getPostage(purchaseAmount: Int): Int
    fun canTodayDelivery(): Boolean
}
