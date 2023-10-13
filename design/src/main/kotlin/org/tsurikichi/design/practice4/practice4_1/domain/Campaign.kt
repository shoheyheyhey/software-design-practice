package org.tsurikichi.design.practice4.practice4_1.domain

import java.time.LocalDate
import kotlin.math.floor

class Campaign(
    var campaignStartDate: LocalDate?,
    var campaignEndDate: LocalDate?,
    var pointRate: Double?
) {

    fun calculateCampaignPoint(purchaseAmount: Int): Int {
        if (!isValidCampaign()) return 0
        return floor(pointRate!! * purchaseAmount).toInt() // ここではpointRateが必ず入る想定

    }

    private fun isValidCampaign(): Boolean {
        val today = LocalDate.now()
        return !today.isBefore(campaignStartDate) && !today.isAfter(campaignEndDate)
    }
}
