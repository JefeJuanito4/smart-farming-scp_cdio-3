package com.cdio.smart_farming_scp

import android.content.ContentValues.TAG
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.NonNull
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference

class PropiedadesActivity : AppCompatActivity() {

    var id: Int= 0

    private val database = Firebase.database
    private var id_propiedad = database.getReference("USUARIO1/IDU1/IDPROPIEDADU1")
    /**private val database = Firebase.database
    private val id_propiedad = database.getReference("IDPROPIEDAD")
    private lateinit var databaseref: DatabaseReference**/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propiedades)

        //databaseref = FirebaseDatabase.getInstance().getReference("IDPROPIEDAD")

        GlobalScope.launch {
            //var myID = id_propiedad.get().await().value
            //myID.
            //id = myID

            /**runOnUiThread {
            botonmas.visibility = View.INVISIBLE
            botonPropiedad2.visibility = View.VISIBLE
            botonPropiedad3.visibility = View.VISIBLE
            botonPropiedad4.visibility = View.VISIBLE
            }**/


            runOnUiThread {
                /**
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
                }**/

                botonmas.setOnClickListener {
                    /**if(id<3){
                    id++
                    }
                    id_propiedad.setValue(id)**/
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
                    id_propiedad.setValue(id)
                }
                }
            }

            botonPropiedad1.setOnClickListener {
                startActivity(Intent(this@PropiedadesActivity, ZonasP1Activity::class.java));
            }

            botonPropiedad2.setOnClickListener {
                startActivity(Intent(this@PropiedadesActivity, ZonasP2Activity::class.java));
            }

            botonPropiedad3.setOnClickListener {
                startActivity(Intent(this@PropiedadesActivity, ZonasP3Activity::class.java));
            }

            botonPropiedad4.setOnClickListener {
                startActivity(Intent(this@PropiedadesActivity, ZonasP4Activity::class.java));
            }

            //Setup
            val bundle: Bundle? = intent.extras
            val nombre: String? = bundle?.getString("email")
            txtnombre.text = nombre.toString()
        }
    }