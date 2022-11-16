package com.cdio.smart_farming_scp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cdio.smart_farming_scp.databinding.ActivityMensajesBinding


class MensajesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMensajesBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMensajesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}