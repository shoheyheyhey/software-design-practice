package org.tsurikichi.design.ddd.practice1.application.payment

import io.mockk.every
import io.mockk.mockkClass
import io.mockk.verifySequence
import org.junit.jupiter.api.Test
import org.tsurikichi.design.ddd.practice1.domain.coupon.IDistributionCouponRepository
import org.tsurikichi.design.ddd.practice1.domain.payment.IPaymentRepository
import org.tsurikichi.design.ddd.practice1.domain.payment.PaymentFactory
import org.tsurikichi.design.ddd.practice1.domain.payment.ReceiptNumberDuplicationCheckService
import org.tsurikichi.design.ddd.practice1.domain.share.GoodsPrice
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCode
import org.tsurikichi.design.ddd.practice1.domain.share.MemberCompanyCode
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentDateTime
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentMethodCode
import org.tsurikichi.design.ddd.practice1.domain.share.PurchaseQuantity
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber
import org.tsurikichi.design.ddd.practice1.domain.share.ShopCode
import org.tsurikichi.design.ddd.practice1.domain.shop.MemberCompanyGoodsCode
import org.tsurikichi.design.lib.objectmother.MotherPayment
import java.time.LocalDateTime

class TestPaymentCreateUseCase {
    private val paymentRepository = mockkClass(IPaymentRepository::class)
    private val distributeCouponRepository = mockkClass(IDistributionCouponRepository::class)
    private val paymentFactory = mockkClass(PaymentFactory::class)
    private val receiptNumberDuplicationCheckService = mockkClass(ReceiptNumberDuplicationCheckService::class)

    private val target = PaymentCreateUseCase(paymentRepository, distributeCouponRepository, paymentFactory, receiptNumberDuplicationCheckService)

    @Test
    fun `支払い登録できる`() {
        every { receiptNumberDuplicationCheckService.execute(any()) } returns Unit
        every { paymentFactory.create(any(), any(), any(), any(), any(), any(), any(), any(), any()) } returns MotherPayment.default()
        every { paymentRepository.save(any()) } returns Unit
        every { distributeCouponRepository.findBy(any()) } returns null

        target.execute(param())
        verifySequence {
            receiptNumberDuplicationCheckService.execute(any())
            paymentFactory.create(any(), any(), any(), any(), any(), any(), any(), any(), any())
            paymentRepository.save(any())
            distributeCouponRepository.findBy(MemberCode("1"))
        }
    }

    private fun param(): PaymentCreateUseCase.Param {
        return PaymentCreateUseCase.Param(
            receiptNumber = ReceiptNumber("1"),
            paymentDateTime = PaymentDateTime(LocalDateTime.now()),
            usePoints = null,
            memberCode = MemberCode("1"),
            companyCode = MemberCompanyCode("1"),
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
