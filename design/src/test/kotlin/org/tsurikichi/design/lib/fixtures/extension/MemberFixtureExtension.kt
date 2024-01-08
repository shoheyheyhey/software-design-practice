package org.tsurikichi.design.lib.fixtures.extension

import org.tsurikichi.design.lib.fixtures.MemberFixture
import org.tsurikichi.design.lib.objectmother.MotherPaymentMember

fun MemberFixture.default(): MemberFixture {
    return MemberFixture(
        member_code = 1,
        member_name = "てすと　たろう",
        point_balance = MotherPaymentMember.default().getDataModel().remainingPoints
    )
}
