package org.tsurikichi.design.ddd.practice1.domain.payment

import org.tsurikichi.design.ddd.practice1.domain.coupon.UseCoupon
import org.tsurikichi.design.ddd.practice1.domain.share.GoodsPrice
import org.tsurikichi.design.ddd.practice1.domain.share.Point
import org.tsurikichi.design.ddd.practice1.domain.share.PurchaseQuantity
import org.tsurikichi.design.ddd.practice1.domain.shop.MemberCompanyGoodsCode
import kotlin.math.floor

class PaymentPurchase private constructor(
    val memberCompanyGoodsCode: MemberCompanyGoodsCode,
    private val purchaseQuantity: PurchaseQuantity,
    val goodsPrice: GoodsPrice,
    private val grantPoint: Point
) {
    companion object {
        private const val PAYMENT_PURCHASE_POINT_RATE = 0.05
        fun create(
            memberCompanyGoodsCode: MemberCompanyGoodsCode,
            purchaseQuantity: PurchaseQuantity,
            goodsPrice: GoodsPrice,
            useCoupon: UseCoupon?
        ): PaymentPurchase {
            val pointRate = useCoupon?.pointRate?.value ?: PAYMENT_PURCHASE_POINT_RATE
            val grantPoint = floor(purchaseQuantity.value * goodsPrice.value * pointRate).toInt()

            return PaymentPurchase(
                memberCompanyGoodsCode,
                purchaseQuantity,
                goodsPrice,
                Point(grantPoint)
            )
        }
    }
}
