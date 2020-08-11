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

open class about: Fragment() {
    fun newInstance(): about
    {
        val args = Bundle()

        val frag = about()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.about, container, false)
        return v
    }
}