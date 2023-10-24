package org.tsurikichi.design.practice5.version3.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TestNormalRankDelivery {

    @Nested
    inner class GetPostage {

        @Test
        fun `購入金額が3000円未満のため送料は100円`() {
            val normalRankDelivery = NormalRankDelivery()

            val actual = normalRankDelivery.getPostage(2999)

            Assertions.assertEquals(100, actual)
        }

        @Test
        fun `購入金額が3000円以上のため送料は無料`() {
            val normalRankDelivery = NormalRankDelivery()

            val actual = normalRankDelivery.getPostage(3000)

            Assertions.assertEquals(0, actual)
        }
    }
}
