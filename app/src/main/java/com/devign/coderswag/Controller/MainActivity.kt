package com.devign.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.devign.coderswag.Adapters.CategoryAdapter
import com.devign.coderswag.Adapters.CategoryRecycleAdapter
import com.devign.coderswag.Model.Category
import com.devign.coderswag.R
import com.devign.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    lateinit var adapter : CategoryAdapter
    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adapter = CategoryAdapter(this, DataService.catergories)
        adapter = CategoryRecycleAdapter(this, DataService.catergories)
        categoryListView.adapter = adapter

//        // Adding a click listener for list views
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataService.catergories[i]
//            Toast.makeText(this,"You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }

        // Create Layout Manager for Recycler Views
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
