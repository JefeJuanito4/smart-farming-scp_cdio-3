package com.cdio.smart_farming_scp

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p1.*
import androidx.appcompat.app.AppCompatActivity as AppCompatActivity1

class ZonasP1Activity: AppCompatActivity1() {

    var p1=0

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas_p1)
        botonZona12.visibility = View.INVISIBLE
        botonZona13.visibility = View.INVISIBLE
        botonZona14.visibility = View.INVISIBLE



        botonmasP1.setOnClickListener{
            when (p1){
                0 -> botonZona12.visibility = View.VISIBLE
                1 -> botonZona13.visibility = View.VISIBLE
                2 -> botonZona14.visibility = View.VISIBLE
            }
            p1++
            if(p1==3){
                botonmasP1.visibility = View.INVISIBLE
            }else{
                botonmasP1.visibility = View.VISIBLE
            }
        }
    }
}

