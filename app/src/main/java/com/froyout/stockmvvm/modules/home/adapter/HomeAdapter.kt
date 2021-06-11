package com.froyout.stockmvvm.modules.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.databinding.ItemStockHomeBinding
import com.froyout.stockmvvm.domain.models.Stock

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    private var listData = ArrayList<Stock>()
    var onItemClick: ((Stock) -> Unit)? = null

    fun setData(newListData: List<Stock>?){
        if(newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_stock_home, parent,false))
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    inner class HomeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemStockHomeBinding.bind(itemView)
        fun bind(data: Stock){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.imageUrl)
                    .into(img)
                name.text = data.name

            }
        }
    }
}