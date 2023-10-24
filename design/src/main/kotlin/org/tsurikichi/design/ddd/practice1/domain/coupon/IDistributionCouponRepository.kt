package org.tsurikichi.design.ddd.practice1.domain.coupon

import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode

interface IDistributionCouponRepository {
    fun findBy(memberCode: MemberCode): DistributionCoupon?
    fun update(distributionCoupon: DistributionCoupon)
}
