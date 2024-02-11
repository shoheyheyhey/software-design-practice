package org.tsurikichi.design.practice5.version5.application

import io.mockk.every
import io.mockk.mockkClass
import io.mockk.verifySequence
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.tsurikichi.design.practice5.version5.domain.Delivery
import org.tsurikichi.design.practice5.version5.domain.RankType
import java.time.LocalDate

class TestDeliveryUseCase {
    private val deliveryRepository = mockkClass(IDeliveryRepository::class)
    private val directDeliveryService = mockkClass(IDirectDeliverService::class)
    private val mailService = mockkClass(IMailService::class)

    private val target = DeliveryUseCase(deliveryRepository, directDeliveryService, mailService)

    @Test
    fun `配送指示とメール通知ができる`() {
        every { deliveryRepository.save(any()) } returns Unit
        every { directDeliveryService.delivery(any()) } returns Unit
        every { mailService.send(any()) } returns Unit

        target.delivery(deliveryDate = LocalDate.of(2024, 1, 1), previousMonthlyTotalAmount = 10001)

        verifySequence {
            directDeliveryService.delivery(Delivery.factory(RankType.GOLD))
            mailService.send(Delivery.factory(RankType.GOLD))
            deliveryRepository.save(Delivery.factory(RankType.GOLD))
        }
    }

    @Test
    fun `配送日に過去日が指定されると配送できない`() {
        assertThrows<IllegalArgumentException> {
            target.delivery(deliveryDate = LocalDate.of(2022, 1, 1), previousMonthlyTotalAmount = 100)
        }
    }
}
