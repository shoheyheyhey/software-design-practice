package org.tsurikichi.design.practice5.practice5_1.application_service

import java.time.LocalDate


class DeliveryUseCase {
    fun delivery(
        deliveryDate: LocalDate,
        purchaseAmount: Int,
        previousMonthlyTotalAmount: Int?
    ): String {

        val today = LocalDate.now()
        var canTodayDelivery: Boolean
        var postage: Int

        if (previousMonthlyTotalAmount != null) {
            if (previousMonthlyTotalAmount >= 10_000) {
                if (!today.isAfter(deliveryDate)) {
                    canTodayDelivery = true
                    postage = 0
                } else {
                    throw IllegalArgumentException("配送日が過去の日付です")
                }

            } else if (previousMonthlyTotalAmount >= 1_000) {
                if (!today.isAfter(deliveryDate)) {
                    canTodayDelivery = false
                    if (purchaseAmount >= 3_000) {
                        postage = 0
                    }else {
                        postage = 50
                    }
                } else {
                    throw IllegalArgumentException("配送日が過去の日付です")
                }
            } else {
                if (!today.isAfter(deliveryDate)) {
                    canTodayDelivery = false
                    if (purchaseAmount >= 3_000) {
                        postage = 0
                    }else {
                        postage = 100
                    }
                } else {
                    throw IllegalArgumentException("配送日が過去の日付です")
                }
            }
        } else {
            throw IllegalArgumentException("前月の購入金額を設定してください")
        }

        return "canTodayDelivery: $canTodayDelivery, postage: $postage"
    }

}
