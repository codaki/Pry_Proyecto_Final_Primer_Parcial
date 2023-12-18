package com.example.pry_proyecto_final_primer_parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnSalir : ImageButton
    private lateinit var btnBingo : ImageButton
    private lateinit var btnMemoria : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnSalir = findViewById(R.id.btn_Salir)
        btnBingo = findViewById(R.id.btn_Bingo)
        btnMemoria = findViewById(R.id.btn_Memoria)
        btnSalir.setOnClickListener {
            finish()
        }
        btnBingo.setOnClickListener {
            Intent (this, Bingo::class.java).also {
                startActivity(it)
            }
        }
        btnMemoria.setOnClickListener {
            Intent (this, Memoria::class.java).also {
                startActivity(it)
            }
        }
    }
}