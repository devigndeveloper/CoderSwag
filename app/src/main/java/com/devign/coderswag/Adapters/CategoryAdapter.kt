package com.devign.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devign.coderswag.Model.Category
import com.devign.coderswag.R
import java.text.FieldPosition

// All Array Adapters first calls this BaseAdapter before initiolizing - this is the parent for ALL Array Adapters. All Array adapaters need these four thing to operate...
class CategoryAdapter(val context: Context, val categories: List<Category>) : BaseAdapter() {

    // What a user sees
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder : ViewHolder

        // if we show the data the first time, do this
        if (convertView == null) {
            // Pushes out the data - inflates layout, grabs template
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            // Initialises the holder - The holder stops the phone from reloading data once scrolled away. It holds onto the data, so that when a user scrolls back to it it can display it - saving space in the memory
            holder = ViewHolder()

            // Finds the image and name and pushes it out through the holder
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holder
        } else {
            // if the data has been created already, re-use the data we're holding
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }



        // for loops the array to give each category an index
        val category = categories[position]
        val resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title

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

    // Let's us re-use and recycle data
    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}