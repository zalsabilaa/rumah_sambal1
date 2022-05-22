package com.example.rumahsambal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.rumahsambal.databinding.ActivityDaftarBinding
import com.google.firebase.auth.FirebaseAuth


class daftar : AppCompatActivity(){

    lateinit var  binding: ActivityDaftarBinding
    lateinit var auth :FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.tologin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.register.setOnClickListener{
            val username = binding.emaildaftar.text.toString()
            val password = binding.password.text.toString()

            if (username.isEmpty()){
                binding.emaildaftar.error ="Email Harus Di isi"
                binding.emaildaftar.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()){
                binding.emaildaftar.error ="Email Tidak Valid"
                binding.emaildaftar.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                binding.password.error ="Password Harus Diisi"
                binding.password.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 6){
                binding.password.error ="Mohon Masukan Password Minimal 6 Karakter"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            RegisterFirebase(username,password)
        }
    }

    private fun RegisterFirebase(username: String, password: String) {
            auth.createUserWithEmailAndPassword(username,password)
                .addOnCompleteListener(this){
                    if(it.isSuccessful){
                        Toast.makeText(this, "SELAMAT!! Akun Anda Telah Terdaftar", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this,MainActivity::class.java)
                        startActivity(intent)
                    } else{
                        Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
    }
}

