package org.tsurikichi.design.practice5.version2.application

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

        // 早期リターン
        if (previousMonthlyTotalAmount >= 10_000) return "canTodayDelivery: ${true}, postage: ${0}"
        if (previousMonthlyTotalAmount >= 1_000) return "canTodayDelivery: ${false}, postage: ${if (purchaseAmount >= 3_000) 0 else 50}"
        return "canTodayDelivery: ${false}, postage: ${if (purchaseAmount >= 3_000) 0 else 100}"
    }
}
