package com.cdio.smart_farming_scp

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class PropiedadesActivity : AppCompatActivity() {

    var id= 0
    var idp=0

    private val database = Firebase.database
    private var id_propiedad1 = database.getReference("USUARIO1/IDU1/IDPROPIEDADU1")
    private var id_botonpropiedad = database.getReference("ID/IDBOTONPROPIEDAD")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propiedades)

        GlobalScope.launch {
            var myID = id_propiedad1.get().await().value as Long
            id = myID.toInt()

            runOnUiThread {
                botonmas.visibility = View.VISIBLE
                botonPropiedad2.visibility = View.INVISIBLE
                botonPropiedad3.visibility = View.INVISIBLE
                botonPropiedad4.visibility = View.INVISIBLE

                if (id == 1) {
                    botonmas.visibility = View.VISIBLE
                    botonPropiedad2.visibility = View.VISIBLE
                    botonPropiedad3.visibility = View.INVISIBLE
                    botonPropiedad4.visibility = View.INVISIBLE
                } else {
                    if (id == 2) {
                        botonmas.visibility = View.VISIBLE
                        botonPropiedad2.visibility = View.VISIBLE
                        botonPropiedad3.visibility = View.VISIBLE
                        botonPropiedad4.visibility = View.INVISIBLE
                    } else {
                        if (id == 3) {
                            botonmas.visibility = View.INVISIBLE
                            botonPropiedad2.visibility = View.VISIBLE
                            botonPropiedad3.visibility = View.VISIBLE
                            botonPropiedad4.visibility = View.VISIBLE
                        }
                    }
                }

                botonmas.setOnClickListener {
                    when (id) {
                        0 -> botonPropiedad2.visibility = View.VISIBLE
                        1 -> botonPropiedad3.visibility = View.VISIBLE
                        2 -> botonPropiedad4.visibility = View.VISIBLE
                        else -> {
                            botonPropiedad2.visibility = View.VISIBLE
                            botonPropiedad3.visibility = View.VISIBLE
                            botonPropiedad4.visibility = View.VISIBLE
                            botonmas.visibility = View.INVISIBLE
                        }
                    }
                    if (id == 3) {
                        botonmas.visibility = View.INVISIBLE
                    } else {
                        botonmas.visibility = View.VISIBLE
                        id++
                        if (id == 3) {
                            botonmas.visibility = View.INVISIBLE
                        }
                    }
                    id_propiedad1.setValue(id)
                }
            }
        }

        botonPropiedad1.setOnClickListener {
            idp = 1;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP1Activity::class.java));
        }

        botonPropiedad2.setOnClickListener {
            idp = 2;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP2Activity::class.java));
        }

        botonPropiedad3.setOnClickListener {
            idp = 3;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP3Activity::class.java));
        }

        botonPropiedad4.setOnClickListener {
            idp = 4;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP4Activity::class.java));
        }

        //Setup
        val bundle: Bundle? = intent.extras
        val nombre: String? = bundle?.getString("email")
        txtnombre.text = nombre.toString()
    }
}