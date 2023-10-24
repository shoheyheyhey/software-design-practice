package org.tsurikichi.design.practice1.version2.application

import org.tsurikichi.design.practice1.version2.domain.Rental

class AmountAndPointCalculationService {
    fun calculateAmountAndPoint(rental: Rental): String {
        val charge = rental.calculateCharge()
        val point = rental.calculatePoint()
        return "charge: $charge, point: $point"
    }
}
