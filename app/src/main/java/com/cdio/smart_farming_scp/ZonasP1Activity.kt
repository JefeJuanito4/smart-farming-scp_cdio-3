package com.cdio.smart_farming_scp

import android.content.Intent;
import android.os.Bundle
import android.view.View
import com.cdio.smart_farming_scp.databinding.ActivityPropiedadesBinding
import com.cdio.smart_farming_scp.databinding.ActivityZonasP1Binding
import kotlinx.android.synthetic.main.activity_propiedades.*
import kotlinx.android.synthetic.main.activity_zonas_p1.*
import androidx.appcompat.app.AppCompatActivity as AppCompatActivity1
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ZonasP1Activity: AppCompatActivity1() {

    private lateinit var binding: ActivityZonasP1Binding

    var p1=0
    var idz=0

    private val database = Firebase.database
    private var id_zona11 = database.getReference("USUARIO1/IDU1/IDZONAU11")
    private var id_zonaU1 = database.getReference("ID/IDBOTONZONA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZonasP1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        GlobalScope.launch {
            var myID = id_zona11.get().await().value as Long
            p1 = myID.toInt()

            runOnUiThread {
                botonmasP1.visibility = View.VISIBLE
                botonZona11.visibility = View.VISIBLE
                botonZona12.visibility = View.INVISIBLE
                botonZona13.visibility = View.INVISIBLE

                if (p1 == 1) {
                    botonmasP1.visibility = View.VISIBLE
                    botonZona12.visibility = View.VISIBLE
                    botonZona13.visibility = View.INVISIBLE
                } else {
                    if (p1 == 2) {
                        botonmasP1.visibility = View.VISIBLE
                        botonZona12.visibility = View.VISIBLE
                        botonZona13.visibility = View.VISIBLE
                    }
                }

                binding.botonmasP1.setOnClickListener{
                    when (p1){
                        0 -> botonZona12.visibility = View.VISIBLE
                        1 -> botonZona13.visibility = View.VISIBLE
                    }
                    if (p1 == 2) {
                        botonmasP1.visibility = View.INVISIBLE
                    } else {
                        botonmasP1.visibility = View.VISIBLE
                        p1++
                        if (p1== 2) {
                            botonmasP1.visibility = View.INVISIBLE
                        }
                    }
                    id_zona11.setValue(p1)
                }
            }
        }

        binding.botonZona11.setOnClickListener {
            idz = 1;
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP1Activity, ZonasActivity::class.java))
        }

        binding.botonZona12.setOnClickListener {
            idz = 2
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP1Activity, ZonasActivity::class.java))
        }

        binding.botonZona13.setOnClickListener {
            idz = 3
            id_zonaU1.setValue(idz)
            startActivity(Intent(this@ZonasP1Activity, ZonasActivity::class.java))
        }
    }
}