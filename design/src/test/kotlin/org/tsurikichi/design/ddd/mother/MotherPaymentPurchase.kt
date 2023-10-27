package org.tsurikichi.design.ddd.mother

import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentPurchase
import org.tsurikichi.design.ddd.practice1.domain.share.GoodsPrice
import org.tsurikichi.design.ddd.practice1.domain.share.PurchaseQuantity
import org.tsurikichi.design.ddd.practice1.domain.shop.MemberCompanyGoodsCode

object MotherPaymentPurchase {

    fun default(): PaymentPurchase {
        return PaymentPurchase.create(
            memberCompanyGoodsCode = MemberCompanyGoodsCode("1"),
            purchaseQuantity = PurchaseQuantity(1),
            goodsPrice = GoodsPrice(1_000),
            useCoupon = null

        )
    }
}
