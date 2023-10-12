package org.tsurikichi.design.practice3.practice3_2.domain

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.LocalDate

class TestPointCalculateSpec {

    @AfterEach
    fun afterEach() {
        unmockkStatic(LocalDate::class)
    }

    @Nested
    inner class Execute {

        @Test
        fun `Goldランクの会員にキャンペーン期間中のポイントが算出できる`() {

            val campaignStartDate = LocalDate.of(2023, 10, 1)
            val campaignEndDate = LocalDate.of(2023, 11, 1)
            val now = LocalDate.of(2023,10,1)
            mockkStatic(LocalDate::class)
            every { LocalDate.now() } returns now

            val rank = Rank.create(11_000, 5)
            val campaign = Campaign.create(
                campaignStartDate = campaignStartDate,
                campaignEndDate = campaignEndDate,
                pointRate = 0.01
            )
            val target = PointCalculateSpec()

            val actual = target.execute(rank, campaign, 1000)


            Assertions.assertEquals(10, actual)
        }

        @Test
        fun `Bronzeランクの会員のポイントは0になる`() {

            val campaignStartDate = LocalDate.of(2023, 10, 1)
            val campaignEndDate = LocalDate.of(2023, 11, 1)
            val now = LocalDate.of(2023,10,1)
            mockkStatic(LocalDate::class)
            every { LocalDate.now() } returns now

            val rank = Rank.create(5_000, 5)
            val campaign = Campaign.create(
                campaignStartDate = campaignStartDate,
                campaignEndDate = campaignEndDate,
                pointRate = 0.01
            )
            val target = PointCalculateSpec()

            val actual = target.execute(rank, campaign, 1000)


            Assertions.assertEquals(0, actual)
        }

        @Test
        fun `キャンペーン期間外のポイントは0になる`() {


            val campaignStartDate = LocalDate.of(2023, 10, 1)
            val campaignEndDate = LocalDate.of(2023, 11, 1)
            val now = LocalDate.of(2023,12,1)
            mockkStatic(LocalDate::class)
            every { LocalDate.now() } returns now

            val rank = Rank.create(5_000, 5)
            val campaign = Campaign.create(
                campaignStartDate = campaignStartDate,
                campaignEndDate = campaignEndDate,
                pointRate = 0.01
            )
            val target = PointCalculateSpec()

            val actual = target.execute(rank, campaign, 1000)


            Assertions.assertEquals(0, actual)
        }



    }

}
