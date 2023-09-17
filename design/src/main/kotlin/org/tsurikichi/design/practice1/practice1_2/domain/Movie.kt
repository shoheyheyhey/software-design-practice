package org.tsurikichi.design.practice1.practice1_2.domain

interface Movie {

    fun calculateCharge(daysRented: Int): Int
    fun calculatePoint(): Int

    companion object {
        fun movieFactory(category: Category): Movie {
            return when (category) {
                Category.CHILDREN -> {
                    ChildrenMovie()
                }

                Category.REGULAR -> {
                    RegularMovie()
                }

                Category.NEW -> {
                    NewMovie()
                }

            }
        }
    }

    enum class Category {
        CHILDREN,
        NEW,
        REGULAR,
    }
}

private class ChildrenMovie : Movie {
    private val price = 100
    private val point = 5

    override fun calculateCharge(daysRented: Int): Int {
        return if (daysRented <= 5) {
            price * daysRented
        } else {
            price * daysRented - 100
        }
    }

    override fun calculatePoint(): Int {
        return point
    }

}

private class RegularMovie: Movie {
    private val price = 200
    private val point = 10

    override fun calculateCharge(daysRented: Int): Int {
        return price * daysRented
    }

    override fun calculatePoint(): Int {
        return point
    }

}

private class NewMovie: Movie {
    private val price = 300
    private val point = 20

    override fun calculateCharge(daysRented: Int): Int {
        return if (daysRented <= 3) {
            price * daysRented
        } else {
            price * daysRented + 100
        }
    }

    override fun calculatePoint(): Int {
        return point
    }

}

