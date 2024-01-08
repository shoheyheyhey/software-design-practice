package org.tsurikichi.design.lib.fixtures.extension

import org.tsurikichi.design.ddd.practice1.application.member.IListPointLogByMemberQueryService
import org.tsurikichi.design.lib.fixtures.PointTransactionLogFixture

fun PointTransactionLogFixture.default(): PointTransactionLogFixture {
    return PointTransactionLogFixture(
        receipt_number = 1,
        point_log_type = IListPointLogByMemberQueryService.PointLogType.ADD.name,
        transaction_points = 1000
    )
}
