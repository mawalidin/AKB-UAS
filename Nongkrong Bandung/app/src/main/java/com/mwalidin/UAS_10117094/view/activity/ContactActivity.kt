package com.mwalidin.UAS_10117094.view.activity

//Tanggal Pengerjaan: 8/10/2020
//Nama: Muhammad Walidin
//NIM: 10117094
//Kelas: IF-3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mwalidin.UAS_10117094.R

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        supportActionBar?.hide()
    }
}