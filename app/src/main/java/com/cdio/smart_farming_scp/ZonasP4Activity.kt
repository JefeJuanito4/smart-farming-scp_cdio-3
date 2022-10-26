package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p1.*
import kotlinx.android.synthetic.main.activity_zonas_p4.*

class ZonasP4Activity : AppCompatActivity() {

    var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p4)

        botonZona41.setOnClickListener {
            startActivity(Intent(this@ZonasP4Activity, zona41Activity::class.java));
        }

        botonmasP4.setOnClickListener{
            when (i){
                0 -> botonZona42.visibility = View.VISIBLE
                1 -> botonZona43.visibility = View.VISIBLE
                2 -> botonZona44.visibility = View.VISIBLE
            }
            i++
            if(i==3){
                botonmasP4.visibility = View.INVISIBLE
            }else{
                botonmasP4.visibility = View.VISIBLE
            }
        }

        botonZona42.setOnClickListener{
            startActivity(Intent(this@ZonasP4Activity,zona42Activity::class.java));
        }

        botonZona43.setOnClickListener{
            startActivity(Intent(this@ZonasP4Activity,zona43Activity::class.java));
        }

        botonZona44.setOnClickListener{
            startActivity(Intent(this@ZonasP4Activity,zona44Activity::class.java));
        }

    }
}