package org.tsurikichi.design.`ddd-practice1`.domain.coupon

import org.tsurikichi.design.`ddd-practice1`.domain.share.CouponCode
import org.tsurikichi.design.`ddd-practice1`.domain.share.PointGrantRate
import org.tsurikichi.design.`ddd-practice1`.domain.share.ShopCode
import org.tsurikichi.design.`ddd-practice1`.domain.shop.MemberCompanyGoodsCode
import java.time.LocalDate

class UseCoupon private constructor(
    val couponCode: CouponCode,
    val pointGrantRate: PointGrantRate
) {
    companion object {
        fun create(
            couponCode: CouponCode,
            pointGrantRate: PointGrantRate,
            usageStartDate: LocalDate,
            usageEndDate: LocalDate,
            couponUsableShopCodes: List<ShopCode>,
            couponUsableMemberCompanyGoodsCodes: List<MemberCompanyGoodsCode>,
            paymentShopCode: ShopCode,
            paymentPurchaseGoodsCodes: List<MemberCompanyGoodsCode>
        ): UseCoupon {
            val today = LocalDate.now()

            if ((usageStartDate.isAfter(today) || usageStartDate == today) && today.isBefore(usageEndDate) || usageEndDate == today) throw IllegalArgumentException("クーポンの利用期間外です")
            if (couponUsableShopCodes.isNotEmpty() && !couponUsableShopCodes.contains(paymentShopCode)) throw IllegalArgumentException("クーポンの利用対象外の店舗です")
            if (couponUsableMemberCompanyGoodsCodes.isNotEmpty() && !couponUsableMemberCompanyGoodsCodes.any { it in paymentPurchaseGoodsCodes }) throw IllegalArgumentException("クーポンの利用対象外の商品です")

            return UseCoupon(couponCode, pointGrantRate)
        }
    }
}
