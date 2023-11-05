package org.tsurikichi.design.ddd.builder

import nu.studer.sample.Tables.PAYMENT
import org.jooq.DSLContext
import org.tsurikichi.design.ddd.mother.MotherPaymentMember
import org.tsurikichi.design.ddd.mother.MotherPaymentMethod
import org.tsurikichi.design.ddd.mother.MotherPaymentPurchase
import org.tsurikichi.design.ddd.practice1.domain.member.PaymentMember
import org.tsurikichi.design.ddd.practice1.domain.payment.Payment
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentMethod
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentPurchase
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCompanyCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDateTime
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import java.time.LocalDateTime

class BuilderPayment(
    private val receiptNumber: ReceiptNumber = ReceiptNumber("1"),
    private val paymentDateTime: PaymentDateTime = PaymentDateTime(LocalDateTime.now()),
    private val companyCode: MemberCompanyCode = MemberCompanyCode("1"),
    private val shopCode: ShopCode = ShopCode("1"),
    private val paymentMember: PaymentMember = MotherPaymentMember.default(),
    private val couponCode: CouponCode? = null,
    private val paymentMethods: List<PaymentMethod> = listOf(MotherPaymentMethod.default()),
    private val paymentPurchases: List<PaymentPurchase> = listOf(MotherPaymentPurchase.default())
) {
    fun build(): Payment = Payment(
        receiptNumber = receiptNumber,
        paymentDateTime = paymentDateTime,
        companyCode = companyCode,
        shopCode = shopCode,
        paymentMember = paymentMember,
        couponCode = couponCode,
        paymentMethod = paymentMethods,
        paymentPurchase = paymentPurchases
    )

    fun insert(dslContext: DSLContext) {
        dslContext.insertInto(PAYMENT, PAYMENT.RECEIPT_NUMBER, PAYMENT.MEMBER_CODE, PAYMENT.AFFILIATE_COMPANY_CODE, PAYMENT.STORE_CODE, PAYMENT.USED_POINT)
            .values(receiptNumber.value.toInt(), paymentMember.memberCode.value.toInt(), companyCode.value.toInt(), shopCode.value.toInt(), paymentMember.getDataModel().usePoints)
            .execute()
    }
}
