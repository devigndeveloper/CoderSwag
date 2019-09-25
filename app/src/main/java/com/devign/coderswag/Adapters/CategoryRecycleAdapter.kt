package com.devign.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devign.coderswag.Model.Category
import com.devign.coderswag.R

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    // called when new View Holders are needed (simlar to the inflation that happens in List Views)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent?.context)
            .inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)
    }

    // finds how many items to display
    override fun getItemCount(): Int {
        return categories.count()
    }

    // called by the recycler to display the data where specified
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    // create a View Holder
    inner class Holder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {

        // Getting our UI elements
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        // Bind our data
        fun bindCategory(category: Category, context: Context){
            val resourceid = context.resources.getIdentifier(category.image,
                "drawable", context.packageName)
            categoryImage?.setImageResource(resourceid)
            categoryName?.text = category.title

            // Set the click listener
            itemView.setOnClickListener{ itemClick(category) }
        }
    }
}