package com.cdio.smart_farming_scp

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cdio.smart_farming_scp.databinding.ActivityPropiedadesBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class PropiedadesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPropiedadesBinding

    var id= 0
    var idp=0

    private val database = Firebase.database
    private var id_propiedad1 = database.getReference("USUARIO1/IDU1/IDPROPIEDADU1")
    private var id_botonpropiedad = database.getReference("ID/IDBOTONPROPIEDAD")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropiedadesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        GlobalScope.launch {
            var myID = id_propiedad1.get().await().value as Long
            id = myID.toInt()

            runOnUiThread {
                binding.botonmas.visibility = View.VISIBLE
               binding.botonPropiedad2.visibility = View.INVISIBLE
               binding.botonPropiedad3.visibility = View.INVISIBLE
               binding.botonPropiedad4.visibility = View.INVISIBLE

                if (id == 1) {
                   binding.botonmas.visibility = View.VISIBLE
                   binding.botonPropiedad2.visibility = View.VISIBLE
                   binding.botonPropiedad3.visibility = View.INVISIBLE
                   binding.botonPropiedad4.visibility = View.INVISIBLE
                } else {
                    if (id == 2) {
                      binding.botonmas.visibility = View.VISIBLE
                     binding.botonPropiedad2.visibility = View.VISIBLE
                       binding.botonPropiedad3.visibility = View.VISIBLE
                       binding.botonPropiedad4.visibility = View.INVISIBLE
                    } else {
                        if (id == 3) {
                           binding.botonmas.visibility = View.INVISIBLE
                           binding.botonPropiedad2.visibility = View.VISIBLE
                           binding.botonPropiedad3.visibility = View.VISIBLE
                           binding.botonPropiedad4.visibility = View.VISIBLE
                        }
                    }
                }

               binding.botonmas.setOnClickListener {
                    when (id) {
                        0 -> binding.botonPropiedad2.visibility = View.VISIBLE
                        1 ->  binding.botonPropiedad3.visibility = View.VISIBLE
                        2 ->  binding.botonPropiedad4.visibility = View.VISIBLE
                        else -> {
                            binding.botonPropiedad2.visibility = View.VISIBLE
                            binding.botonPropiedad3.visibility = View.VISIBLE
                            binding.botonPropiedad4.visibility = View.VISIBLE
                            binding.botonmas.visibility = View.INVISIBLE
                        }
                    }
                    if (id == 3) {
                        binding.botonmas.visibility = View.INVISIBLE
                    } else {
                        binding.botonmas.visibility = View.VISIBLE
                        id++
                        if (id == 3) {
                            binding.botonmas.visibility = View.INVISIBLE
                        }
                    }
                    id_propiedad1.setValue(id)
                }
            }
        }

        binding.botonPropiedad1.setOnClickListener {
            idp = 1;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP1Activity::class.java));
        }

        binding.botonPropiedad2.setOnClickListener {
            idp = 2;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP2Activity::class.java));
        }

        binding.botonPropiedad3.setOnClickListener {
            idp = 3;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP3Activity::class.java));
        }

        binding.botonPropiedad4.setOnClickListener {
            idp = 4;
            id_botonpropiedad.setValue(idp)
            startActivity(Intent(this@PropiedadesActivity, ZonasP4Activity::class.java));
        }

        //Setup
        val bundle: Bundle? = intent.extras
        val nombre: String? = bundle?.getString("email")
        binding.txtnombre.text = nombre.toString()
    }
}