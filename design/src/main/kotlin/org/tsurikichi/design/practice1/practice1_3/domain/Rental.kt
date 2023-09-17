package org.tsurikichi.design.practice1.practice1_3.domain

class Rental(private val movies: List<Movie>, private val daysRented: Int) {
    fun calculateCharge(): Int {

        return movies.sumOf { movie ->
            movie.calculateCharge(daysRented = daysRented)
        }
    }

    fun calculatePoint(): Int {
        return movies.sumOf { movie ->
            movie.calculatePoint()
        }
    }

}



