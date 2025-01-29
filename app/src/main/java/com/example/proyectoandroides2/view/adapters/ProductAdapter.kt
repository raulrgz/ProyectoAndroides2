package com.example.proyectoandroides2.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoandroides2.databinding.ProductItemBinding
import com.example.proyectoandroides2.model.ShopItem
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.proyectoandroides2.R

class ProductAdapter(
    var shop: MutableList<ShopItem>
): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ProductItemBinding.bind(view)

        fun setupUI(item: ShopItem) {
            //binding.itemImageView = ??
            binding.titleTextView.text = item.title
            binding.descriptionTextView.text = item.description
            binding.priceTextView.text = "$" + item.price.toString()
            binding.rateTextView.text = item.rating.rate.toString()

            Glide.with(itemView.context)
                .load(item.image)
                .placeholder(R.drawable.loading_ic)
                .error(R.drawable.error_ic)
                .into(binding.itemImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shop.count()
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.setupUI(shop[position])
    }


}