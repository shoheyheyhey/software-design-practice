package org.tsurikichi.design.practice1.practice1_3.domain

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

                Category.SEMI_NEW -> {
                    SemiNewMovie()
                }


                Category.NEW -> {
                    NewMovie()
                }

            }
        }
    }

    enum class Category {
        CHILDREN,
        REGULAR,
        SEMI_NEW,
        NEW,
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

private class SemiNewMovie: Movie {
    private val price = 300
    private val point = 10

    override fun calculateCharge(daysRented: Int): Int {
        return if (daysRented <= 5) {
            price * daysRented
        } else {
            price * daysRented + 100
        }
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

