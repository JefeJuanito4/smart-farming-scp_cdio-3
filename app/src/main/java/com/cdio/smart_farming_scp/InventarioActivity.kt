package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cdio.smart_farming_scp.databinding.ActivityInventarioBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class InventarioActivity : AppCompatActivity(){

    private val database = Firebase.database
    private lateinit var binding: ActivityInventarioBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityInventarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ButtonPropInv.setOnClickListener{
            startActivity (Intent( this@InventarioActivity, PropiedadesInventario ::class.java))
        }

        binding.ButtonInfInv.setOnClickListener{
            startActivity (Intent ( this@InventarioActivity, InformeInventario::class.java))

        }

        binding.ButtonEstaInv.setOnClickListener{
            startActivity(Intent ( this@InventarioActivity, EstadisticaInventario::class.java))

        }

        }
    }