package org.tsurikichi.design.practice3.practice3_2.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class TestRank {

    @Nested
    inner class RankCreate {

        @Test
        fun `Goldランクの会員を生成できる`() {
            val rank = Rank.create(11_000, 0)

            Assertions.assertEquals(RankType.GOLD, rank.rankType)
        }

        @Test
        fun `Silverランクの会員を生成できる`() {
            val rank = Rank.create(6_000, 11)

            Assertions.assertEquals(RankType.SILVER, rank.rankType)
        }

        @Test
        fun `Bronzeランクの会員を生成できる`() {
            val rank = Rank.create(4_000, 0)

            Assertions.assertEquals(RankType.BRONZE, rank.rankType)
        }

    }

}
