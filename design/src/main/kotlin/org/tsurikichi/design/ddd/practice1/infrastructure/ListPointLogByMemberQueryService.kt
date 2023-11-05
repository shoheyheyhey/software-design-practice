package org.tsurikichi.design.ddd.practice1.infrastructure

import nu.studer.sample.Tables.PAYMENT
import nu.studer.sample.Tables.POINT_TRANSACTION_LOG
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.springframework.stereotype.Service
import org.tsurikichi.design.ddd.practice1.application.member.IListPointLogByMemberQueryService
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point

@Service
class ListPointLogByMemberQueryService(private val dslContext: DSLContext) : IListPointLogByMemberQueryService {

    override fun list(memberCode: MemberCode): IListPointLogByMemberQueryService.Dto {
        val resultRecords = dslContext.selectFrom(POINT_TRANSACTION_LOG)
            .where(
                POINT_TRANSACTION_LOG.RECEIPT_NUMBER.`in`(
                    dslContext.select(
                        PAYMENT.RECEIPT_NUMBER
                    )
                        .from(PAYMENT)
                        .where(PAYMENT.MEMBER_CODE.eq(memberCode.value.toInt()))
                        .fetch()
                )
            )
            .fetch()
        return convertToDto(resultRecords)
    }

    private fun convertToDto(records: Result<Record>): IListPointLogByMemberQueryService.Dto {
        val items = records.map {
            IListPointLogByMemberQueryService.Dto.Item(
                memberCode = MemberCode(it[POINT_TRANSACTION_LOG.RECEIPT_NUMBER].toString()),
                pointLogType = IListPointLogByMemberQueryService.PointLogType.valueOf(it[POINT_TRANSACTION_LOG.POINT_LOG_TYPE]),
                transferPoints = Point(it[POINT_TRANSACTION_LOG.TRANSACTION_POINTS])
            )
        }
        return IListPointLogByMemberQueryService.Dto(items)
    }
}
