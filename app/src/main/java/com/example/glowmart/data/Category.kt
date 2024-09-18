package com.example.glowmart.data

sealed class Category(val category: String) {

    data object Chair: Category("Chairs")
    data object Cupboard: Category("Cupboards")
    data object Table: Category("Tables")
    data object Accessory: Category("Accessories")
    data object Furniture: Category("Furniture")
}