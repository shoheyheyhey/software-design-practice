package org.tsurikichi.design.practice5.version3.application

import org.tsurikichi.design.practice5.version3.domain.Delivery
import org.tsurikichi.design.practice5.version3.domain.Rank
import java.time.LocalDate

class DeliveryUseCase {
    fun delivery(
        deliveryDate: LocalDate,
        purchaseAmount: Int,
        previousMonthlyTotalAmount: Int?
    ): String {
        val today = LocalDate.now()

        // 早期エラー
        if (previousMonthlyTotalAmount == null) throw IllegalArgumentException("前月の購入金額を設定してください")
        if (today.isAfter(deliveryDate)) throw IllegalArgumentException("配送日が過去の日付です")

        val rank = Rank.create(previousMonthlyTotalAmount)
        val delivery = Delivery.factory(rank.rankType)

        return "canTodayDelivery: ${delivery.canTodayDelivery()}, postage: ${delivery.getPostage(purchaseAmount)}"
    }
}
