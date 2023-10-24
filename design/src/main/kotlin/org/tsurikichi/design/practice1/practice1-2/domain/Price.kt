package org.tsurikichi.design.practice1.`practice1-2`.domain

interface Price {

    fun getPrice(daysRented: Int): Int
    fun getPoint(): Int

    enum class Category {
        CHILDREN,
        REGULAR,
        NEW
    }
}
