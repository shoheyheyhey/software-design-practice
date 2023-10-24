package org.tsurikichi.design.`ddd-practice1`.`application-service`.payment

import org.springframework.stereotype.Service
import org.tsurikichi.design.`ddd-practice1`.domain.coupon.IDistributionCouponRepository
import org.tsurikichi.design.`ddd-practice1`.domain.coupon.IUseCouponRepository
import org.tsurikichi.design.`ddd-practice1`.domain.member.IPaymentMemberRepository
import org.tsurikichi.design.`ddd-practice1`.domain.payment.IPaymentRepository
import org.tsurikichi.design.`ddd-practice1`.domain.payment.Payment
import org.tsurikichi.design.`ddd-practice1`.domain.payment.PaymentMethod
import org.tsurikichi.design.`ddd-practice1`.domain.payment.PaymentPurchase
import org.tsurikichi.design.`ddd-practice1`.domain.share.CouponCode
import org.tsurikichi.design.`ddd-practice1`.domain.share.GoodsPrice
import org.tsurikichi.design.`ddd-practice1`.domain.share.MemberCode
import org.tsurikichi.design.`ddd-practice1`.domain.share.PaymentAmount
import org.tsurikichi.design.`ddd-practice1`.domain.share.PaymentDate
import org.tsurikichi.design.`ddd-practice1`.domain.share.PaymentMethodCode
import org.tsurikichi.design.`ddd-practice1`.domain.share.Point
import org.tsurikichi.design.`ddd-practice1`.domain.share.PurchaseQuantity
import org.tsurikichi.design.`ddd-practice1`.domain.share.ReceiptNumber
import org.tsurikichi.design.`ddd-practice1`.domain.share.ShopCode
import org.tsurikichi.design.`ddd-practice1`.domain.shop.MemberCompanyGoodsCode

@Service
class PaymentCreateUseCase(
    private val paymentRepository: IPaymentRepository,
    private val useCouponRepository: IUseCouponRepository,
    private val distributeCouponRepository: IDistributionCouponRepository,
    private val memberRepository: IPaymentMemberRepository
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
        val member = memberRepository.findBy(param.memberCode)
        val useCoupon = param.couponCode?.let { useCouponRepository.findBy(it) }
        val paymentPurchases = param.paymentPurchases.map { PaymentPurchase.create(it.memberCompanyGoodsCode, it.purchaseQuantity, it.goodsPrice, useCoupon) }
        val paymentMethods = param.paymentMethods.map { PaymentMethod.create(it.paymentMethodCode, it.paymentMethodAmount) }
        val payment = Payment(param.receiptNumber, param.paymentDate, param.paymentAmount, param.usePoints, member.memberCode, param.shopCode, useCoupon?.couponCode, paymentMethods, paymentPurchases)

        paymentRepository.save(payment)

        val distributionCoupon = distributeCouponRepository.findBy(param.memberCode)
        distributionCoupon?.let { distributeCouponRepository.update(it) }
    }
}
