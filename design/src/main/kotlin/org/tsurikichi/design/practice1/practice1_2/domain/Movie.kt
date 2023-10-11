package org.tsurikichi.design.practice1.practice1_2.domain

class Movie(private val price: Price) {
    fun getPrice(daysRented: Int): Int {
        return price.getPrice(daysRented)
    }

    fun getPoint(): Int {
        return price.getPoint()
    }
}
