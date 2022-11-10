package com.cdio.smart_farming_scp

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p2.*
import androidx.appcompat.app.AppCompatActivity as AppCompatActivity1
import android.util.Log
import androidx.annotation.NonNull
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_zonas_p1.*

class ZonasP2Activity : AppCompatActivity() {

    var p2=0
    var idz=0

    private val database = Firebase.database
    private var id_zona12 = database.getReference("USUARIO1/IDU1/IDZONAU12")
    private var id_zonaU1 = database.getReference("ID/IDBOTONZONA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p2)

        GlobalScope.launch {
            var myID = id_zona12.get().await().value as Long
            p2 = myID.toInt()

            runOnUiThread {
                botonmasP2.visibility = View.VISIBLE
                botonZona21.visibility = View.VISIBLE
                botonZona22.visibility = View.INVISIBLE
                botonZona23.visibility = View.INVISIBLE
                botonZona24.visibility = View.INVISIBLE

                if (p2 == 1) {
                    botonmasP2.visibility = View.VISIBLE
                    botonZona22.visibility = View.VISIBLE
                    botonZona23.visibility = View.INVISIBLE
                    botonZona24.visibility = View.INVISIBLE
                } else {
                    if (p2 == 2) {
                        botonmasP2.visibility = View.VISIBLE
                        botonZona22.visibility = View.VISIBLE
                        botonZona23.visibility = View.VISIBLE
                        botonZona24.visibility = View.INVISIBLE
                    } else {
                        if (p2 == 3) {
                            botonmasP2.visibility = View.VISIBLE
                            botonZona22.visibility = View.VISIBLE
                            botonZona23.visibility = View.VISIBLE
                            botonZona24.visibility = View.VISIBLE
                        }
                    }
                }

                botonmasP2.setOnClickListener {
                    when (p2) {
                        0 -> botonZona22.visibility = View.VISIBLE
                        1 -> botonZona23.visibility = View.VISIBLE
                        2 -> botonZona24.visibility = View.VISIBLE
                    }
                    if (p2 == 3) {
                        botonmasP2.visibility = View.INVISIBLE
                    } else {
                        botonmasP2.visibility = View.VISIBLE
                        p2++
                        if (p2 == 3) {
                            botonmasP2.visibility = View.INVISIBLE
                        }
                    }
                    id_zona12.setValue(p2)
                }
            }
        }

        botonZona21.setOnClickListener {
            idz = 1;
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP2Activity, ZonasActivity::class.java))
        }

        botonZona22.setOnClickListener {
            idz = 2
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP2Activity, ZonasActivity::class.java))
        }

        botonZona23.setOnClickListener {
            idz = 3
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP2Activity, ZonasActivity::class.java))
        }

        botonZona24.setOnClickListener {
            idz = 4
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP2Activity, ZonasActivity::class.java))
        }
    }
}