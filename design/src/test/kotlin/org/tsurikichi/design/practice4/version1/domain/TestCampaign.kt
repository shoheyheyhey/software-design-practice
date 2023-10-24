package org.tsurikichi.design.practice4.version1.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.LocalDate

class TestCampaign {

    @Nested
    inner class CalculateCampaignPoint {

        @Test
        fun `有効なキャンペーンの付与ポイントが算出できる`() {
            val campaign = Campaign(
                campaignStartDate = LocalDate.of(2023, 1, 1),
                campaignEndDate = LocalDate.of(2023, 12, 31),
                pointRate = 0.1
            )
            val actual = campaign.calculateCampaignPoint(1000)
            Assertions.assertEquals(100, actual)
        }

        @Test
        fun `中途半端な状態のキャンペーンが作れてしまってバグの危険がある`() {
            val campaign = Campaign(
                campaignStartDate = null,
                campaignEndDate = null,
                pointRate = null
            )

            // この間でcampaignの初期化が完了していないため、NullPointerExceptionが発生する
            // val actual = campaign.calculateCampaignPoint(1000)

            campaign.campaignStartDate = LocalDate.of(2023, 1, 1)
            campaign.campaignEndDate = LocalDate.of(2023, 12, 31)
            campaign.pointRate = 0.1
            val actual = campaign.calculateCampaignPoint(1000)

            Assertions.assertEquals(100, actual)
        }
    }
}
