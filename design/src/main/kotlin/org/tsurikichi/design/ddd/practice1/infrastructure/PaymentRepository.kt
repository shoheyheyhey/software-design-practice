package org.tsurikichi.design.ddd.practice1.infrastructure

import nu.studer.sample.Tables.MEMBER
import nu.studer.sample.Tables.PAYMENT_METHOD_DETAIL
import nu.studer.sample.Tables.PURCHASE_PRODUCT_DETAIL
import nu.studer.sample.tables.Payment.PAYMENT
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import org.tsurikichi.design.ddd.practice1.domain.payment.IPaymentRepository
import org.tsurikichi.design.ddd.practice1.domain.payment.Payment
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber

@Repository
class PaymentRepository(private val dslContext: DSLContext) : IPaymentRepository {

    @Transactional
    override fun save(payment: Payment) {
        val dataModel = payment.getDataModel()
        dslContext.insertInto(PAYMENT, PAYMENT.RECEIPT_NUMBER, PAYMENT.MEMBER_CODE, PAYMENT.AFFILIATE_COMPANY_CODE, PAYMENT.STORE_CODE, PAYMENT.USED_POINT)
            .values(dataModel.receiptNumber, dataModel.paymentMember.memberCode, dataModel.companyCode, dataModel.shopCode, dataModel.paymentMember.usePoints)

        dataModel.paymentMethod.forEach {
            dslContext.insertInto(PAYMENT_METHOD_DETAIL, PAYMENT_METHOD_DETAIL.RECEIPT_NUMBER, PAYMENT_METHOD_DETAIL.PAYMENT_METHOD_CODE, PAYMENT_METHOD_DETAIL.PAYMENT_AMOUNT, PAYMENT_METHOD_DETAIL.GIVEN_POINT)
                .values(dataModel.receiptNumber, it.paymentMethodCode, it.paymentMethodAmount, it.grantPoint)
        }

        dataModel.paymentPurchase.forEach {
            dslContext.insertInto(PURCHASE_PRODUCT_DETAIL, PURCHASE_PRODUCT_DETAIL.RECEIPT_NUMBER, PURCHASE_PRODUCT_DETAIL.AFFILIATE_COMPANY_CODE, PURCHASE_PRODUCT_DETAIL.PURCHASE_COUNT, PURCHASE_PRODUCT_DETAIL.PRODUCT_UNIT_PRICE, PURCHASE_PRODUCT_DETAIL.GIVEN_POINT)
                .values(dataModel.receiptNumber, dataModel.companyCode, it.purchaseQuantity, it.goodsPrice, it.grantPoint)
        }

        dslContext.update(MEMBER).set(MEMBER.POINT_BALANCE, dataModel.paymentMember.remainingPoints).where(MEMBER.MEMBER_CODE.eq(dataModel.paymentMember.memberCode))
    }

    override fun findBy(receiptNumber: ReceiptNumber): Payment? {
        dslContext.selectFrom(PAYMENT).where(PAYMENT.RECEIPT_NUMBER.eq(receiptNumber.value.toInt()))
        // TODO: implement
        return null
    }
}
