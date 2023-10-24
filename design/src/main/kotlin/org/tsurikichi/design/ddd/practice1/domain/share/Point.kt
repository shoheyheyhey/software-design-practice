package org.tsurikichi.design.ddd.practice1.domain.share

data class Point(val value: Int) {
    init {
        if (value < 0 || 1_000_000 < value) throw IllegalArgumentException("ポイント数が不正です")
    }
}
