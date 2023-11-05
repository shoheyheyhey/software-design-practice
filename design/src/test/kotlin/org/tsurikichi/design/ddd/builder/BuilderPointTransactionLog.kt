package org.tsurikichi.design.ddd.builder

import nu.studer.sample.Tables.POINT_TRANSACTION_LOG
import org.jooq.DSLContext
import org.tsurikichi.design.ddd.practice1.application.member.IListPointLogByMemberQueryService
import org.tsurikichi.design.ddd.practice1.domain.share.Point
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber

class BuilderPointTransactionLog(
    private val receiptNumber: ReceiptNumber = ReceiptNumber("1"),
    private val pointLogType: IListPointLogByMemberQueryService.PointLogType = IListPointLogByMemberQueryService.PointLogType.ADD,
    private val transactionPoints: Point = Point(1_000)
) {

    fun insert(dslContext: DSLContext) {
        dslContext.insertInto(POINT_TRANSACTION_LOG, POINT_TRANSACTION_LOG.RECEIPT_NUMBER, POINT_TRANSACTION_LOG.POINT_LOG_TYPE, POINT_TRANSACTION_LOG.TRANSACTION_POINTS)
            .values(receiptNumber.value.toInt(), pointLogType.name, transactionPoints.value)
            .execute()
    }
}
