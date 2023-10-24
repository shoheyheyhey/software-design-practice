package org.tsurikichi.design.practice1.version1.application

import org.tsurikichi.design.practice1.version1.domain.Movie
import org.tsurikichi.design.practice1.version1.domain.Rental

class AmountAndPointCalculationService {
    fun calculateAmountAndPoint(rental: Rental): String {
        var charge = 0
        var point = 0
        rental.movies.forEach { movie ->
            when (movie.category) {
                Movie.Category.CHILDREN -> {
                    charge += if (rental.daysRented <= 5) {
                        100 * rental.daysRented
                    } else {
                        100 * rental.daysRented - 100
                    }

                    point += 5
                }
                Movie.Category.REGULAR -> {
                    charge += 200 * rental.daysRented
                    point += 10
                }
                Movie.Category.NEW -> {
                    charge += if (rental.daysRented <= 3) {
                        300 * rental.daysRented
                    } else {
                        300 * rental.daysRented + 100
                    }

                    point += 20
                }
            }
        }
        return "charge: $charge, point: $point"
    }
}
