package org.tsurikichi.design.lib.fixtures.extension

import org.tsurikichi.design.lib.fixtures.MemberFixture
import org.tsurikichi.design.lib.objectmother.MotherPaymentMember

fun MemberFixture.default(): MemberFixture {
    val motherPaymentMember = MotherPaymentMember.default()

    return MemberFixture(
        member_code = motherPaymentMember.memberCode.value.toInt(),
        member_name = "てすと　たろう",
        point_balance = motherPaymentMember.getDataModel().remainingPoints
    )
}
