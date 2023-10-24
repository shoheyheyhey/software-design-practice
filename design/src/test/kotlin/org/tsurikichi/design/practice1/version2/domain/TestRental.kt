package org.tsurikichi.design.practice1.version2.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TestRental {
    val rental = Rental(listOf(Movie(PriceFactory.factory(MovieType.CHILDREN)), Movie(PriceFactory.factory(MovieType.REGULAR)), Movie(PriceFactory.factory(MovieType.NEW))), 10)

    @Nested
    inner class CalculateCharge {

        @Test
        fun `レンタル料金計算結果を検証する`() {
            val result = rental.calculateCharge()

            Assertions.assertEquals(6000, result)
        }
    }

    @Nested
    inner class CalculatePoint {

        @Test
        fun `ポイント計算結果を検証する`() {
            val result = rental.calculatePoint()

            Assertions.assertEquals(35, result)
        }
    }
}
