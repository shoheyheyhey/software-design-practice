package org.tsurikichi.design.`ddd-practice1`.domain.share

data class GoodsPrice(val value: Int) {
    init {
        if (value < 0 || 1_000_000 < value) throw IllegalArgumentException("商品価格が不正です")
    }
}
