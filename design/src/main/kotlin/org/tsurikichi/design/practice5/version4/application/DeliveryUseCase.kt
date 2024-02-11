package org.tsurikichi.design.practice5.version4.application

import org.springframework.stereotype.Service
import org.tsurikichi.design.practice5.version4.domain.GoldRankDelivery
import org.tsurikichi.design.practice5.version4.domain.NormalRankDelivery
import org.tsurikichi.design.practice5.version4.domain.Rank
import org.tsurikichi.design.practice5.version4.domain.RankType
import org.tsurikichi.design.practice5.version4.domain.SilverRankDelivery
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

        // 配送条件算出(配送料、当日配送可否など)
        val rank = when {
            previousMonthlyTotalAmount >= 10_000 -> Rank(RankType.GOLD)
            previousMonthlyTotalAmount >= 1_000 -> Rank(RankType.SILVER)
            else -> Rank(RankType.NORMAL)
        }
        val delivery = when (rank.rankType) {
            RankType.GOLD -> GoldRankDelivery()
            RankType.SILVER -> SilverRankDelivery()
            else -> NormalRankDelivery()
        }

        // 外部サービス連携
        if (delivery.canTodayDelivery()) {
            directDeliveryService.delivery(delivery)
        }
        mailService.send(delivery)

        // データベース連携
        deliveryRepository.save(delivery)
    }
}
