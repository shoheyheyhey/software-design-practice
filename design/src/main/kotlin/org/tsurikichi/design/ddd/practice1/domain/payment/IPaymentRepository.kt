package org.tsurikichi.design.ddd.practice1.domain.payment

import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber

interface IPaymentRepository {
    fun save(payment: Payment)
    fun findBy(receiptNumber: ReceiptNumber): Payment?
}
