package com.froyout.stockmvvm.modules.detail.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.froyout.stockmvvm.R
import com.froyout.stockmvvm.modules.detail.ui.DetailTimeFragment

class DetailWeekAdapter(private val context : Context, fa: FragmentActivity): FragmentStateAdapter(fa) {
    private val TAB_TITLES = intArrayOf(
        R.string.w,
        R.string.m,
        R.string.Y,
        R.string.y,
        R.string.yy,
        R.string.yyy,
        R.string.all,
    )

    override fun getItemCount(): Int {
        return TAB_TITLES.size
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> DetailTimeFragment(position)
            1 -> DetailTimeFragment(position)
            2 -> DetailTimeFragment(position)
            3 -> DetailTimeFragment(position)
            4 -> DetailTimeFragment(position)
            5 -> DetailTimeFragment(position)
            6 -> DetailTimeFragment(position)
            else -> Fragment()
        }
    }

    fun getTitle(i: Int): String{
        return when(i){
            0 -> context.getString(R.string.w)
            1 -> context.getString(R.string.m)
            2 -> context.getString(R.string.Y)
            3 -> context.getString(R.string.y)
            4 -> context.getString(R.string.yy)
            5 -> context.getString(R.string.yyy)
            6 -> context.getString(R.string.all)
            else -> ""
        }
    }
}