package org.tsurikichi.design.practice3.version1.application

import java.time.LocalDate
import kotlin.math.floor

class PointCalculate {
    fun execute(
        previousMonthlyPurchaseAmount: Int,
        previousMonthlyPurchaseCount: Int,
        campaignStartDate: LocalDate,
        campaignEndDate: LocalDate,
        pointRate: Double,
        purchaseAmount: Int
    ): Int {
        val today = LocalDate.now()
        val validCampaign = !today.isBefore(campaignStartDate) && !today.isAfter(campaignEndDate)
        if (!validCampaign) return 0

        val rank = if (previousMonthlyPurchaseAmount > 10_000) {
            RankType.GOLD
        } else if (previousMonthlyPurchaseCount > 10 && previousMonthlyPurchaseAmount > 5_000) {
            RankType.SILVER
        } else {
            RankType.BRONZE
        }

        if (RankType.BRONZE == rank) return 0

        return floor(purchaseAmount * pointRate).toInt()
    }
}

enum class RankType {
    BRONZE,
    SILVER,
    GOLD
}
