package org.tsurikichi.design.ddd.practice1.infrastructure

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.lib.fixtures.MemberFixture
import org.tsurikichi.design.lib.fixtures.extension.default
import org.tsurikichi.design.lib.fixtures.insert
import org.tsurikichi.design.lib.helper.deleteAllTables
import org.tsurikichi.design.lib.objectmother.MotherPaymentMember

@SpringBootTest
@Transactional
class TestPaymentMemberRepository : DatabaseTestBase() {

    @Autowired
    private lateinit var target: PaymentMemberRepository

    @BeforeEach
    fun setup() {
        db {
            deleteAllTables()
            insert(MemberFixture().default())
        }
    }

    @Test
    fun `findBy should return PaymentMember when memberCode exists`() {
        val memberCode = MotherPaymentMember.default().memberCode

        val result = target.findBy(memberCode)
        assertEquals(memberCode, result.memberCode)
    }

    @Test
    fun `findBy should throw IllegalArgumentException when memberCode does not exist`() {
        val memberCode = MemberCode("999")

        val exception = assertThrows<IllegalArgumentException> {
            target.findBy(memberCode)
        }
        assertEquals("会員が存在しません", exception.message)
    }
}
