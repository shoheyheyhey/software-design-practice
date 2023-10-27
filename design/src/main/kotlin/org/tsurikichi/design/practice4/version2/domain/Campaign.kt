package org.tsurikichi.design.practice4.version2.domain

import java.time.LocalDate
import kotlin.math.floor

class Campaign private constructor(
    private val campaignStartDate: LocalDate,
    private val campaignEndDate: LocalDate,
    private val pointRate: Double
) {
    companion object {
        fun create(
            campaignStartDate: LocalDate,
            campaignEndDate: LocalDate,
            pointRate: Double
        ): Campaign {
            if (!campaignStartDate.isBefore(campaignEndDate)) throw IllegalArgumentException("キャンペーンの開始日は終了日より前である必要があります")

            return Campaign(
                campaignStartDate = campaignStartDate,
                campaignEndDate = campaignEndDate,
                pointRate = pointRate
            )
        }
    }

    fun calculateCampaignPoint(purchaseAmount: Int): Int {
        if (!isValidCampaign()) return 0
        return floor(pointRate * purchaseAmount).toInt() // ここではpointRateが必ず入る想定
    }

    private fun isValidCampaign(): Boolean {
        val today = LocalDate.now()
        return !today.isBefore(campaignStartDate) && !today.isAfter(campaignEndDate)
    }
}
