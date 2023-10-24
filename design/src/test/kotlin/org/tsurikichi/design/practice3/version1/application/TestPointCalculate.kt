package org.tsurikichi.design.practice3.version1.application

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

class TestPointCalculate {
    @AfterEach
    fun afterEach() {
        unmockkStatic(LocalDate::class)
    }

    @Test
    fun `キャンペーン期間内でランクGold会員にはポイントが付与できる`() {
        val now = LocalDate.of(2023, 10, 1)
        val campaignStartDate = LocalDate.of(2023, 10, 1)
        val campaignEndDate = LocalDate.of(2023, 11, 1)
        mockkStatic(LocalDate::class)
        every { LocalDate.now() } returns now

        val target = PointCalculate()
        val actual = target.execute(
            previousMonthlyPurchaseAmount = 10_001,
            previousMonthlyPurchaseCount = 10,
            campaignStartDate = campaignStartDate,
            campaignEndDate = campaignEndDate,
            pointRate = 0.01,
            purchaseAmount = 1000
        )
        Assertions.assertEquals(10, actual)
    }

    @Test
    fun `キャンペーン期間内でランクBronze会員にはポイントが付与できない`() {
        val now = LocalDate.of(2023, 10, 1)
        val campaignStartDate = LocalDate.of(2023, 10, 1)
        val campaignEndDate = LocalDate.of(2023, 11, 1)
        mockkStatic(LocalDate::class)
        every { LocalDate.now() } returns now

        val target = PointCalculate()
        val actual = target.execute(
            previousMonthlyPurchaseAmount = 10_000,
            previousMonthlyPurchaseCount = 10,
            campaignStartDate = campaignStartDate,
            campaignEndDate = campaignEndDate,
            pointRate = 0.01,
            purchaseAmount = 1000
        )
        Assertions.assertEquals(0, actual)
    }

    @Test
    fun `キャンペーン期間外ではポイントが付与できない`() {
        val now = LocalDate.of(2023, 12, 1)
        val campaignStartDate = LocalDate.of(2023, 10, 1)
        val campaignEndDate = LocalDate.of(2023, 11, 1)
        mockkStatic(LocalDate::class)
        every { LocalDate.now() } returns now

        val target = PointCalculate()
        val actual = target.execute(
            previousMonthlyPurchaseAmount = 10_001,
            previousMonthlyPurchaseCount = 10,
            campaignStartDate = campaignStartDate,
            campaignEndDate = campaignEndDate,
            pointRate = 0.01,
            purchaseAmount = 1000
        )
        Assertions.assertEquals(0, actual)
    }
}
