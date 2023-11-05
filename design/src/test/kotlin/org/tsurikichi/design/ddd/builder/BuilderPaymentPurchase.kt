package org.tsurikichi.design.ddd.builder

import nu.studer.sample.Tables.PURCHASE_PRODUCT_DETAIL
import org.jooq.DSLContext
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentPurchase
import org.tsurikichi.design.ddd.practice1.domain.share.GoodsPrice
import org.tsurikichi.design.ddd.practice1.domain.share.PurchaseQuantity
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.shop.MemberCompanyGoodsCode

class BuilderPaymentPurchase(
    private val receiptNumber: ReceiptNumber = ReceiptNumber("1"),
    private val memberCompanyGoodsCode: MemberCompanyGoodsCode = MemberCompanyGoodsCode("1"),
    private val purchaseQuantity: PurchaseQuantity = PurchaseQuantity(1),
    private val goodsPrice: GoodsPrice = GoodsPrice(1_000),
    private val grantPoint: Int = 50
) {
    fun build(): PaymentPurchase = PaymentPurchase.create(
        memberCompanyGoodsCode = memberCompanyGoodsCode,
        purchaseQuantity = purchaseQuantity,
        goodsPrice = goodsPrice
    )

    fun insert(dslContext: DSLContext) {
        dslContext.insertInto(PURCHASE_PRODUCT_DETAIL, PURCHASE_PRODUCT_DETAIL.RECEIPT_NUMBER, PURCHASE_PRODUCT_DETAIL.AFFILIATE_COMPANY_CODE, PURCHASE_PRODUCT_DETAIL.PURCHASE_COUNT, PURCHASE_PRODUCT_DETAIL.PRODUCT_UNIT_PRICE, PURCHASE_PRODUCT_DETAIL.GIVEN_POINT)
            .values(receiptNumber.value.toInt(), memberCompanyGoodsCode.value.toInt(), purchaseQuantity.value, goodsPrice.value, grantPoint)
            .execute()
    }
}
