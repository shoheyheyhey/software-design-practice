package org.tsurikichi.design.ddd.practice1.application.payment

import io.mockk.every
import io.mockk.mockkClass
import io.mockk.verifySequence
import org.junit.jupiter.api.Test
import org.tsurikichi.design.ddd.mother.MotherPaymentMember
import org.tsurikichi.design.ddd.practice1.domain.coupon.IDistributionCouponRepository
import org.tsurikichi.design.ddd.practice1.domain.coupon.IUseCouponRepository
import org.tsurikichi.design.ddd.practice1.domain.member.IPaymentMemberRepository
import org.tsurikichi.design.ddd.practice1.domain.payment.IPaymentRepository
import org.tsurikichi.design.ddd.practice1.domain.share.GoodsPrice
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDate
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentMethodCode
import org.tsurikichi.design.ddd.practice1.domain.share.PurchaseQuantity
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import org.tsurikichi.design.ddd.practice1.domain.shop.MemberCompanyGoodsCode
import java.time.LocalDate

class TestPaymentCreateUseCase {
    private val memberRepository = mockkClass(IPaymentMemberRepository::class)
    private val paymentRepository = mockkClass(IPaymentRepository::class)
    private val useCouponRepository = mockkClass(IUseCouponRepository::class)
    private val distributeCouponRepository = mockkClass(IDistributionCouponRepository::class)

    private val target = PaymentCreateUseCase(paymentRepository, useCouponRepository, distributeCouponRepository, memberRepository)

    @Test
    fun `支払い登録できる`() {
        every { memberRepository.findBy(any()) } returns MotherPaymentMember.default()
        every { paymentRepository.save(any()) } returns Unit
        every { distributeCouponRepository.findBy(any()) } returns null

        target.execute(param())
        verifySequence {
            memberRepository.findBy(MemberCode("1"))
            paymentRepository.save(any())
            distributeCouponRepository.findBy(MemberCode("1"))
        }
    }

    private fun param(): PaymentCreateUseCase.Param {
        return PaymentCreateUseCase.Param(
            receiptNumber = ReceiptNumber("1"),
            paymentDate = PaymentDate(LocalDate.now()),
            paymentAmount = PaymentAmount(1_000),
            usePoints = null,
            memberCode = MemberCode("1"),
            shopCode = ShopCode("1"),
            couponCode = null,
            paymentPurchases = listOf(
                PaymentCreateUseCase.Param.PaymentPurchase(
                    memberCompanyGoodsCode = MemberCompanyGoodsCode("1"),
                    purchaseQuantity = PurchaseQuantity(1),
                    goodsPrice = GoodsPrice(1_000)
                )
            ),
            paymentMethods = listOf(
                PaymentCreateUseCase.Param.PaymentMethod(
                    paymentMethodCode = PaymentMethodCode("1"),
                    paymentMethodAmount = PaymentAmount(1_000)
                )
            )
        )
    }
}
