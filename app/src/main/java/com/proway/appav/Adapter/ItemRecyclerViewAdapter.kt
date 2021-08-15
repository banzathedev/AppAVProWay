package com.proway.appav.Adapter

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.proway.appav.R
import com.proway.appav.interfaces.ClickableItem
import com.proway.appav.model.Products


class ItemRecyclerViewAdapter(
    val listOfProducts: List<Products>,
    val onClick: ClickableItem) :
    RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_list, parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        listOfProducts[position].apply {
            holder.bind(this)
           holder.itemView.setOnClickListener {
               onClick.onClickGoToDetail(this)
           }

        }

    }

    override fun getItemCount(): Int = listOfProducts.size


}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val name = view.findViewById<TextView>(R.id.itemNameID)
    private val category = view.findViewById<TextView>(R.id.itemCategoryId)
    private val price = view.findViewById<TextView>(R.id.itemPriceId)
    private val imageLogo = view.findViewById<ImageView>(R.id.itemLogoId)
    fun bind(products: Products) {
        name.text = "Name: ${products.name}"
        category.text = "Category: ${products.category}"
        price.text = "Price: $" + products.price.toString()
        imageLogo.apply {
            Glide.with(context)
                .load(products.image)
                .placeholder(R.drawable.ic_baseline_access_time_24)
                .into(this)
        }
    }
}
