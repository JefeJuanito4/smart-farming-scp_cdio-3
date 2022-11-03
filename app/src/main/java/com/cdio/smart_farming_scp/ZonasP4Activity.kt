package com.cdio.smart_farming_scp

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_zonas_p3.*
import kotlinx.android.synthetic.main.activity_zonas_p4.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ZonasP4Activity : AppCompatActivity() {

    var p4=0
    var idz=0

    private val database = Firebase.database
    private var id_zona14 = database.getReference("USUARIO1/IDU1/IDZONAU14")
    private var id_zonaU1 = database.getReference("USUARIO1/IDU1/ID/IDBOTONZONA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p4)

        GlobalScope.launch {
            var myID = id_zona14.get().await().value as Long
            p4 = myID.toInt()

            runOnUiThread {
                botonmasP4.visibility = View.VISIBLE
                botonZona41.visibility = View.VISIBLE
                botonZona42.visibility = View.INVISIBLE
                botonZona43.visibility = View.INVISIBLE
                botonZona44.visibility = View.INVISIBLE

                if (p4 == 1) {
                    botonmasP4.visibility = View.VISIBLE
                    botonZona42.visibility = View.VISIBLE
                    botonZona43.visibility = View.INVISIBLE
                    botonZona44.visibility = View.INVISIBLE
                } else {
                    if (p4 == 2) {
                        botonmasP4.visibility = View.VISIBLE
                        botonZona42.visibility = View.VISIBLE
                        botonZona43.visibility = View.VISIBLE
                        botonZona44.visibility = View.INVISIBLE
                    } else {
                        if (p4 == 3) {
                            botonmasP4.visibility = View.VISIBLE
                            botonZona42.visibility = View.VISIBLE
                            botonZona43.visibility = View.VISIBLE
                            botonZona44.visibility = View.VISIBLE
                        }
                    }
                }

                botonmasP4.setOnClickListener {
                    when (p4) {
                        0 -> botonZona42.visibility = View.VISIBLE
                        1 -> botonZona43.visibility = View.VISIBLE
                        2 -> botonZona44.visibility = View.VISIBLE
                    }
                    if (p4 == 3) {
                        botonmasP4.visibility = View.INVISIBLE
                    } else {
                        botonmasP4.visibility = View.VISIBLE
                        p4++
                        if (p4 == 3) {
                            botonmasP4.visibility = View.INVISIBLE
                        }
                    }
                    id_zona14.setValue(p4)
                }
            }
        }

        botonZona41.setOnClickListener {
            idz = 1
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP4Activity, ZonasActivity::class.java))
        }

        botonZona42.setOnClickListener {
            idz = 2
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP4Activity, ZonasActivity::class.java))
        }

        botonZona43.setOnClickListener {
            idz = 3
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP4Activity, ZonasActivity::class.java))
        }

        botonZona44.setOnClickListener {
            idz = 4
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP4Activity, ZonasActivity::class.java))
        }
    }
}