package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p1.*
import kotlinx.android.synthetic.main.activity_zonas_p2.*

class ZonasP2Activity : AppCompatActivity() {

    var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p2)

        botonZona21.setOnClickListener {
            startActivity(Intent(this@ZonasP2Activity, zonasActivity::class.java));
        }

        botonmasP2.setOnClickListener{
            when (i){
                0 -> botonZona22.visibility = View.VISIBLE
                1 -> botonZona23.visibility = View.VISIBLE
                2 -> botonZona24.visibility = View.VISIBLE
            }
            i++
            if(i==3){
                botonmasP2.visibility = View.INVISIBLE
            }else{
                botonmasP2.visibility = View.VISIBLE
            }
        }
    }
}