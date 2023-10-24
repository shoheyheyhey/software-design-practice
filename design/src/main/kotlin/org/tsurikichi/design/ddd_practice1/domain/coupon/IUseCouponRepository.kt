package org.tsurikichi.design.ddd_practice1.domain.coupon

import org.tsurikichi.design.ddd_practice1.domain.share.CouponCode

interface IUseCouponRepository {
    fun findBy(couponCode: CouponCode): UseCoupon
}
