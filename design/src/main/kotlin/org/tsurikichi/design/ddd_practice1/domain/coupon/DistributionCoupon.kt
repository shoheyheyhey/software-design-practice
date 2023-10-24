package org.tsurikichi.design.ddd_practice1.domain.coupon

import org.tsurikichi.design.ddd_practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd_practice1.domain.share.MemberCode

class DistributionCoupon(val couponCode: CouponCode, private val memberCode: MemberCode, private val isDistributed: Boolean){
    fun distribute(){
        DistributionCoupon(couponCode, memberCode, true)
    }
}
