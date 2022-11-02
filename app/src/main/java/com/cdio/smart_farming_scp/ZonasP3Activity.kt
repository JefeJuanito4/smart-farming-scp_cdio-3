package com.cdio.smart_farming_scp

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p3.*
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

class ZonasP3Activity : AppCompatActivity() {

    var p3=0

    private val database = Firebase.database
    private var id_zona13 = database.getReference("USUARIO1/IDU1/IDZONAU13")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p3)
        botonZona31.visibility = View.VISIBLE
        botonZona32.visibility = View.INVISIBLE
        botonZona33.visibility = View.INVISIBLE
        botonZona34.visibility = View.INVISIBLE

        botonmasP3.setOnClickListener{
            when (p3){
                0 -> botonZona32.visibility = View.VISIBLE
                1 -> botonZona33.visibility = View.VISIBLE
                2 -> botonZona34.visibility = View.VISIBLE
            }
            if (p3 == 3) {
                botonmasP3.visibility = View.INVISIBLE
            } else {
                botonmasP3.visibility = View.VISIBLE
                p3++
                if (p3== 3) {
                    botonmasP3.visibility = View.INVISIBLE
                }
            }
            id_zona13.setValue(p3)
        }
    }
}