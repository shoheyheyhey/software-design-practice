package org.tsurikichi.design.test_practice1.test_practice_1_1.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.tsurikichi.design.test_practice.test_practice_1_1.domain.Size

class TestSize {
    @Test
    fun `こんなテストは必要ない`() {
        val width = 100
        val height = 100
        val depth = 100

        val size = Size(width = width, height = height, depth = depth)

        Assertions.assertEquals(width, size.width)
        Assertions.assertEquals(height, size.height)
        Assertions.assertEquals(depth, size.depth)
    }

}
