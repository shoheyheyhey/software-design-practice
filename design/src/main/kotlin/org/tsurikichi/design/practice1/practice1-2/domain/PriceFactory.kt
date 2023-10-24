package org.tsurikichi.design.practice1.`practice1-2`.domain

import java.lang.IllegalArgumentException

class PriceFactory {
    companion object {
        private val map: Map<MovieType, Price> = mapOf(
            MovieType.NEW to NewPrice(),
            MovieType.REGULAR to RegularPrice(),
            MovieType.CHILDREN to ChildrenPrice()
        )

        fun factory(movieType: MovieType): Price {
            return map[movieType] ?: throw IllegalArgumentException()
        }
    }
}
