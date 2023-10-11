package org.tsurikichi.design.practice1.practice1_2.domain

class NewPrice: Price {
    private val price = 300
    private val point = 20

    override fun getPrice(daysRented: Int): Int {
        return if (daysRented <= 3) {
            price * daysRented
        } else {
            price * daysRented + 100
        }
    }

    override fun getPoint(): Int {
        return point
    }

}
