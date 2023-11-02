package org.tsurikichi.design.ddd.practice1.infrastructure

import org.springframework.stereotype.Repository
import org.tsurikichi.design.ddd.practice1.domain.coupon.IUseCouponRepository
import org.tsurikichi.design.ddd.practice1.domain.coupon.UseCoupon
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.PointRate
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import java.time.LocalDate

@Repository
class UseCouponRepository : IUseCouponRepository {
    override fun findBy(couponCode: CouponCode): UseCoupon {
        return UseCoupon.create(CouponCode("1"), PointRate(0.1), LocalDate.now(), LocalDate.now(), listOf(), listOf(), ShopCode("1"), listOf())
    }
}
