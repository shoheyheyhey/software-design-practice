package org.tsurikichi.design.practice1.`practice1-2`.`application-service`

import org.tsurikichi.design.practice1.`practice1-2`.domain.Rental

class AmountAndPointCalculationService {
    fun calculateAmountAndPoint(rental: Rental): String {
        val charge = rental.calculateCharge()
        val point = rental.calculatePoint()
        return "charge: $charge, point: $point"
    }
}
