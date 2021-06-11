package com.froyout.stockmvvm.modules.detail.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.databinding.ItemDetailStock1Binding
import com.froyout.stockmvvm.domain.models.Stock
import com.froyout.stockmvvm.utils.common.NumberUtils

class TimeStockAdapter(private val context: Context): RecyclerView.Adapter<TimeStockAdapter.TimeStockViewHolder>() {

    var listStock = ArrayList<Stock?>()

    fun setData(newListStock: List<Stock?>?){
        if(newListStock == null) return
        listStock.clear()
        listStock.addAll(newListStock)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TimeStockAdapter.TimeStockViewHolder {
        return TimeStockViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_detail_stock1, parent, false))
    }

    override fun onBindViewHolder(holder: TimeStockAdapter.TimeStockViewHolder, position: Int) {
        val data = listStock[position]
        if(data != null){
            holder.bind(data, position)
        }
    }

    override fun getItemCount(): Int {
        return listStock.size
    }

    inner class TimeStockViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = ItemDetailStock1Binding.bind(itemView)
        fun bind(data: Stock, position: Int){
            with(binding){
                Glide.with(itemView.context)
                    .load(data.imageUrl)
                    .into(img)
                name.text = data.name
                dana.text = NumberUtils.withSuff(data.dana.toLong())
                jangka.text = data.jangka
                hasil.text = data.imbal
                jenis.text = data.type
                resiko.text = data.resiko
                minBeli.text = data.pembelian
                peluncuran.text = data.peluncuran
            }

            when(position){
                0 -> changeColor(R.drawable.bg_compare1)
                1 -> changeColor(R.drawable.bg_compare2)
                else -> changeColor(R.drawable.bg_compare3)
            }

        }
        fun changeColor(drawable: Int){
            with(binding){
                lytHasil.setBackgroundResource(drawable)
                lytBeli.setBackgroundResource(drawable)
                lytDana.setBackgroundResource(drawable)
                lytJenis.setBackgroundResource(drawable)
                lytJangka.setBackgroundResource(drawable)
                lytPeluncuran.setBackgroundResource(drawable)
                lytResiko.setBackgroundResource(drawable)
                lytName.setBackgroundResource(drawable)
            }
        }
    }
}