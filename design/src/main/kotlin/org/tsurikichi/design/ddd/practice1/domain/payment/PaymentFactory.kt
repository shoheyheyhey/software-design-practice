package org.tsurikichi.design.ddd.practice1.domain.payment

import org.springframework.stereotype.Service
import org.tsurikichi.design.ddd.practice1.domain.coupon.IUseCouponRepository
import org.tsurikichi.design.ddd.practice1.domain.member.IPaymentMemberRepository
import org.tsurikichi.design.ddd.practice1.domain.share.CouponCode
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCompanyCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDateTime
import org.tsurikichi.design.ddd.practice1.domain.share.Point
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode

@Service
class PaymentFactory(
    private val paymentMemberRepository: IPaymentMemberRepository,
    private val useCouponRepository: IUseCouponRepository
) {
    fun create(
        receiptNumber: ReceiptNumber,
        paymentDateTime: PaymentDateTime,
        memberCode: MemberCode,
        usePoints: Point?,
        companyCode: MemberCompanyCode,
        shopCode: ShopCode,
        couponCode: CouponCode?,
        paymentPurchases: List<PaymentPurchase>,
        paymentMethods: List<PaymentMethod>
    ): Payment {
        val paymentMemberBeforeUsePoints = paymentMemberRepository.findBy(memberCode)
        val paymentMember = if (usePoints != null) { paymentMemberBeforeUsePoints.usePoints(usePoints) } else { paymentMemberBeforeUsePoints }

        val useCoupon = couponCode?.let { useCouponRepository.findBy(it) }
        val paymentPurchaseWithCoupon = useCoupon?.let { paymentPurchases.map { it.useCoupon(useCoupon) } } ?: paymentPurchases
        return Payment(receiptNumber, paymentDateTime, paymentMember, companyCode, shopCode, useCoupon?.couponCode, paymentMethods, paymentPurchaseWithCoupon)
    }
}
