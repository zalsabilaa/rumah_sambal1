package com.example.rumahsambal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast


class Main2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var listView = findViewById<ListView>(R.id.listmenu)
        var list = mutableListOf<listview>()

        list.add(
            listview(
                "Ayam Geprek Sambal Ijo",
                "RP. 18.000,00",
                R.drawable.ayam_geprek_sambal_ijo
            )
        )
        list.add(
            listview(
                "Ayam Geprek Sambal Merah",
                "RP. 18.000,00",
                R.drawable.ayam_geprek_sambal_merah
            )
        )
        list.add(
            listview(
                "Ayam Penyet Sambal Ijo",
                "RP. 15.000,00",
                R.drawable.ayam_penyet_sambal_ijo
            )
        )
        list.add(
            listview(
                "Ayam Geprek Sambal Matah",
                "RP. 19.000,00",
                R.drawable.ayam_geprek_sambal_matah
            )
        )
        list.add(listview("Ikan Gurame Bakar", "RP. 50.000,00", R.drawable.gurame_bakar))
        list.add(listview("Bebek Goreng", "RP. 20.000,00", R.drawable.bebek_goreng))
        list.add(listview("Sayur Asem", "RP. 10.000,00", R.drawable.sayur_asam))
        list.add(listview("Capcay", "RP. 15.000,00", R.drawable.capcay))
        list.add(listview("Perkedel", "RP. 50.000,00", R.drawable.perkedel))
        list.add(listview("Tahu Goreng", "RP. 2.000,00", R.drawable.tahu))
        list.add(listview("Tempe Goreng", "RP. 2.000,00", R.drawable.tempe))
        list.add(listview("Nasi Putih", "RP. 4.000,00", R.drawable.nasi))


        listView.adapter = listviewadapter(this, R.layout.activity_listview, list)

        listView.setOnItemClickListener { adapterView, view, i, l ->
            when (i) {
                0 -> Toast.makeText(this, "Anda memilih Ayam Geprek Sambal Ijo", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(this, "Anda memilih Ayam Geprek Sambal Merah", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(this, "Anda memilih Ayam Penyet Sambal Ijo", Toast.LENGTH_SHORT).show()
                3 -> Toast.makeText(this, "Anda memilih Ayam Geprek Sambal Matah", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(this, "Anda memilih Ikan Gurame Bakar", Toast.LENGTH_SHORT).show()
                5 -> Toast.makeText(this, "Anda memilih Bebek Goreng", Toast.LENGTH_SHORT).show()
                6 -> Toast.makeText(this, "Anda memilih Sayur Asem", Toast.LENGTH_SHORT).show()
                7 -> Toast.makeText(this, "Anda memilih Capcay", Toast.LENGTH_SHORT).show()
                8 -> Toast.makeText(this, "Anda memilih Perkedel", Toast.LENGTH_SHORT).show()
                9 -> Toast.makeText(this, "Anda memilih Tahu", Toast.LENGTH_SHORT).show()
                10 -> Toast.makeText(this, "Anda memilih Tempe", Toast.LENGTH_SHORT).show()
                11 -> Toast.makeText(this, "Anda memilih Nasi Putih", Toast.LENGTH_SHORT).show()
            }
            when (i) {
                0 -> startActivity(Intent(this@Main2, crud::class.java))
                1 -> startActivity(Intent(this@Main2, crud::class.java))
                2 -> startActivity(Intent(this@Main2, crud::class.java))
                3 -> startActivity(Intent(this@Main2, crud::class.java))
                4 -> startActivity(Intent(this@Main2, crud::class.java))
                5 -> startActivity(Intent(this@Main2, crud::class.java))
                6 -> startActivity(Intent(this@Main2, crud::class.java))
                7 -> startActivity(Intent(this@Main2, crud::class.java))
                8 -> startActivity(Intent(this@Main2, crud::class.java))
                9 -> startActivity(Intent(this@Main2, crud::class.java))
                10 -> startActivity(Intent(this@Main2, crud::class.java))
                11 -> startActivity(Intent(this@Main2, crud::class.java))

            }

        }
    }
}
