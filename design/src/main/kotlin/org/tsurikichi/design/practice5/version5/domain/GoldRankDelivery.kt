package org.tsurikichi.design.practice5.version5.domain

class GoldRankDelivery : Delivery {
    override fun getPostage(purchaseAmount: Int): Int {
        return 0
    }

    override fun canTodayDelivery(): Boolean {
        return true
    }
}
