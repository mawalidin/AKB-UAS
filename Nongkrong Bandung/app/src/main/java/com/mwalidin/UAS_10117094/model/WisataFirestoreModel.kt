package com.mwalidin.UAS_10117094.model

//Tanggal Pengerjaan: 8/8/2020
//Nama: Muhammad Walidin
//NIM: 10117094
//Kelas: IF-3

data class WisataFirestoreModel (
        val nama: String,
        val deskripsi: String,
        val alamat: String,
        val sumber: String,
        val harga: String,
        val lat: String,
        val lon: String,
        val phone: String,
        val foto1: String,
        val foto2: String,
        val foto3: String ) {
    constructor(): this("","","","","","","","","","","")
}