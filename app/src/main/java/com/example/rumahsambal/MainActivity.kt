package com.example.rumahsambal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.rumahsambal.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnDaftar1.setOnClickListener {
            val intent = Intent(this, daftar::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.emaillogin.text.toString()
            val password = binding.passwordlogin.text.toString()

            if (username.isEmpty()) {
                binding.emaillogin.error = "Email Harus Di isi"
                binding.emaillogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                binding.emaillogin.error = "Email Tidak Valid"
                binding.emaillogin.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.passwordlogin.error = "Password Harus Diisi"
                binding.passwordlogin.requestFocus()
                return@setOnClickListener
            }

            LoginFirebase(username, password)
        }
    }

    private fun LoginFirebase(username: String, password: String) {
        auth.signInWithEmailAndPassword(username,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this, "SELAMAT DATANG DI RUMAH SAMBAL", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,home::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    }

