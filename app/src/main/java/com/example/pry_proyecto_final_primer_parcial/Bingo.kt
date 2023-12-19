package com.example.pry_proyecto_final_primer_parcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    private lateinit var lblEcuacion : TextView

    private lateinit var matrizOriginal: Array<Array<Int>>
    private lateinit var matrizResultados: Array<Array<Int>>
    private lateinit var matrizRestas: Array<Array<Int>>
    private lateinit var matrizRestasString: Array<Array<String>>



    private var posicionActual = Pair(0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bingo)

        lblNum1 = findViewById(R.id.num_1)
        lblNum2 = findViewById(R.id.num_2)
        lblNum3 = findViewById(R.id.num_3)
        lblNum4 = findViewById(R.id.num_4)
        lblNum5 = findViewById(R.id.num_5)
        lblNum6 = findViewById(R.id.num_6)
        lblNum7 = findViewById(R.id.num_7)
        lblNum8 = findViewById(R.id.num_8)
        lblNum9 = findViewById(R.id.num_9)

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
                "${matrizRestas[i][j]} - ${matrizResultados[i][j]}"
            }
        }

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

    fun check(){

    }

}