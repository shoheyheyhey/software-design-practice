package org.tsurikichi.design.practice1.practice1_3.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TestRental {
    val rental = Rental(listOf(Movie.movieFactory(Movie.Category.CHILDREN), Movie.movieFactory(Movie.Category.REGULAR), Movie.movieFactory(Movie.Category.NEW), Movie.movieFactory(Movie.Category.SEMI_NEW)), 10)


    @Nested
    inner class CalculateCharge {

        @Test
        fun `レンタル料金計算結果を検証する`() {
            val result = rental.calculateCharge()

            Assertions.assertEquals(9100, result)
        }

    }

    @Nested
    inner class CalculatePoint {

        @Test
        fun `ポイント計算結果を検証する`() {
            val result = rental.calculatePoint()

            Assertions.assertEquals(45, result)
        }


    }
}