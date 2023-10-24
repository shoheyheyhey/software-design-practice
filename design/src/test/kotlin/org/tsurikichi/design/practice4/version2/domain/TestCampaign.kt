package org.tsurikichi.design.practice4.version2.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate

class TestCampaign {

    @Nested
    inner class CalculateCampaignPoint {

        @Test
        fun `有効なキャンペーンの付与ポイントが算出できる`() {
            val campaign = Campaign.create(
                campaignStartDate = LocalDate.of(2023, 1, 1),
                campaignEndDate = LocalDate.of(2023, 12, 31),
                pointRate = 0.1
            )
            val actual = campaign.calculateCampaignPoint(1000)
            Assertions.assertEquals(100, actual)
        }

        @Test
        fun `有効期限が不正なキャンペーンは作れない`() {
            assertThrows<IllegalArgumentException> {
                Campaign.create(
                    campaignStartDate = LocalDate.of(2023, 12, 31),
                    campaignEndDate = LocalDate.of(2023, 1, 1),
                    pointRate = 0.1
                )
            }
        }
    }
}
