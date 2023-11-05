package org.tsurikichi.design.ddd.practice1.infrastructure

import org.jooq.DSLContext
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import org.tsurikichi.design.ddd.builder.BuilderPayment
import org.tsurikichi.design.ddd.builder.BuilderPaymentMember
import org.tsurikichi.design.ddd.builder.BuilderPointTransactionLog
import org.tsurikichi.design.ddd.helper.DatabaseSetupHelper
import org.tsurikichi.design.ddd.practice1.application.member.IListPointLogByMemberQueryService
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber

@SpringBootTest
@Transactional
class TestListPointLogByMemberQueryService {
    @Autowired
    private lateinit var dslContext: DSLContext

    @Autowired
    private lateinit var target: ListPointLogByMemberQueryService

    @Autowired
    private lateinit var databaseSetupHelper: DatabaseSetupHelper

    @BeforeEach
    fun setup() {
        databaseSetupHelper.truncateAll()
        BuilderPaymentMember().insert(dslContext)
        BuilderPayment(receiptNumber = ReceiptNumber("1")).insert(dslContext)
        BuilderPayment(receiptNumber = ReceiptNumber("2")).insert(dslContext)
        BuilderPointTransactionLog(receiptNumber = ReceiptNumber("1")).insert(dslContext)
        BuilderPointTransactionLog(receiptNumber = ReceiptNumber("2")).insert(dslContext)
        BuilderPointTransactionLog(receiptNumber = ReceiptNumber("2"), pointLogType = IListPointLogByMemberQueryService.PointLogType.USE).insert(dslContext)
    }

    @Test
    fun `ポイント付与利用履歴リストが取得できる`() {
        val memberCode = MemberCode("1")

        val result = target.list(memberCode)
        assertEquals(3, result.items.size)
    }
}
