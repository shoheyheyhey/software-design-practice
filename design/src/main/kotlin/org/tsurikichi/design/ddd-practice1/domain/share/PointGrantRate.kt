package org.tsurikichi.design.`ddd-practice1`.domain.share

data class PointGrantRate(val value: Double) {
    init {
        if (value < 0 || 1 < value) throw IllegalArgumentException("ポイント付与率が不正です")
    }
}
