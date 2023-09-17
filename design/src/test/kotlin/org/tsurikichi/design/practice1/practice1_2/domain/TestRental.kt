package org.tsurikichi.design.practice1.practice1_2.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TestRental {
    val rental = Rental(listOf(Movie.movieFactory(Movie.Category.CHILDREN), Movie.movieFactory(Movie.Category.REGULAR), Movie.movieFactory(Movie.Category.NEW)), 10)


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