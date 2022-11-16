package com.cdio.smart_farming_scp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cdio.smart_farming_scp.databinding.FragmentPropiedadesInventarioBinding


class PropiedadesInventario : AppCompatActivity() {

    private lateinit var binding: FragmentPropiedadesInventarioBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = FragmentPropiedadesInventarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }


    }