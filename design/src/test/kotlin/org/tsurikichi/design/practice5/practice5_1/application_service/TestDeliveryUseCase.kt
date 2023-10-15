package org.tsurikichi.design.practice5.practice5_1.application_service

import io.mockk.every
import io.mockk.mockkStatic
import io.mockk.unmockkStatic
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.LocalDate

class TestDeliveryUseCase {

    @AfterEach
    fun afterEach() {
        unmockkStatic(LocalDate::class)
    }

    @Nested
    inner class Delivery {

        @Test
        fun `ゴールド会員は当日配送可能で送料が無料である`() {
            val now = LocalDate.of(2023, 10, 1)
            val deliveryDate = LocalDate.of(2023, 10, 1)
            mockkStatic(LocalDate::class)
            every { LocalDate.now() } returns now

            val target = DeliveryUseCase()

            val actual = target.delivery(
                deliveryDate = deliveryDate,
                purchaseAmount = 100,
                previousMonthlyTotalAmount = 10_000
            )

            Assertions.assertEquals("canTodayDelivery: true, postage: 0", actual)
        }


    }
}
