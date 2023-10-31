package org.tsurikichi.design.ddd.practice1.application.payment

import org.springframework.stereotype.Service
import org.tsurikichi.design.ddd.practice1.domain.coupon.IDistributionCouponRepository
import org.tsurikichi.design.ddd.practice1.domain.payment.IPaymentRepository
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentFactory
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentMethod
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentPurchase
import org.tsurikichi.design.ddd.practice1.domain.payment.ReceiptNumberDuplicationCheckService
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.GoodsPrice
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDate
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentMethodCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point
import org.tsurikichi.design.ddd.practice1.domain.share.PurchaseQuantity
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import org.tsurikichi.design.ddd.practice1.domain.shop.MemberCompanyGoodsCode

@Service
class PaymentCreateUseCase(
    private val paymentRepository: IPaymentRepository,
    private val distributeCouponRepository: IDistributionCouponRepository,
    private val paymentFactory: PaymentFactory,
    private val receiptNumberDuplicationCheckService: ReceiptNumberDuplicationCheckService
) {
    data class Param(
        val receiptNumber: ReceiptNumber,
        val paymentDate: PaymentDate,
        val paymentAmount: PaymentAmount,
        val usePoints: Point?,
        val memberCode: MemberCode,
        val shopCode: ShopCode,
        val couponCode: CouponCode?,
        val paymentPurchases: List<PaymentPurchase>,
        val paymentMethods: List<PaymentMethod>
    ) {
        data class PaymentPurchase(
            val memberCompanyGoodsCode: MemberCompanyGoodsCode,
            val purchaseQuantity: PurchaseQuantity,
            val goodsPrice: GoodsPrice
        )
        data class PaymentMethod(
            val paymentMethodCode: PaymentMethodCode,
            val paymentMethodAmount: PaymentAmount
        )
    }

    fun execute(param: Param) {
        receiptNumberDuplicationCheckService.execute(param.receiptNumber)

        val paymentPurchases = param.paymentPurchases.map { PaymentPurchase.create(it.memberCompanyGoodsCode, it.purchaseQuantity, it.goodsPrice) }
        val paymentMethods = param.paymentMethods.map { PaymentMethod.create(it.paymentMethodCode, it.paymentMethodAmount) }
        val payment = paymentFactory.create(
            param.receiptNumber,
            param.paymentDate,
            param.paymentAmount,
            param.memberCode,
            param.usePoints,
            param.shopCode,
            param.couponCode,
            paymentPurchases,
            paymentMethods
        )

        paymentRepository.save(payment)

        val distributionCoupon = distributeCouponRepository.findBy(param.memberCode)
        distributionCoupon?.let { distributeCouponRepository.update(it) }
    }
}
