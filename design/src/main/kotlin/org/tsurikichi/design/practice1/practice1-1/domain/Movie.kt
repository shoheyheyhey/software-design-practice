package org.tsurikichi.design.practice1.`practice1-1`.domain

data class Movie(val category: Category) {
    enum class Category {
        CHILDREN,
        NEW,
        REGULAR
    }
}
