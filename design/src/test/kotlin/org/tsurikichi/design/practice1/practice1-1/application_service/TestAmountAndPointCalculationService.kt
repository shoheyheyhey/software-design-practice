package org.tsurikichi.design.practice1.`practice1-1`.application_service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.tsurikichi.design.practice1.`practice1-1`.domain.Movie
import org.tsurikichi.design.practice1.`practice1-1`.domain.Rental

class TestAmountAndPointCalculationService {

    @Test
    fun `全カテゴリの動画をレンタルした場合の料金とポイント算出結果を検証する`() {
        val amountAndPointCalculationService = AmountAndPointCalculationService()
        val rental = Rental(listOf(Movie(Movie.Category.CHILDREN), Movie(Movie.Category.REGULAR), Movie(Movie.Category.NEW)), 10)

        val amountAndPoint = amountAndPointCalculationService.calculateAmountAndPoint(rental)

        Assertions.assertEquals("amount: 6000, point: 35", amountAndPoint)
    }
}
