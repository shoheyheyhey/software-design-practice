package org.tsurikichi.design.practice1.practice1_2.domain

class RegularPrice: Price {
    private val price = 200
    private val point = 10

    override fun getPrice(daysRented: Int): Int {
        return price * daysRented
    }

    override fun getPoint(): Int {
        return point
    }

}
