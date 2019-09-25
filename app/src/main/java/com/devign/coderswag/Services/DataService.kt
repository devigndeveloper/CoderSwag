package com.devign.coderswag.Services

import com.devign.coderswag.Model.Category
import com.devign.coderswag.Model.Product

object DataService {

    // unchangeable arrays
    val categories = listOf(
        Category("SHIRTS","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage")
    )

    val hats = listOf(
        Product("Devslopes Graphic Beanie","$18","hat1"),
        Product("Devslopes Hat Black","$20","hat2"),
        Product("Devslopes Hat White","$18","hat3"),
        Product("Devslopes Hat Snapback","$22","hat4")
    )

    val hoodies = listOf(
        Product("Devslopes Hoodies Grey", "$28", "hoodie1"),
        Product("Devslopes Hoodies Red", "$32", "hoodie2"),
        Product("Devslopes Grey Hoodie", "$28", "hoodie3"),
        Product("Devslopes Black Hoodie", "$32", "hoodie4")
    )

    val shirts = listOf(
        Product("Devslopes Shirt Black", "$18", "shirt1"),
        Product("Devslopes Badge Light Grey", "$20", "shirt2"),
        Product("Devslopes Logo Shirt Red", "$22", "shirt3"),
        Product("Devslopes Hustle", "$22", "shirt4"),
        Product("Kickflip Studios","$18","shirt5")
    )

    val digitalGood = listOf<Product>()

    // Determine which items are shown
    fun getProducts(category: String) : List<Product> {
        return when(category) {
            "SHIRTS" -> shirts
            "HATS" -> hats
            "HOODIES" -> hoodies
            else -> digitalGood
        }
    }

}