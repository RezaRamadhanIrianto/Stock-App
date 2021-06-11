package com.froyout.stockmvvm.modules.detail.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.databinding.FragmentDanaKelolaBinding
import com.froyout.stockmvvm.domain.models.Stock
import com.froyout.stockmvvm.modules.detail.adapter.DetailWeekAdapter
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.android.material.tabs.TabLayoutMediator

class DanaKelolaFragment : Fragment() {

    private var _binding: FragmentDanaKelolaBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDanaKelolaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datas = (activity as DetailActivity).getExtras()
        configureChart(datas)
        configurePager()
    }

    private fun configurePager(){
        val weekAdapter = DetailWeekAdapter(requireContext(), requireActivity())
        binding.pager.adapter = weekAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = weekAdapter.getTitle(position)
        }.attach()
    }

    private fun configureChart(stocks: List<Stock?>){
        val xList = ArrayList<Float>()
        xList.add(10F)
        xList.add(20F)
        xList.add(30F)
        xList.add(40F)
        xList.add(50F)

        val listDatas = ArrayList<LineDataSet>()
        for(i in 0..stocks.size - 1){
            if(stocks[i] != null){
                listDatas.add(configureLineData(xList, stocks[i]!!.data, stocks[i]!!.name, i))
            }
        }

        with(binding){
            chart.data = LineData(listDatas as List<LineDataSet>)
            chart.setDrawGridBackground(false)
            chart.setDrawBorders(false)
            chart.isAutoScaleMinMaxEnabled = true
            chart.axisLeft.isEnabled = false
            chart.xAxis.isEnabled = false
        }
    }

    private fun configureLineData(x : List<Float>, y :List<Float>, label: String, i: Int): LineDataSet {
        val circles = ArrayList<Int>()
        circles.add(R.color.black)
        val entries = ArrayList<Entry>()
        for(j in 0..4){
            entries.add(Entry(x[j], y[j]))
        }
        val dataSet = LineDataSet(entries, label)
        dataSet.lineWidth = 3f

        if(i == 0){
            dataSet.color = ContextCompat.getColor(requireContext(), R.color.lignt_green)
            dataSet.fillColor = ContextCompat.getColor(requireContext(), R.color.lignt_green)
        }else if(i == 1){
            dataSet.color = ContextCompat.getColor(requireContext(), R.color.light_blue)
            dataSet.fillColor = ContextCompat.getColor(requireContext(), R.color.light_blue)
        }else{
            dataSet.color = ContextCompat.getColor(requireContext(), R.color.light_purple)
            dataSet.fillColor = ContextCompat.getColor(requireContext(), R.color.light_purple)
        }
        dataSet.circleColors  = circles

        return dataSet
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}