package com.example.android_kotlin.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.android_kotlin.ui.mainTab.dogs.TabDogsFragment
import com.example.android_kotlin.ui.mainTab.home.TabHomeFragment

class MainPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm)
{
    val PAGE_MAX_CNT = 3

    override fun getCount(): Int {
        return PAGE_MAX_CNT
    }

    override fun getItem(position: Int): Fragment {
        val fragment = when(position)
        {
            0 -> TabHomeFragment().newInstance()
            1 -> TabDogsFragment().newInstance()
            else -> TabDogsFragment().newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            0 -> "all"
            1 -> "dogs"
            else -> "cats"
        }
        return title
    }
}
