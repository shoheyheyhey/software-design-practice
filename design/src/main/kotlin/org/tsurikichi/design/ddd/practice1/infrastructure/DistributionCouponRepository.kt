package org.tsurikichi.design.ddd.practice1.infrastructure

import org.springframework.stereotype.Repository
import org.tsurikichi.design.ddd.practice1.domain.coupon.DistributionCoupon
import org.tsurikichi.design.ddd.practice1.domain.coupon.IDistributionCouponRepository
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode

@Repository
class DistributionCouponRepository : IDistributionCouponRepository {
    override fun findBy(memberCode: MemberCode): DistributionCoupon? {
        return null
    }

    override fun update(distributionCoupon: DistributionCoupon) {
        TODO("Not yet implemented")
    }
}
