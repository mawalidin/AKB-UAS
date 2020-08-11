package com.mwalidin.UAS_10117094.view.activity

//Tanggal Pengerjaan: 8/10/2020
//Nama: Muhammad Walidin
//NIM: 10117094
//Kelas: IF-3

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.firestore.ListenerRegistration
import com.mwalidin.UAS_10117094.R
import com.mwalidin.UAS_10117094.Presenter.presenter.WisataAdapter
import com.mwalidin.UAS_10117094.model.WisataModel
import com.mwalidin.UAS_10117094.model.utils.FirestoreUtils
import com.mwalidin.UAS_10117094.model.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var pDialog : ProgressDialog
    lateinit var toggle : ActionBarDrawerToggle
    private lateinit var listenerRegistration: ListenerRegistration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_info -> startActivity<ContactActivity>()
                R.id.action_add_place -> startActivity<AddPlaceActivity>()
                R.id.action_search -> startActivity<SearchActivity>()
            }
            true
        }

//        wisataList = WisataData.list()
//        initRecyclerView()
        pDialog = ProgressDialog(this)

        pDialog.setMessage("Load data lokasi...")
        pDialog.setCancelable(false)
        pDialog.show()
        listenerRegistration = FirestoreUtils.getPlace{
            if (it.size > 0)
                updateRecyclerView(it)
            else
                if (pDialog.isShowing) pDialog.dismiss()
        }
    }

    private fun updateRecyclerView(list: ArrayList<WisataModel>) {
        Log.d(Utils.FIRE_LOG(),list.size.toString())

        val wistaAdapter = WisataAdapter(this, list)
        rv_wisata.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = wistaAdapter
        }
        if (pDialog.isShowing) pDialog.dismiss()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {

            return true
        }
//        return when (item.itemId) {
//            R.id.action_info -> {
//                startActivity<ContactActivity>()
//                return true
//            }
//            R.id.action_add_place -> {
//                startActivity<AddPlaceActivity>()
//                return true
//            }
//            R.id.action_search -> {
//                startActivity<SearchActivity>()
//                return true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
        return true
    }
}
