package org.tsurikichi.design.practice1.version2.domain

class ChildrenPrice : Price {
    private val price = 100
    private val point = 5

    override fun getPrice(daysRented: Int): Int {
        return if (daysRented <= 5) {
            price * daysRented
        } else {
            price * daysRented - 100
        }
    }

    override fun getPoint(): Int {
        return point
    }
}
