package com.devign.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devign.coderswag.Adapters.CategoryRecycleAdapter
import com.devign.coderswag.R
import com.devign.coderswag.Services.DataService
import com.devign.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    lateinit var adapter : CategoryAdapter
    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adapter = CategoryAdapter(this, DataService.categories)
//        adapter = CategoryRecycleAdapter(this, DataService.categories)

        // Using Lambda to initiate onClicks on List Items
        adapter = CategoryRecycleAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        // Creates the adapter
        categoryListView.adapter = adapter

//        // Adding a click listener for list views
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.categories[i]
//            Toast.makeText(this,"You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }

        // Create Layout Manager for Recycler Views
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)

        // Create a click listener using Lambda
    }
}
