package com.mwalidin.UAS_10117094.view.activity

//Tanggal Pengerjaan: 8/11/2020
//Nama: Muhammad Walidin
//NIM: 10117094
//Kelas: IF-3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.mwalidin.UAS_10117094.R
import com.mwalidin.UAS_10117094.Presenter.presenter.SliderAdapter

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        val pagerAdapter = SliderAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.viewpagerIntro)
        pager.adapter = pagerAdapter
    }
}