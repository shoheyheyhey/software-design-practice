package org.tsurikichi.design.practice5.version5.domain

class SilverRankDelivery : Delivery {
    override fun getPostage(purchaseAmount: Int): Int {
        return if (purchaseAmount >= 3_000) 0 else 50
    }

    override fun canTodayDelivery(): Boolean {
        return false
    }
}
