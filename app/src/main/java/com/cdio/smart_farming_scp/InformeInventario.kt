package com.cdio.smart_farming_scp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cdio.smart_farming_scp.databinding.FragmentInformeInventarioBinding

class InformeInventario : AppCompatActivity() {
    private lateinit var binding: FragmentInformeInventarioBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = FragmentInformeInventarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}
