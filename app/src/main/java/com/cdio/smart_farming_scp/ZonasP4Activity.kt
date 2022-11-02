package com.cdio.smart_farming_scp

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_zonas_p4.*

class ZonasP4Activity : AppCompatActivity() {

    var p4=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p4)
        botonZona41.visibility = View.VISIBLE
        botonZona42.visibility = View.INVISIBLE
        botonZona43.visibility = View.INVISIBLE
        botonZona44.visibility = View.INVISIBLE

        val database = Firebase.database
        var id_zona14 = database.getReference("USUARIO1/IDU1/IDZONAU14")

        botonZona41.setOnClickListener {
            startActivity(Intent(this@ZonasP4Activity, ZonasActivity::class.java));
        }

        botonmasP4.setOnClickListener{
            when (p4){
                0 -> botonZona42.visibility = View.VISIBLE
                1 -> botonZona43.visibility = View.VISIBLE
                2 -> botonZona44.visibility = View.VISIBLE
            }
            if (p4 == 3) {
                botonmasP4.visibility = View.INVISIBLE
            } else {
                botonmasP4.visibility = View.VISIBLE
                p4++
                if (p4== 3) {
                    botonmasP4.visibility = View.INVISIBLE
                }
            }
            id_zona14.setValue(p4)
        }
    }
}