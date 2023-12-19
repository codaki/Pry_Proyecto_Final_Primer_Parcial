package com.example.pry_proyecto_final_primer_parcial

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnSalir : ImageButton
    private lateinit var btnBingo : ImageButton
    private lateinit var btnMemoria : ImageButton
    private var mediaPlayerFondo: MediaPlayer? = null
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
        mediaPlayerFondo = MediaPlayer.create(this, R.raw.fondo)

        // Configura para repetir en bucle
        mediaPlayerFondo?.isLooping = true

        // Ajusta el volumen (rango de 0.0 a 1.0)
        mediaPlayerFondo?.setVolume(0.2f, 0.2f) // Ajusta según lo bajo que quieras el volumen

        // Inicia la reproducción
        mediaPlayerFondo?.start()
    }
    override fun onDestroy() {
        super.onDestroy()
        // Asegúrate de liberar los recursos del MediaPlayer
        mediaPlayerFondo?.release()
    }
}