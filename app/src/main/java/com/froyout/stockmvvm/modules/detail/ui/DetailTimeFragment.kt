package com.froyout.stockmvvm.modules.detail.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.databinding.FragmentDetailTimeBinding
import com.froyout.stockmvvm.domain.models.Stock
import com.froyout.stockmvvm.modules.detail.adapter.TimeStockAdapter

class DetailTimeFragment(private val position: Int) : Fragment() {

    private var _binding: FragmentDetailTimeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailTimeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datas = (activity as DetailActivity).getExtras()
        populateDetail(datas)
    }

    private fun populateDetail(stocks: List<Stock?>){
        val detailAdapter = TimeStockAdapter(requireContext())
        detailAdapter.setData(stocks)
        with(binding.rvTime){
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = detailAdapter
        }
    }
}