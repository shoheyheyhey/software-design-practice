package org.tsurikichi.design.practice5.version4.domain

class NormalRankDelivery : Delivery {
    override fun getPostage(purchaseAmount: Int): Int {
        return if (purchaseAmount >= 3_000) 0 else 100
    }

    override fun canTodayDelivery(): Boolean {
        return false
    }
}
