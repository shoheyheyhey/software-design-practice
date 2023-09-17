package org.tsurikichi.design.practice1.practice1_3.application_service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.tsurikichi.design.practice1.practice1_3.domain.Movie
import org.tsurikichi.design.practice1.practice1_3.domain.Rental

class TestAmountAndPointCalculationService {

    @Test
    fun `全カテゴリの動画をレンタルした場合の料金とポイント算出結果を検証する`() {
        val amountAndPointCalculationService = AmountAndPointCalculationService()
        val rental = Rental(listOf(
                Movie.movieFactory(Movie.Category.CHILDREN),
                Movie.movieFactory(Movie.Category.REGULAR),
                Movie.movieFactory(Movie.Category.NEW),
                Movie.movieFactory(Movie.Category.SEMI_NEW)), 10)

        val amountAndPoint = amountAndPointCalculationService.calculateAmountAndPoint(rental)

        Assertions.assertEquals("charge: 9100, point: 45", amountAndPoint)
    }
}