package com.froyout.stockmvvm.modules.home.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.froyout.stockmvvm.databinding.ActivityHomeBinding
import com.froyout.stockmvvm.modules.detail.ui.DetailActivity
import com.froyout.stockmvvm.modules.home.adapter.HomeAdapter
import com.froyout.stockmvvm.modules.home.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val homeAdapter = HomeAdapter()

        viewModel.getStocks().observe(this, {
            stocks ->
            homeAdapter.setData(stocks)
            binding.btn.setOnClickListener {
                val intent = Intent(this, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_STOCK1, stocks[0])
                intent.putExtra(DetailActivity.EXTRA_STOCK2, stocks[1])
                intent.putExtra(DetailActivity.EXTRA_STOCK3, stocks[2])
                startActivity(intent)
            }
        })

        with(binding.rvHome){
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = homeAdapter
        }
    }
}