package com.froyout.stockmvvm.modules.detail.adapter

import android.content.Context
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.modules.detail.ui.DanaKelolaFragment
import com.froyout.stockmvvm.modules.detail.ui.ImbalHasilFragment

class DetailStockAdapter(private val context: Context, fa: FragmentActivity): FragmentStateAdapter(fa) {
    companion object {
        private val TAB_TITLES = intArrayOf(R.string.imbal_hasil, R.string.dana_kelola)
    }

    override fun getItemCount(): Int {
        return TAB_TITLES.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> DanaKelolaFragment()
            1 -> ImbalHasilFragment()
            else -> Fragment()
        }
    }

    fun getTitle(position: Int): String{
        return context.getString(TAB_TITLES[position])

    }






}