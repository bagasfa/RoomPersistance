package com.example.roompersistance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = MahasiswaDatabase(this)

        GlobalScope.launch {
            val data = db.mDao().getAll()

            data?.forEach {
                Log.d("DATABASE", it.toString())
            }
        }

        btnAdd.setOnClickListener {

            var nama = txt_nama.text.toString()
            var alamat = txt_alamat.text.toString()

            hasil.setText("Hai, $nama \n. Dari $alamat")

            GlobalScope.launch {
                db.mDao().insertAll(MahasiswaEntity(0, "$nama", "$alamat"))
                val data = db.mDao().getAll()

                data?.forEach {
                    Log.d("DATABASE", it.toString())
                }
            }

        }

    }

    fun addData(view: View) {

    }
}