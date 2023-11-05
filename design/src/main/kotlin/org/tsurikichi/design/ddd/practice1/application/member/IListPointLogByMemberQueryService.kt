package org.tsurikichi.design.ddd.practice1.application.member

import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point

interface IListPointLogByMemberQueryService {

    data class Dto(
        val items: List<Item>
    ) {
        data class Item(
            val memberCode: MemberCode,
            val pointLogType: PointLogType,
            val transferPoints: Point
        )
    }

    enum class PointLogType {
        USE, ADD
    }

    fun list(memberCode: MemberCode): Dto
}
