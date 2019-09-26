package com.devign.coderswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.devign.coderswag.Adapters.ProductsAdapter
import com.devign.coderswag.Model.Product
import com.devign.coderswag.R
import com.devign.coderswag.Services.DataService
import com.devign.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    // Create global variable for adapter
    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        // Get category type using intent
        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        // Create adapter
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        // Media queries the items for landscape viewing - PHONE
        // -- sets default span count (how many items are seen on portrait)
        var spanCount = 2
        // -- create orientation variable
        val orientation = resources.configuration.orientation
        // -- if orientation is landscape
        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // -- then change the span count to 3
            spanCount = 3
        }
        // Media queries for larger devices
        // -- create screen size variable
        val screenSize = resources.configuration.screenWidthDp
        // -- if screensize is greater than 720 (standard tablet dimensions)
        if(screenSize > 720) {
            // -- then change the span count to 3
            spanCount = 3
        }


        // Create Layout Manager - use grid
        val layoutManager = GridLayoutManager(this,2)
        // Sets layout manager
        productListView.layoutManager = layoutManager
        // sets adapater
        productListView.adapter = adapter
    }
}
