package com.mwalidin.UAS_10117094.view.fragment

//Tanggal Pengerjaan: 8/11/2020
//Nama: Muhammad Walidin
//NIM: 10117094
//Kelas: IF-3

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mwalidin.UAS_10117094.R

open class about2: Fragment(){
    fun newInstance(): about2
    {
        val args = Bundle()

        val frag = about2()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.about2, container, false)
        return v
    }
}