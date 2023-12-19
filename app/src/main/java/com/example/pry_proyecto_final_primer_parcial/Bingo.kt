package com.example.pry_proyecto_final_primer_parcial

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class Bingo : AppCompatActivity() {
    private lateinit var lblNum1 : TextView
    private lateinit var lblNum2 : TextView
    private lateinit var lblNum3 : TextView
    private lateinit var lblNum4 : TextView
    private lateinit var lblNum5 : TextView
    private lateinit var lblNum6 : TextView
    private lateinit var lblNum7 : TextView
    private lateinit var lblNum8 : TextView
    private lateinit var lblNum9 : TextView

    private lateinit var lblRevisado11 : TextView
    private lateinit var lblRevisado12 : TextView
    private lateinit var lblRevisado13 : TextView
    private lateinit var lblRevisado21 : TextView
    private lateinit var lblRevisado22 : TextView
    private lateinit var lblRevisado23 : TextView
    private lateinit var lblRevisado31 : TextView
    private lateinit var lblRevisado32 : TextView
    private lateinit var lblRevisado33 : TextView

    private lateinit var lblEcuacion : TextView
    private lateinit var bolaColor : ImageView

    private lateinit var matrizOriginal: Array<Array<Int>>
    private lateinit var matrizResultados: Array<Array<Int>>
    private lateinit var matrizRestas: Array<Array<Int>>
    private lateinit var matrizRestasString: Array<Array<String>>
    private lateinit var posicionesVistas : Array<Array<Boolean>>

    private var posicionActual = Pair(0, 0)
    private var mpVictoria: MediaPlayer? = null
    private var mpClick: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bingo)
        mpClick = MediaPlayer.create(this, R.raw.click)
        mpVictoria = MediaPlayer.create(this, R.raw.completado)

        lblNum1 = findViewById(R.id.num_1)
        lblNum2 = findViewById(R.id.num_2)
        lblNum3 = findViewById(R.id.num_3)
        lblNum4 = findViewById(R.id.num_4)
        lblNum5 = findViewById(R.id.num_5)
        lblNum6 = findViewById(R.id.num_6)
        lblNum7 = findViewById(R.id.num_7)
        lblNum8 = findViewById(R.id.num_8)
        lblNum9 = findViewById(R.id.num_9)

        bolaColor = findViewById(R.id.bola_color)
        lblEcuacion = findViewById(R.id.intercambiable)

        val numeros1 = (1..20).toList().shuffled()
        val numeros2 = (1..20).toList().shuffled()

        matrizOriginal = Array(3) { i ->
            Array(3) { j ->
                numeros1[i * 3 + j]
            }
        }
        matrizRestas = Array(3) { i ->
            Array(3) { j ->
                numeros2[i * 3 + j]
            }
        }

        matrizResultados = Array(3) { i ->
            Array(3) { j ->
                matrizOriginal[i][j] + matrizRestas[i][j]
            }
        }

        matrizRestasString = Array(3) { i ->
            Array(3) { j ->
                "${matrizResultados[i][j]} - ${matrizRestas[i][j]}"
            }
        }

        posicionesVistas = Array(3) { i ->
            Array(3) { j ->
                false
            }
        }

        cambiarPosicionActual()

        lblNum1.text = matrizOriginal[0][0].toString()
        lblNum2.text = matrizOriginal[0][1].toString()
        lblNum3.text = matrizOriginal[0][2].toString()
        lblNum4.text = matrizOriginal[1][0].toString()
        lblNum5.text = matrizOriginal[1][1].toString()
        lblNum6.text = matrizOriginal[1][2].toString()
        lblNum7.text = matrizOriginal[2][0].toString()
        lblNum8.text = matrizOriginal[2][1].toString()
        lblNum9.text = matrizOriginal[2][2].toString()
    }

    fun cambiarPosicionActual(){
        val num1 = Random.nextInt(0, 3)
        val num2 = Random.nextInt(0, 3)

        if (posicionesVistas.all { fila -> fila.all { it } }) {
            mostrarPopupVictoria()
            lblEcuacion.text = "¡Ganaste!"
            return
        }

        while (posicionesVistas[num1][num2]){
            cambiarPosicionActual()
            return
        }
        posicionActual = Pair(num1, num2)
        lblEcuacion.text = matrizRestasString[num1][num2]
    }

    private fun generarNumeroAleatorio(): Int {
        return Random.nextInt(1, 5) // Genera un número aleatorio entre 1 y 4
    }

    fun check(v: View){
        val button = findViewById<TextView>(v.id)
        val hint = button.hint.toString()
        println(hint)
        val num1 = hint.split(" ")[0].toInt()
        val num2 = hint.split(" ")[1].toInt()

        if (num1 == posicionActual.first && num2 == posicionActual.second){
            posicionesVistas[num1][num2] = true
            button.text = "✓"
            val drawable = resources.getDrawable(R.drawable.tacha, null)
            button.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, null, null, null)
            cambiarPosicionActual()
            val color = generarNumeroAleatorio()
            when (color) {
                1 -> {
                    bolaColor.setImageResource(R.drawable.bolaroja)
                }

                2 -> {
                    bolaColor.setImageResource(R.drawable.bolaamarilla)
                }

                3 -> {
                    bolaColor.setImageResource(R.drawable.bolaazul)
                }

                4 -> {
                    bolaColor.setImageResource(R.drawable.bolarosa)
                }
            }
            lblEcuacion.text = matrizRestasString[posicionActual.first][posicionActual.second]
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }
        mpClick?.start()
    }

    fun mostrarPopupVictoria() {
        val mDialog = Dialog(this)
        mDialog.setContentView(R.layout.popup_victoria)
        mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val buttonJugarDeNuevo = mDialog.findViewById<Button>(R.id.btn_jugar_de_nuevo)
        val buttonSalir = mDialog.findViewById<Button>(R.id.btn_Salir)

        buttonJugarDeNuevo.setOnClickListener {
            mDialog.dismiss()
            recreate()
        }

        buttonSalir.setOnClickListener {
            finish()
        }
        mpVictoria?.start()
        mDialog.show()
        mDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Asegúrate de liberar los recursos del MediaPlayer
        mpClick?.release()
        mpVictoria?.release()
    }

    fun salir(v: View){
        finish()
    }
}