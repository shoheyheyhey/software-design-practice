package org.tsurikichi.design.practice5.version5.application

import org.springframework.stereotype.Service
import org.tsurikichi.design.practice5.version4.domain.Delivery
import org.tsurikichi.design.practice5.version4.domain.Rank
import java.time.LocalDate

@Service
class DeliveryUseCase(
    private val deliveryRepository: IDeliveryRepository,
    private val directDeliveryService: IDirectDeliverService,
    private val mailService: IMailService
) {
    fun delivery(
        deliveryDate: LocalDate,
        previousMonthlyTotalAmount: Int
    ) {
        val today = LocalDate.now()
        if (today.isAfter(deliveryDate)) throw IllegalArgumentException("配送日が過去の日付です")

        val rank = Rank.create(previousMonthlyTotalAmount)
        val delivery = Delivery.factory(rank.rankType)

        if (delivery.canTodayDelivery()) {
            directDeliveryService.delivery(delivery)
        }

        mailService.send(delivery)
        deliveryRepository.save(delivery)
    }
}
