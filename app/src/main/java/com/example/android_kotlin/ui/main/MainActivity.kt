package com.example.android_kotlin.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.example.android_kotlin.R
import com.example.android_kotlin.ui.base.BaseActivity
import com.google.android.material.tabs.TabLayout
import mu.KLogging


class MainActivity :  BaseActivity() , MainMvpView{

   @BindView(R.id.mainTabs)
   lateinit var mainTabs: TabLayout

    @BindView(R.id.mainPager)
    lateinit var mainPager: ViewPager

    private val TAG = "MainActivity"
   // private lateinit var fragmentTransaction : FragmentTransaction

    lateinit var mainPagerAdapter : MainPagerAdapter
   // val pagerAdapter = PagerAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUnBinder(ButterKnife.bind(this))

        setUp()
    }

    // view setUp 부분
    override fun setUp() {
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)
        mainPager.adapter = mainPagerAdapter

        mainTabs.setupWithViewPager(mainPager)

    }
    companion object: KLogging()
}
