package org.tsurikichi.design.practice1.`practice1-2`.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TestMovie {

    @Nested
    inner class CalculateCharge {

        @Test
        fun `新作動画を割引・割増が適用されない期間内でレンタルした際のレンタル料金を検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.NEW))
            val result = movie.getPrice(3)

            Assertions.assertEquals(900, result)
        }

        @Test
        fun `新作動画を割増が適用される期間レンタルした際のレンタル料金を検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.NEW))
            val result = movie.getPrice(4)

            Assertions.assertEquals(1300, result)
        }

        @Test
        fun `一般動画をレンタルした際のレンタル料金を検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.REGULAR))
            val result = movie.getPrice(1)

            Assertions.assertEquals(200, result)
        }

        @Test
        fun `子供向け動画を割引・割増が適用されない期間内でレンタルした際のレンタル料金を検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.CHILDREN))
            val result = movie.getPrice(5)

            Assertions.assertEquals(500, result)
        }

        @Test
        fun `子供向け動画を割引が適用される期間レンタルした際のレンタル料金を検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.CHILDREN))
            val result = movie.getPrice(6)

            Assertions.assertEquals(500, result)
        }
    }

    @Nested
    inner class CalculatePoint {

        @Test
        fun `新作動画をレンタルした際のポイントを検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.NEW))
            val result = movie.getPoint()

            Assertions.assertEquals(20, result)
        }

        @Test
        fun `一般動画をレンタルした際のポイントを検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.REGULAR))
            val result = movie.getPoint()

            Assertions.assertEquals(10, result)
        }

        @Test
        fun `子供向け動画をレンタルした際のポイントを検証する`() {
            val movie = Movie(PriceFactory.factory(MovieType.CHILDREN))
            val result = movie.getPoint()

            Assertions.assertEquals(5, result)
        }
    }
}
