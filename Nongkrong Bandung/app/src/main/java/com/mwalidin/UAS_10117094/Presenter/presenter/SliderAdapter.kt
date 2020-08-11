package com.mwalidin.UAS_10117094.Presenter.presenter

//Tanggal Pengerjaan: 8/11/2020
//Nama: Muhammad Walidin
//NIM: 10117094
//Kelas: IF-3


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.mwalidin.UAS_10117094.view.fragment.about
import com.mwalidin.UAS_10117094.view.fragment.about2
import com.mwalidin.UAS_10117094.view.fragment.launch

class SliderAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {
    val PAGE_MAX_CNT = 3

    override fun getCount(): Int {
        return PAGE_MAX_CNT
    }

    override fun getItem(position: Int): Fragment? {
        val fragment = when(position)
        {
            1 -> about2().newInstance()
            2 -> launch().newInstance()
            3 -> about().newInstance()
            else -> about().newInstance()
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            1 -> "About"
            2 -> "Fitur Tambahan"
            3 -> "Launch!"
            else -> "About"
        }
        return title
    }
}