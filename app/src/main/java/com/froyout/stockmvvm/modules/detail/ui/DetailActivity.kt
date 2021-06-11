package com.froyout.stockmvvm.modules.detail.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.databinding.ActivityDetailBinding
import com.froyout.stockmvvm.domain.models.Stock
import com.froyout.stockmvvm.modules.detail.adapter.DetailStockAdapter
import com.froyout.stockmvvm.utils.dummy.DataDummy
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.tabs.TabLayoutMediator


class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val EXTRA_STOCK1 = "saham1"
        const val EXTRA_STOCK2 = "saham2"
        const val EXTRA_STOCK3 = "saham3"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailAdapter = DetailStockAdapter(this, this)
        binding.pager.adapter = detailAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = detailAdapter.getTitle(position)
        }.attach()

        binding.back.setOnClickListener {
            onBackPressed()
        }


    }

    fun getExtras(): List<Stock?>{
        val stock1 = intent.getParcelableExtra<Stock>(EXTRA_STOCK1)
        val stock2 = intent.getParcelableExtra<Stock>(EXTRA_STOCK2)
        val stock3 = intent.getParcelableExtra<Stock>(EXTRA_STOCK3)

        val lists = ArrayList<Stock?>()
        lists.add(stock1)
        lists.add(stock2)
        lists.add(stock3)
        return lists
    }

}