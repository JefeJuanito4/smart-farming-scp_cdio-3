package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p1.*
import kotlinx.android.synthetic.main.activity_zonas_p3.*

class ZonasP3Activity : AppCompatActivity() {

    var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p3)

        botonZona31.setOnClickListener {
            startActivity(Intent(this@ZonasP3Activity, zona31Activity::class.java));
        }

        botonmasP3.setOnClickListener{
            when (i){
                0 -> botonZona32.visibility = View.VISIBLE
                1 -> botonZona33.visibility = View.VISIBLE
                2 -> botonZona34.visibility = View.VISIBLE
            }
            i++
            if(i==3){
                botonmasP3.visibility = View.INVISIBLE
            }else{
                botonmasP3.visibility = View.VISIBLE
            }
        }

        botonZona32.setOnClickListener{
            startActivity(Intent(this@ZonasP3Activity,zona32Activity::class.java));
        }

        botonZona33.setOnClickListener{
            startActivity(Intent(this@ZonasP3Activity,zona33Activity::class.java));
        }

        botonZona34.setOnClickListener{
            startActivity(Intent(this@ZonasP3Activity,zona34Activity::class.java));
        }
    }
}