package org.tsurikichi.design.practice1.`practice1-2`.`application-service`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.tsurikichi.design.practice1.`practice1-2`.domain.Movie
import org.tsurikichi.design.practice1.`practice1-2`.domain.MovieType
import org.tsurikichi.design.practice1.`practice1-2`.domain.PriceFactory
import org.tsurikichi.design.practice1.`practice1-2`.domain.Rental

class TestAmountAndPointCalculationService {

    @Test
    fun `全カテゴリの動画をレンタルした場合の料金とポイント算出結果を検証する`() {
        val amountAndPointCalculationService = AmountAndPointCalculationService()
        val rental = Rental(
            listOf(
                Movie(PriceFactory.factory(MovieType.CHILDREN)),
                Movie(PriceFactory.factory(MovieType.REGULAR)),
                Movie(PriceFactory.factory(MovieType.NEW))
            ),
            10
        )

        val amountAndPoint = amountAndPointCalculationService.calculateAmountAndPoint(rental)

        Assertions.assertEquals("charge: 6000, point: 35", amountAndPoint)
    }
}
