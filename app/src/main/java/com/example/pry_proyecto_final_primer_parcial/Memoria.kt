package com.example.pry_proyecto_final_primer_parcial

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Memoria : AppCompatActivity() {
    //<editor-fold desc="Imagenes">
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
    //</editor-fold>

    //<editor-fold desc="Otros">
        lateinit var tv_j1: TextView
        lateinit var tv_j2: TextView
        lateinit var ib_sonido: ImageButton

        lateinit var mp: MediaPlayer
        lateinit var mp_fondo: MediaPlayer
        lateinit var ecuacion: TextView
        lateinit var resultado: TextView
    //</editor-fold>

    //<editor-fold desc="Variables">
        var cartasArray =
            arrayOf(11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26)
        var ecuacion1 = 0
        var ecuacion2 = 0
        var ecuacion3 = 0
        var ecuacion4 = 0
        var ecuacion5 = 0
        var ecuacion6 = 0

    var turno = 1
    var puntosj1 = 0
    var puntosj2 = 0
    var numeroImagen = 1 //cuàntas veces di click
    var escuchar = true
    //</editor-fold>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memoria)
        enlazarGUI()
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

        ib_sonido = findViewById(R.id.ib_sonido)
        ib_sonido.setColorFilter(Color.GREEN)
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

        ecuacion1 = R.drawable.tarjeta1
        ecuacion2 = R.drawable.tarjeta2
        ecuacion3 = R.drawable.tarjeta3
        ecuacion4 = R.drawable.tarjeta4
        ecuacion5 = R.drawable.tarjeta5
        ecuacion6 = R.drawable.tarjeta6

        cartasArray.shuffle()
        tv_j1.setTextColor(Color.GRAY)
        tv_j2.setTextColor(Color.WHITE)
    }
/*
    private fun sonido(sonidoName: String, loop: Boolean=false) {
        var resID = resources.getIdentifier(
            sonidoName, "raw", packageName
        )
        if (sonidoName == "fondo") {
            mp_fondo = MediaPlayer.create(this, resID)
            mp_fondo.isLooping = loop
            mp_fondo.setVolume(0.04F, 0.04F)
            if (!mp_fondo.isPlaying){
                mp_fondo.start()
            }
        } else {
            mp = MediaPlayer.create(this, resID)
            mp.setOnCompletionListener (MediaPlayer.OnCompletionListener {mediaPlayer ->
                mediaPlayer.stop()
                mediaPlayer.release()
            })
            if (!mp.isPlaying){
                mp.start()
            }
        }
    }*/
}