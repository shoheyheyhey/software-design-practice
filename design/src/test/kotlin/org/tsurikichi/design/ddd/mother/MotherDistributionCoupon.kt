package org.tsurikichi.design.ddd.mother

import org.tsurikichi.design.ddd.practice1.domain.coupon.DistributionCoupon
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode

object MotherDistributionCoupon {

    fun default(): DistributionCoupon {
        return DistributionCoupon(
            couponCode = CouponCode("1"),
            memberCode = MemberCode("1"),
            isDistributed = false
        )
    }
}
