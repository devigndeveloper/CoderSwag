package com.devign.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.devign.coderswag.Model.Category
import com.devign.coderswag.R
import java.text.FieldPosition

// All Array Adapters first calls this BaseAdapter before initiolizing - this is the parent for ALL Array Adapters. All Array adapaters need these four thing to operate...
class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter() {

    val context = context
    val categories = categories

    // What a user sees
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View

        // Pushes out the data
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
        val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage)
        val categoryName : TextView = categoryView.findViewById(R.id.categoryName)

        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName)
        categoryImage.setImageResource(resourceId)
        println(resourceId)

        categoryName.text = category.title

        return categoryView
    }

    // Method that retrieves the items by finding the position of each item
    override fun getItem(position: Int): Any {
        return categories[position]
    }

    // Method that defines a unique ID for each row - in this project we're not using this
    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }
}