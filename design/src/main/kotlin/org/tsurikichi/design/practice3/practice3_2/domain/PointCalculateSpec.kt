package org.tsurikichi.design.practice3.practice3_2.domain

import kotlin.math.floor

class PointCalculateSpec {
    fun execute(rate: Double, purchaseAmount: Int): Int {
        return floor(rate * purchaseAmount).toInt()

    }

}
