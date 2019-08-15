package com.example.android_kotlin.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.example.android_kotlin.R
import com.example.android_kotlin.ui.base.BaseActivity
import com.google.android.material.tabs.TabLayout


class MainActivity :  BaseActivity() , MainMvpView{

   @BindView(R.id.mainTabs)
   lateinit var mainTabs: TabLayout

    @BindView(R.id.mainPager)
    lateinit var mainPager: ViewPager

   // private lateinit var fragmentTransaction : FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUnBinder(ButterKnife.bind(this))
        //setUp()
    }

    // view setUp 부분
    override fun setUp() {

       // fragmentTransaction = supportFragmentManager.beginTransaction()

       mainTabs.setupWithViewPager(mainPager)

    }

}
