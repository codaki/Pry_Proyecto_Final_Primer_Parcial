package com.example.pry_proyecto_final_primer_parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var bingo:Button
    lateinit var memoria:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bingo = findViewById(R.id.BotonBingo)
    }
}