package com.example.pry_proyecto_final_primer_parcial

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Memoria : AppCompatActivity() {
    lateinit var iv_11: ImageView
    lateinit var iv_12: ImageView
    lateinit var iv_13: ImageView
    lateinit var iv_14: ImageView

    lateinit var iv_21: ImageView
    lateinit var iv_22: ImageView
    lateinit var iv_23: ImageView
    lateinit var iv_24: ImageView

    lateinit var iv_31: ImageView
    lateinit var iv_32: ImageView
    lateinit var iv_33: ImageView
    lateinit var iv_34: ImageView
    lateinit var ib_sonido: ImageButton
    lateinit var atras: ImageButton
    lateinit var imagen1: ImageView
    lateinit var imagen2: ImageView
    lateinit var mp: MediaPlayer
    lateinit var mp_fondo: MediaPlayer
    lateinit var ecuacion: TextView
    lateinit var resultado: TextView
    private var mpVictoria: MediaPlayer? = null
    private var mpClick: MediaPlayer? = null
    var cartasArray =
        arrayOf(11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26)
    var ecuacion1 = 0
    var ecuacion2 = 0
    var ecuacion3 = 0
    var ecuacion4 = 0
    var ecuacion5 = 0
    var ecuacion6 = 0
    var ecuacion7 = 0
    var ecuacion8 = 0
    var ecuacion9 = 0
    var ecuacion10 = 0
    var ecuacion11 = 0
    var ecuacion12 = 0



    var numeroImagen = 1
    var escuchar = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memoria)
        enlazarGUI()

        mpClick = MediaPlayer.create(this, R.raw.click)
        mpVictoria = MediaPlayer.create(this, R.raw.completado)
    }
    private fun enlazarGUI(){
        iv_11 = findViewById(R.id.iv_11)
        iv_12 = findViewById(R.id.iv_12)
        iv_13 = findViewById(R.id.iv_13)
        iv_14 = findViewById(R.id.iv_14)
        iv_21 = findViewById(R.id.iv_21)
        iv_22 = findViewById(R.id.iv_22)
        iv_23 = findViewById(R.id.iv_23)
        iv_24 = findViewById(R.id.iv_24)
        iv_31 = findViewById(R.id.iv_31)
        iv_32 = findViewById(R.id.iv_32)
        iv_33 = findViewById(R.id.iv_33)
        iv_34 = findViewById(R.id.iv_34)

        atras = findViewById(R.id.btn_back)

        //ib_sonido = findViewById(R.id.ib_sonido)
        //ib_sonido.setColorFilter(Color.GREEN)
        //sonido("fondo",true)

        //etiqueta para cartas
        iv_11.tag = "0"
        iv_12.tag = "1"
        iv_13.tag = "2"
        iv_14.tag = "3"
        iv_21.tag = "4"
        iv_22.tag = "5"
        iv_23.tag = "6"
        iv_24.tag = "7"
        iv_31.tag = "8"
        iv_32.tag = "9"
        iv_33.tag = "10"
        iv_34.tag = "11"

        ecuacion1 = R.drawable.r1
        ecuacion2 = R.drawable.r2
        ecuacion3 = R.drawable.r3
        ecuacion4 = R.drawable.r4
        ecuacion5 = R.drawable.r5
        ecuacion6 = R.drawable.r6

        ecuacion7 = R.drawable.s1
        ecuacion8 = R.drawable.s2
        ecuacion9 = R.drawable.s3
        ecuacion10 = R.drawable.s4
        ecuacion11 = R.drawable.s5
        ecuacion12 = R.drawable.s6



        atras.setOnClickListener(){
            finish()
        }
        cartasArray.shuffle()
        iv_11.setOnClickListener { seleccionar(it) }
        iv_12.setOnClickListener { seleccionar(it) }
        iv_13.setOnClickListener { seleccionar(it) }
        iv_14.setOnClickListener { seleccionar(it) }
        iv_21.setOnClickListener { seleccionar(it) }
        iv_22.setOnClickListener { seleccionar(it) }
        iv_23.setOnClickListener { seleccionar(it) }
        iv_24.setOnClickListener { seleccionar(it) }
        iv_31.setOnClickListener { seleccionar(it) }
        iv_32.setOnClickListener { seleccionar(it) }
        iv_33.setOnClickListener { seleccionar(it) }
        iv_34.setOnClickListener { seleccionar(it) }
    }
    fun seleccionar(imagen: View){

        verificar(imagen)
        mpClick?.start()
    }
    private fun verificar(imagen: View) {
        var iv = (imagen as ImageView)
        var tag = imagen.tag.toString().toInt()
        if (cartasArray[tag] == 11) {
            iv.setImageResource(ecuacion1)
            iv.contentDescription = "1"
        } else if (cartasArray[tag] == 12) {
            iv.setImageResource(ecuacion2)
            iv.contentDescription = "2"
        } else if (cartasArray[tag] == 13) {
            iv.setImageResource(ecuacion3)
            iv.contentDescription = "3"
        } else if (cartasArray[tag] == 14) {
            iv.setImageResource(ecuacion4)
            iv.contentDescription = "4"
        } else if (cartasArray[tag] == 15) {
            iv.setImageResource(ecuacion5)
            iv.contentDescription = "5"
        } else if (cartasArray[tag] == 16) {
            iv.setImageResource(ecuacion6)
            iv.contentDescription = "6"
        } else if (cartasArray[tag] == 21) {
            iv.setImageResource(ecuacion7)
            iv.contentDescription = "1"
        } else if (cartasArray[tag] == 22) {
            iv.setImageResource(ecuacion8)
            iv.contentDescription = "2"
        } else if (cartasArray[tag] == 23) {
            iv.setImageResource(ecuacion9)
            iv.contentDescription = "3"
        } else if (cartasArray[tag] == 24) {
            iv.setImageResource(ecuacion10)
            iv.contentDescription = "4"
        } else if (cartasArray[tag] == 25) {
            iv.setImageResource(ecuacion11)
            iv.contentDescription = "5"
        } else if (cartasArray[tag] == 26) {
            iv.setImageResource(ecuacion12)
            iv.contentDescription = "6"
        }
        if (numeroImagen == 1){
            imagen1 = iv
            numeroImagen = 2
            iv.isEnabled = false
        }else if (numeroImagen == 2){
            imagen2 = iv
            numeroImagen = 1
            iv.isEnabled = false
            deshabilitar()
            val h = Handler(Looper.getMainLooper())
            h.postDelayed({sonImagenesIguales()}, 1000)
        }

    }

    private fun sonImagenesIguales() {
        if (imagen1.contentDescription == imagen2.contentDescription){
            imagen1.visibility = View.INVISIBLE
            imagen2.visibility = View.INVISIBLE
            imagen1.isEnabled = false
            imagen2.isEnabled = false
            imagen1.tag = ""
            imagen2.tag = ""
        }else{
            imagen1.setImageResource(R.drawable.tarjeta)
            imagen2.setImageResource(R.drawable.tarjeta)
        }
        iv_11.isEnabled = !iv_11.tag.toString().isEmpty()
        iv_12.isEnabled = !iv_12.tag.toString().isEmpty()
        iv_13.isEnabled = !iv_13.tag.toString().isEmpty()
        iv_14.isEnabled = !iv_14.tag.toString().isEmpty()
        iv_21.isEnabled = !iv_21.tag.toString().isEmpty()
        iv_22.isEnabled = !iv_22.tag.toString().isEmpty()
        iv_23.isEnabled = !iv_23.tag.toString().isEmpty()
        iv_24.isEnabled = !iv_24.tag.toString().isEmpty()
        iv_31.isEnabled = !iv_31.tag.toString().isEmpty()
        iv_32.isEnabled = !iv_32.tag.toString().isEmpty()
        iv_33.isEnabled = !iv_33.tag.toString().isEmpty()
        iv_34.isEnabled = !iv_34.tag.toString().isEmpty()
        verificarFin()
    }

    private fun verificarFin() {
        if (iv_11.visibility == View.INVISIBLE &&
            iv_12.visibility == View.INVISIBLE &&
            iv_13.visibility == View.INVISIBLE &&
            iv_14.visibility == View.INVISIBLE &&
            iv_21.visibility == View.INVISIBLE &&
            iv_22.visibility == View.INVISIBLE &&
            iv_23.visibility == View.INVISIBLE &&
            iv_24.visibility == View.INVISIBLE &&
            iv_31.visibility == View.INVISIBLE &&
            iv_32.visibility == View.INVISIBLE &&
            iv_33.visibility == View.INVISIBLE &&
            iv_34.visibility == View.INVISIBLE
        ){
            //victoria
            mostrarPopupVictoria()
        }

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
    private fun deshabilitar(){
        iv_11.isEnabled = false
        iv_12.isEnabled = false
        iv_13.isEnabled = false
        iv_14.isEnabled = false
        iv_21.isEnabled = false
        iv_22.isEnabled = false
        iv_23.isEnabled = false
        iv_24.isEnabled = false
        iv_31.isEnabled = false
        iv_32.isEnabled = false
        iv_33.isEnabled = false
        iv_34.isEnabled = false
    }
}