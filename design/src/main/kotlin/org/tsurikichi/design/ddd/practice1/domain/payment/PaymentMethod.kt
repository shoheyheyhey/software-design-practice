package org.tsurikichi.design.ddd.practice1.domain.payment

import org.tsurikichi.design.ddd.practice1.domain.share.PaymentAmount
import org.tsurikichi.design.ddd.practice1.domain.share.PaymentMethodCode
import org.tsurikichi.design.ddd.practice1.domain.share.Point
import kotlin.math.floor

class PaymentMethod private constructor(
    val paymentMethodCode: PaymentMethodCode,
    val paymentAmount: PaymentAmount,
    private val grantPoint: Point
) {
    companion object {
        private const val PAYMENT_METHOD_POINT_RATE = 0.05
        fun create(
            paymentMethodCode: PaymentMethodCode,
            paymentAmount: PaymentAmount
        ): PaymentMethod {
            val grantPoint = floor(paymentAmount.value * PAYMENT_METHOD_POINT_RATE).toInt()

            return PaymentMethod(
                paymentMethodCode,
                paymentAmount,
                Point(grantPoint)
            )
        }

        fun createFromDb(
            paymentMethodCode: PaymentMethodCode,
            paymentAmount: PaymentAmount,
            grantPoint: Point
        ): PaymentMethod {
            return PaymentMethod(
                paymentMethodCode,
                paymentAmount,
                grantPoint
            )
        }
    }

    fun getDataModel(): PaymentMethodDataModel {
        return PaymentMethodDataModel(
            paymentMethodCode.value.toInt(),
            paymentAmount.value,
            grantPoint.value
        )
    }

    data class PaymentMethodDataModel(
        val paymentMethodCode: Int,
        val paymentMethodAmount: Int,
        val grantPoint: Int
    )
}
