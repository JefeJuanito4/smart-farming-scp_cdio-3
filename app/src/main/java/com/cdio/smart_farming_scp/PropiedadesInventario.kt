package com.cdio.smart_farming_scp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.cdio.smart_farming_scp.databinding.PropiedadesInventarioBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class PropiedadesInventario : AppCompatActivity() {
    private val DT = Firebase.database
    private lateinit var binding: PropiedadesInventarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PropiedadesInventarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        val cantTotemb1: String? = bundle?.getString("TracimosEmbolsadosP1")
        binding.CantEmb1.text = cantTotemb1.toString()

        val cantTotcos1: String? = bundle?.getString("TracimosCultivadosP1")
        binding.CantCos1.text = cantTotcos1.toString()

        val cantTotemb2: String? = bundle?.getString("TracimosCultivadosP2")
        binding.CantEmb2.text = cantTotemb2.toString()

        val cantTotcos2: String? = bundle?.getString("TracimosCultivadosP2")
        binding.CantCos2.text = cantTotcos2.toString()

    }
}

