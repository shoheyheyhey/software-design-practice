package org.tsurikichi.design.practice5.version5.application

import org.tsurikichi.design.practice5.version4.domain.Delivery

interface IDirectDeliverService {
    fun delivery(delivery: Delivery)
}
