package com.devign.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devign.coderswag.R
import com.devign.coderswag.Utilities.EXTRA_CATEGORY

class ProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Get category type using intent
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
    }
}
