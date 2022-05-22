package com.example.rumahsambal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton



class home : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val imgtroli=findViewById<ImageButton>(R.id.troli)
        imgtroli.setOnClickListener {
            startActivity(Intent(this@home, Main2::class.java))
        }
        val imgemail=findViewById<ImageButton>(R.id.btnemail)
            imgemail.setOnClickListener{
                startActivity(Intent(this@home,crud::class.java))
    }
        val imgexit=findViewById<ImageButton>(R.id.out)
        imgexit.setOnClickListener{
            startActivity(Intent(this@home,MainActivity::class.java))

        }

        }
    override fun onClick(p0: View) {
        when (p0.id) {


        }
    }
    }
