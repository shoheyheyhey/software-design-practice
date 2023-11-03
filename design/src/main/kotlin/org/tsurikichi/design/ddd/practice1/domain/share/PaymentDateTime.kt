package org.tsurikichi.design.ddd.practice1.domain.share

import java.time.LocalDateTime

data class PaymentDateTime(val value: LocalDateTime) {
    init {
        val today = LocalDateTime.now()
        if (value.isAfter(today) || value.isBefore(today.minusMonths(1))) throw IllegalArgumentException("支払日が不正です(当日〜過去1ヶ月以内である必要があります)")
    }
}
