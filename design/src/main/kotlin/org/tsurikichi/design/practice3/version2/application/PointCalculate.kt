package org.tsurikichi.design.practice3.version2.application

import org.tsurikichi.design.practice3.version2.domain.Campaign
import org.tsurikichi.design.practice3.version2.domain.IsPointGrantTargetSpec
import org.tsurikichi.design.practice3.version2.domain.PointCalculateSpec
import org.tsurikichi.design.practice3.version2.domain.Rank
import java.time.LocalDate

class PointCalculate(private val pointCalculateSpec: PointCalculateSpec, private val isPointGrantTargetSpec: IsPointGrantTargetSpec) {
    fun execute(
        previousMonthlyPurchaseAmount: Int,
        previousMonthlyPurchaseCount: Int,
        campaignStartDate: LocalDate,
        campaignEndDate: LocalDate,
        pointRate: Double,
        purchaseAmount: Int
    ): Int {
        val campaign = Campaign.create(campaignStartDate, campaignEndDate, pointRate)
        val rank = Rank.create(previousMonthlyPurchaseAmount, previousMonthlyPurchaseCount)
        if (!isPointGrantTargetSpec.execute(rank, campaign)) return 0

        return pointCalculateSpec.execute(campaign.pointRate!!, purchaseAmount)
    }
}
