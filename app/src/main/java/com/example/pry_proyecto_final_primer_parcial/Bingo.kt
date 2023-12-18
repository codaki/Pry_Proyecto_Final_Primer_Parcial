package com.example.pry_proyecto_final_primer_parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.ProgressBar

class Bingo : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bingo)

        progressBar = findViewById(R.id.progressBar)

        // Mostrar ProgressBar
        progressBar.visibility = View.VISIBLE

        // Girar la imagen usando una animación
        val rotation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        imageView.startAnimation(rotation)

        // Ocultar el ProgressBar después de 3 segundos
        Handler().postDelayed({
            progressBar.visibility = View.GONE
            imageView.clearAnimation()
        }, 3000)
    }
}