package com.example.rumahsambal

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class crud : AppCompatActivity(){

    private lateinit var etId: EditText
    private lateinit var etMenu: EditText
    private lateinit var etHarga: EditText
    private lateinit var etJumlah: EditText
    private lateinit var RSambal: RadioButton
    private lateinit var RSerundeng: RadioButton
    private lateinit var btnCekout: Button
    private lateinit var btnUbah: Button
    private lateinit var btnHapus: Button
    private lateinit var btnTampil: Button
    private var tambahan: String =""

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud)
        etId = findViewById(R.id.etId)
        etMenu = findViewById(R.id.etMenu)
        etHarga = findViewById(R.id.etHarga)
        etJumlah = findViewById(R.id.etJumlah)
        RSambal = findViewById(R.id.RSambal)
        RSerundeng = findViewById(R.id.RSerundeng)
        btnCekout = findViewById(R.id.btnCekout)
        btnUbah = findViewById(R.id.btnUbah)
        btnHapus = findViewById(R.id.btnHapus)
        btnTampil = findViewById(R.id.btnTampil)
        simpanData()
        ubahData()
        hapusData()
        tampilData()


    }

    fun tampilToast(text: String) {
        Toast.makeText(this@crud, text, Toast.LENGTH_LONG).show()
    }

    fun tampilDialog(title: String, Message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setCancelable(true)
        builder.setTitle(title)
        builder.setMessage(Message)
        builder.show()
    }

    fun bersihkanEditTexts() {
        etId.setText("")
        etMenu.setText("")
        etHarga.setText("")
        etJumlah.setText("")

        if (RSambal.isChecked) {
            tambahan = RSambal.text.toString()
        } else if (RSerundeng.isChecked) {
            tambahan = RSambal.text.toString()
        }
    }

    fun simpanData() {
        btnCekout.setOnClickListener {
            val dialog: ProgressDialog = ProgressDialog(this);
            dialog.setMessage("Menyimpan")
            dialog.show()

            if (RSambal.isChecked) {
                tambahan = RSambal.text.toString()
            } else if (RSerundeng.isChecked) {
                tambahan = RSerundeng.text.toString()
            }

            val user: User = User(
                etId.text.toString(),
                etMenu.text.toString(),
                etHarga.text.toString(),
                etJumlah.text.toString(),
                tambahan
            )
            myRef.child(user.nopesanan).setValue(user).addOnCompleteListener {
                dialog.dismiss()
                tampilToast("Simpan Data Berhasil")
                bersihkanEditTexts()
            }
        }
    }

    fun ubahData() {
        btnUbah.setOnClickListener {
            val dialog: ProgressDialog = ProgressDialog(this);
            dialog.setMessage("Menyimpan")
            dialog.show()

            if (RSambal.isChecked) {
                tambahan = RSambal.text.toString()
            } else if (RSerundeng.isChecked) {
                tambahan = RSerundeng.text.toString()
            }

            val user: User = User(
                etId.text.toString(),
                etMenu.text.toString(),
                etHarga.text.toString(),
                etJumlah.text.toString(),
                tambahan
            )
            myRef.child(user.nopesanan).setValue(user).addOnCompleteListener {
                dialog.dismiss()
                tampilToast("Ubah Data Berhasil")
                bersihkanEditTexts()
            }
        }
    }

    fun hapusData() {
        btnHapus.setOnClickListener {
            val dialog: ProgressDialog = ProgressDialog(this);
            dialog.setMessage("Menyimpan")
            dialog.show()

            val nik: String = etId.text.toString()
            myRef.child(nik).removeValue().addOnCompleteListener {
                dialog.dismiss()
                tampilToast("Hapus Data Berhasil")
            }
        }
    }

    fun tampilData() {
        btnTampil.setOnClickListener(
            View.OnClickListener {
                val buffer = StringBuffer()
                myRef.addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onCancelled(snapshotError: DatabaseError) {
                    }
                    override fun onDataChange(snapshot: DataSnapshot) {
                        val children = snapshot.children
                        children.forEach {
                            val user: User = it.getValue(User::class.java)!!
                            buffer.append(
                                "NO PESANAN : " + user.nopesanan +
                                        "\n"
                            )
                            buffer.append(
                                "MENU : " + user.namamenu +
                                        "\n"
                            )
                            buffer.append(
                                "HARGA : " + user.harga +
                                        "\n"
                            )
                            buffer.append(
                                "JUMLAH : " + user.jumlah +
                                        "\n"
                            )
                            buffer.append(
                                "EXTRA TAMBAHAN : " + user.tambahan +
                                        "\n\n"
                            )
                        }
                            tampilDialog("Data Pesanan", buffer.toString())
                    }
                })
            }
        )
    }
        }

