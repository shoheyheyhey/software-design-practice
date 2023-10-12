package org.tsurikichi.design.practice3.practice3_2.application_service

import org.tsurikichi.design.practice3.practice3_1.application_service.PointCalculate
import org.tsurikichi.design.practice3.practice3_2.domain.Campaign
import org.tsurikichi.design.practice3.practice3_2.domain.IsPointGrantTargetSpec
import org.tsurikichi.design.practice3.practice3_2.domain.PointCalculateSpec
import org.tsurikichi.design.practice3.practice3_2.domain.Rank
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
