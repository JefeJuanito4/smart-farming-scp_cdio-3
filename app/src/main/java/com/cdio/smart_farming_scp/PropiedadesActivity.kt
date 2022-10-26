package com.cdio.smart_farming_scp

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_propiedades.*

class PropiedadesActivity : AppCompatActivity() {

    val idp1=1
    val idp2=2
    val idp3=3
    val idp4=4
    var i=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_propiedades)

        val db = FirebaseFirestore.getInstance()

        botonPropiedad1.setOnClickListener {
            startActivity(Intent(this@PropiedadesActivity, ZonasP1Activity::class.java));
        }

        botonmas.setOnClickListener{
            when (i){
                0 -> botonPropiedad2.visibility = View.VISIBLE
                1 -> botonPropiedad3.visibility = View.VISIBLE
                2 -> botonPropiedad4.visibility = View.VISIBLE
            }
            i++
            if(i==3){
                botonmas.visibility = View.INVISIBLE
            }else{
                botonmas.visibility = View.VISIBLE
            }
        }

        botonPropiedad2.setOnClickListener{
            startActivity(Intent(this@PropiedadesActivity,ZonasP2Activity::class.java));
        }

        botonPropiedad3.setOnClickListener{
            startActivity(Intent(this@PropiedadesActivity,ZonasP3Activity::class.java));
        }

        botonPropiedad4.setOnClickListener{
            startActivity(Intent(this@PropiedadesActivity,ZonasP4Activity::class.java));
        }

        //Setup
        val bundle: Bundle? = intent.extras
        val nombre: String? = bundle?.getString("email")
        txtnombre.text = nombre.toString()
        }
    }