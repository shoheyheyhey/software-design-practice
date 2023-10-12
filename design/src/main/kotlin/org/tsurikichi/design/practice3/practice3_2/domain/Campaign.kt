package org.tsurikichi.design.practice3.practice3_2.domain

import java.time.LocalDate

class Campaign private constructor(val pointRate: Double?) {
    companion object {
        fun create(
            campaignStartDate: LocalDate,
            campaignEndDate: LocalDate,
            pointRate: Double
        ): Campaign {
            val today = LocalDate.now()
            val validCampaign =
                !today.isBefore(campaignStartDate) && !today.isAfter(campaignEndDate)

            if (validCampaign) return Campaign(pointRate)
            return Campaign(null)

        }
    }
}
