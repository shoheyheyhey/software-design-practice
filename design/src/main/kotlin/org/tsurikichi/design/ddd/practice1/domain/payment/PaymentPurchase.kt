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
            goodsPrice: GoodsPrice
        ): PaymentPurchase {
            val grantPoint = floor(purchaseQuantity.value * goodsPrice.value * PAYMENT_PURCHASE_POINT_RATE).toInt()

            return PaymentPurchase(
                memberCompanyGoodsCode,
                purchaseQuantity,
                goodsPrice,
                Point(grantPoint)
            )
        }

        fun createFromDb(
            memberCompanyGoodsCode: MemberCompanyGoodsCode,
            purchaseQuantity: PurchaseQuantity,
            goodsPrice: GoodsPrice,
            grantPoint: Point
        ): PaymentPurchase {
            return PaymentPurchase(
                memberCompanyGoodsCode,
                purchaseQuantity,
                goodsPrice,
                grantPoint
            )
        }
    }

    fun useCoupon(useCoupon: UseCoupon): PaymentPurchase {
        val grantPoint = floor(purchaseQuantity.value * goodsPrice.value * useCoupon.pointRate.value).toInt()

        return PaymentPurchase(
            memberCompanyGoodsCode,
            purchaseQuantity,
            goodsPrice,
            Point(grantPoint)
        )
    }

    fun getDataModel(): PaymentPurchaseDataModel {
        return PaymentPurchaseDataModel(
            memberCompanyGoodsCode.value.toInt(),
            purchaseQuantity.value,
            goodsPrice.value,
            grantPoint.value
        )
    }

    data class PaymentPurchaseDataModel(
        val memberCompanyGoodsCode: Int,
        val purchaseQuantity: Int,
        val goodsPrice: Int,
        val grantPoint: Int
    )
}
