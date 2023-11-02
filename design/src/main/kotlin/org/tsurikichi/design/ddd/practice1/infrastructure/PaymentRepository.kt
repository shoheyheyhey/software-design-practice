package org.tsurikichi.design.ddd.practice1.infrastructure

import org.springframework.stereotype.Repository
import org.tsurikichi.design.ddd.practice1.domain.payment.IPaymentRepository
import org.tsurikichi.design.ddd.practice1.domain.payment.Payment
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber

@Repository
class PaymentRepository : IPaymentRepository {
    override fun save(payment: Payment) {
    }

    override fun findBy(receiptNumber: ReceiptNumber): Payment? {
        return null
    }
}
