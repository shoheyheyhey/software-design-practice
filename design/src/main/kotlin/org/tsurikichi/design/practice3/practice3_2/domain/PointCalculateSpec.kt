package org.tsurikichi.design.practice3.practice3_2.domain

import kotlin.math.floor

class PointCalculateSpec {
    companion object {
        fun execute(rank: Rank, campaign: Campaign, purchaseAmount: Int): Int {
            if (campaign.pointRate == null) return 0
            if (RankType.BRONZE == rank.rankType) return 0
            return floor(purchaseAmount * campaign.pointRate).toInt()

        }
    }
}
