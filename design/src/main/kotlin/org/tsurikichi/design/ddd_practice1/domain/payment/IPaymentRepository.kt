package org.tsurikichi.design.ddd_practice1.domain.payment

interface IPaymentRepository {
    fun save(payment: Payment)
}
