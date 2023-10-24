package org.tsurikichi.design.practice3.`practice3-2`.domain

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.LocalDate

class TestCampaign {

    @AfterEach
    fun afterEach() {
        unmockkStatic(LocalDate::class)
    }

    @Nested
    inner class CampaignCreate {

        @Test
        fun `キャンペーン期間中はポイント付与率が設定できる`() {
            val now = LocalDate.of(2023, 10, 1)
            val campaignStartDate = LocalDate.of(2023, 10, 1)
            val campaignEndDate = LocalDate.of(2023, 11, 1)
            val expect = 0.01
            mockkStatic(LocalDate::class)
            every { LocalDate.now() } returns now

            val rank = Campaign.create(campaignStartDate, campaignEndDate, expect)

            Assertions.assertEquals(expect, rank.pointRate)
        }

        @Test
        fun `キャンペーン期間外はポイント付与率が設定できない`() {
            val now = LocalDate.of(2023, 12, 1)
            val campaignStartDate = LocalDate.of(2023, 10, 1)
            val campaignEndDate = LocalDate.of(2023, 11, 1)
            mockkStatic(LocalDate::class)
            every { LocalDate.now() } returns now

            val rank = Campaign.create(campaignStartDate, campaignEndDate, 0.01)

            Assertions.assertNull(rank.pointRate)
        }
    }
}
