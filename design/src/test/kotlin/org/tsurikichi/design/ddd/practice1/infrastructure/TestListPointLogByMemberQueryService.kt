package org.tsurikichi.design.ddd.practice1.infrastructure

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import org.tsurikichi.design.ddd.practice1.application.member.IListPointLogByMemberQueryService
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.lib.fixtures.MemberFixture
import org.tsurikichi.design.lib.fixtures.PaymentFixture
import org.tsurikichi.design.lib.fixtures.PointTransactionLogFixture
import org.tsurikichi.design.lib.fixtures.extension.default
import org.tsurikichi.design.lib.fixtures.insert
import org.tsurikichi.design.lib.helper.deleteAllTables

@SpringBootTest
@Transactional
class TestListPointLogByMemberQueryService : DatabaseTestBase() {
    @Autowired
    private lateinit var target: ListPointLogByMemberQueryService

    @BeforeEach
    fun setup() {
        db {
            deleteAllTables()
            insert(MemberFixture().default())
            insert(PaymentFixture().default())
            insert(PaymentFixture().default().copy(receipt_number = 2))
            insert(PointTransactionLogFixture().default())
            insert(PointTransactionLogFixture().default().copy(receipt_number = 2))
            insert(PointTransactionLogFixture().default().copy(receipt_number = 2, point_log_type = IListPointLogByMemberQueryService.PointLogType.USE.name))
        }
    }

    @Test
    fun `ポイント付与利用履歴リストが取得できる`() {
        val memberCode = MemberCode("1")

        val result = target.list(memberCode)
        assertEquals(3, result.items.size)
    }
}
