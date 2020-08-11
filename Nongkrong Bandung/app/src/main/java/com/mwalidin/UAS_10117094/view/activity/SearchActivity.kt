package com.mwalidin.UAS_10117094.view.activity

//Tanggal Pengerjaan: 8/10/2020
//Nama: Muhammad Walidin
//NIM: 10117094
//Kelas: IF-3

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.mwalidin.UAS_10117094.R
import com.mwalidin.UAS_10117094.Presenter.presenter.WisataAdapter
import com.mwalidin.UAS_10117094.model.WisataModel
import com.mwalidin.UAS_10117094.model.utils.FirestoreUtils
import com.mwalidin.UAS_10117094.model.utils.Utils
import kotlinx.android.synthetic.main.activity_search.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast
import java.util.ArrayList

class SearchActivity : AppCompatActivity() {
    lateinit var pDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        title = "Cari lokasi"

        pDialog = ProgressDialog(this)

        btn_search.onClick {
            pDialog.setMessage("Sedang mencari...")
            pDialog.show()
            FirestoreUtils.searchLokasi(this@SearchActivity,et_search.text.toString()) {
//                toast(""+it.size)
                if (it.size > 0)
                    updateRecyclerView(it)
                else
                    toast("Tidak ada lokasi yang di temukan")
                pDialog.dismiss()
            }
        }
    }

    private fun updateRecyclerView(list: ArrayList<WisataModel>) {
        Log.d(Utils.FIRE_LOG(),list.size.toString())

        val wistaAdapter = WisataAdapter(this, list)
        rv_wisata.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = wistaAdapter
        }
        if (pDialog.isShowing) pDialog.dismiss()
    }
}
