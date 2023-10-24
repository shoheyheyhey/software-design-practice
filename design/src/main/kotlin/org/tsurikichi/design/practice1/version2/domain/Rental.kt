package org.tsurikichi.design.practice1.version2.domain

class Rental(private val movies: List<Movie>, private val daysRented: Int) {
    fun calculateCharge(): Int {
        return movies.sumOf { movie ->
            movie.getPrice(daysRented = daysRented)
        }
    }

    fun calculatePoint(): Int {
        return movies.sumOf { movie ->
            movie.getPoint()
        }
    }
}
