package org.tsurikichi.design.practice5.version4.application

import org.tsurikichi.design.practice5.version4.domain.Delivery

interface IDeliveryRepository {
    fun save(payment: Delivery)
}
