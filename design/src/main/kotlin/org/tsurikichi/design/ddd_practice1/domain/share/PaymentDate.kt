package org.tsurikichi.design.ddd_practice1.domain.share

import java.time.LocalDate

data class PaymentDate(val value: LocalDate) {
    init {
        val today = LocalDate.now()
        if (value.isAfter(today) || value.isBefore(today.minusMonths(1))) throw IllegalArgumentException("支払日が不正です(当日〜過去1ヶ月以内である必要があります)")
    }
}
