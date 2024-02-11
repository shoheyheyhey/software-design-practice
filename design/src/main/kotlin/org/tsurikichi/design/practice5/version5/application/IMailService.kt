package org.tsurikichi.design.practice5.version5.application

import org.tsurikichi.design.practice5.version5.domain.Delivery

interface IMailService {
    fun send(delivery: Delivery)
}
