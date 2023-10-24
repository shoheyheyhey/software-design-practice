package org.tsurikichi.design.ddd.practice1.presentation.payment

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
import org.tsurikichi.design.ddd.practice1.application.payment.PaymentCreateUseCase

@RestController
@RequestMapping("/payments")
class PaymentController(private val paymentCreateUseCase: PaymentCreateUseCase) {

    @PostMapping
    fun create(@RequestBody request: PaymentCreateRequest) {
        paymentCreateUseCase.execute(
            param = PaymentCreateUseCase.Param(
                ReceiptNumber(request.receiptNumber),
                PaymentDate(request.paymentDate),
                PaymentAmount(request.paymentAmount),
                request.usePoints?.let { Point(request.usePoints) },
                MemberCode(request.memberCode),
                ShopCode(request.shopCode),
                request.couponCode?.let { CouponCode(request.couponCode) },
                request.paymentPurchases.map {
                    PaymentCreateUseCase.Param.PaymentPurchase(
                        MemberCompanyGoodsCode(it.memberCompanyGoodsCode),
                        PurchaseQuantity(it.quantity),
                        GoodsPrice(it.price)
                    )
                },
                request.paymentMethods.map {
                    PaymentCreateUseCase.Param.PaymentMethod(
                        PaymentMethodCode(it.paymentMethodCode),
                        PaymentAmount(it.paymentMethodAmount)
                    )
                }
            )
        )
    }
}
