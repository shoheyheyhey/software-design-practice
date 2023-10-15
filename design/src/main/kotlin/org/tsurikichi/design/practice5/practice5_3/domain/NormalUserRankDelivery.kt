package org.tsurikichi.design.practice5.practice5_3.domain

class NormalUserRankDelivery: UserRankDelivery {
    override fun getPostage(purchaseAmount: Int): Int {
        return if (purchaseAmount >= 3_000) 0 else 100
    }

    override fun canTodayDelivery(): Boolean {
        return false
    }

}
