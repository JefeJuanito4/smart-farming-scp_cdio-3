package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_zonas_p1.*
import kotlinx.android.synthetic.main.activity_zonas_p3.*

class ZonasP3Activity : AppCompatActivity() {

    var p3=0

    //private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p3)
        botonZona31.visibility = View.VISIBLE
        botonZona32.visibility = View.INVISIBLE
        botonZona33.visibility = View.INVISIBLE
        botonZona34.visibility = View.INVISIBLE

        /**botonZona31.setOnClickListener {
            startActivity(Intent(this@ZonasP3Activity, zonasActivity::class.java));
        }**/

        botonmasP3.setOnClickListener{
            when (p3){
                0 -> botonZona32.visibility = View.VISIBLE
                1 -> botonZona33.visibility = View.VISIBLE
                2 -> botonZona34.visibility = View.VISIBLE
            }
            p3++
            if(p3==3){
                botonmasP3.visibility = View.INVISIBLE
            }else{
                botonmasP3.visibility = View.VISIBLE
            }
        }
    }
}