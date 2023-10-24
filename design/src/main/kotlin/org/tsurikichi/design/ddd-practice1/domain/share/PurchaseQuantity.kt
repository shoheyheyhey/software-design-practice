package org.tsurikichi.design.`ddd-practice1`.domain.share

data class PurchaseQuantity(val value: Int) {
    init {
        if (value < 0 || 100 < value) throw IllegalArgumentException("購入数が不正です")
    }
}
