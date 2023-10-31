package org.tsurikichi.design.ddd.practice1.domain.payment

import org.springframework.stereotype.Service
import org.tsurikichi.design.ddd.practice1.domain.share.ReceiptNumber

@Service
class ReceiptNumberDuplicationCheckService(
    private val paymentRepository: IPaymentRepository
) {
    fun execute(
        receiptNumber: ReceiptNumber
    ) {
        paymentRepository.findBy(receiptNumber)?.let { throw RuntimeException("Duplicate receipt number") }
    }
}
