package org.tsurikichi.design.ddd.practice1.domain.share

data class PaymentAmount(val value: Int) {
    init {
        if (value < 0 || 1_000_000 < value) throw IllegalArgumentException("支払い金額が不正です")
    }
}
