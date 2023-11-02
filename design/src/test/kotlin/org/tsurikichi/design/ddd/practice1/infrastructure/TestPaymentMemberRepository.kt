package org.tsurikichi.design.ddd.practice1.infrastructure

import nu.studer.sample.tables.Member.MEMBER
import org.jooq.DSLContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import org.tsurikichi.design.ddd.helper.DatabaseSetupHelper
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode

@SpringBootTest
@Transactional
class TestPaymentMemberRepository {
    @Autowired
    private lateinit var dslContext: DSLContext

    @Autowired
    private lateinit var target: PaymentMemberRepository

    @Autowired
    private lateinit var databaseSetupHelper: DatabaseSetupHelper

    @BeforeEach
    fun setup() {
        databaseSetupHelper.truncateAll()
        dslContext.insertInto(MEMBER, MEMBER.MEMBER_CODE, MEMBER.MEMBER_NAME, MEMBER.POINT_BALANCE)
            .values(123, "TestMember", 1000)
            .execute()
    }

    @Test
    fun `findBy should return PaymentMember when memberCode exists`() {
        val memberCode = MemberCode("123")

        val result = target.findBy(memberCode)
        assertEquals("123", result.memberCode.value)
    }

    @Test
    fun `findBy should throw IllegalArgumentException when memberCode does not exist`() {
        val memberCode = MemberCode("999") // Non-existent member code

        val exception = assertThrows<IllegalArgumentException> {
            target.findBy(memberCode)
        }
        assertEquals("会員が存在しません", exception.message)
    }
}
