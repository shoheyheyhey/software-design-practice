package org.tsurikichi.design.lib.objectmother

import org.tsurikichi.design.ddd.practice1.domain.coupon.UseCoupon
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.PointRate
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import java.time.LocalDate

object MotherUseCoupon {

    fun default(): UseCoupon {
        return UseCoupon.create(
            couponCode = CouponCode("1"),
            pointRate = PointRate(0.1),
            usageStartDate = LocalDate.of(2020, 1, 1),
            usageEndDate = LocalDate.of(2099, 12, 31),
            couponUsableShopCodes = emptyList(),
            couponUsableMemberCompanyGoodsCodes = emptyList(),
            paymentShopCode = ShopCode("1"),
            paymentPurchaseGoodsCodes = emptyList()
        )
    }
}
