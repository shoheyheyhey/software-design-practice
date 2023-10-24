package org.tsurikichi.design.`ddd-practice1`.domain.payment

interface IPaymentRepository {
    fun save(payment: Payment)
}
