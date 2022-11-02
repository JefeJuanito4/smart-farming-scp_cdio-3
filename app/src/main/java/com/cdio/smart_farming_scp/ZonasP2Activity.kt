package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p1.*
import kotlinx.android.synthetic.main.activity_zonas_p2.*

class ZonasP2Activity : AppCompatActivity() {

    var p2=0

    //private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p2)
        botonZona21.visibility = View.VISIBLE
        botonZona22.visibility = View.INVISIBLE
        botonZona23.visibility = View.INVISIBLE
        botonZona24.visibility = View.INVISIBLE

        botonmasP2.setOnClickListener{
            when (p2){
                0 -> botonZona22.visibility = View.VISIBLE
                1 -> botonZona23.visibility = View.VISIBLE
                2 -> botonZona24.visibility = View.VISIBLE
            }
            p2++
            if(p2==3){
                botonmasP2.visibility = View.INVISIBLE
            }else{
                botonmasP2.visibility = View.VISIBLE
            }
        }
    }
}