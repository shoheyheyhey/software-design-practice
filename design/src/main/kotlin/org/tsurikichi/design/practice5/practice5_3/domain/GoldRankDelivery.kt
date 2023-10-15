package org.tsurikichi.design.practice5.practice5_3.domain

class GoldRankDelivery: Delivery {
    override fun getPostage(purchaseAmount: Int): Int {
        return 0
    }

    override fun canTodayDelivery(): Boolean {
        return true
    }

}
