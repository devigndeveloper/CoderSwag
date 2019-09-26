package com.devign.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devign.coderswag.Model.Category
import com.devign.coderswag.Model.Product
import com.devign.coderswag.R

class ProductsAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    // CODED 4th - Creates the view for the first time
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from((parent?.context))
            .inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    // CODED 1st - Finds how many items to display
    override fun getItemCount(): Int {
        return products.count()
    }

    // CODED 3rd - Holds the data together
    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProduct(products[position], context)
    }

    // CODED 2nd - Gets UI elements and binds it all
    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Getting our UI elements via ID
        val productImage = itemView?.findViewById<ImageView>(R.id.productImage)
        val productName = itemView?.findViewById<TextView>(R.id.productName)
        val productPrice = itemView?.findViewById<TextView>(R.id.productPrice)

        // Bind our data
        fun bindProduct(product: Product, context: Context) {
            val resourceid = context.resources.getIdentifier(product.image,
                "drawable", context.packageName)
            productImage?.setImageResource(resourceid)
            productName?.text = product.title
            productPrice?.text = product.price
        }
    }
}