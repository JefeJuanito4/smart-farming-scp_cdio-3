package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cdio.smart_farming_scp.databinding.ActivityInventarioBinding



class InventarioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInventarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInventarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val bundle: Bundle? = intent.extras
        val totalracCultP1: String? = bundle?.getString("totalracCultP1")
        val totalracEmbP1: String? = bundle?.getString("totalracEmbP1")
        val totalracCultP2: String? = bundle?.getString("totalracCultP2")
        val totalracEmbP2: String? = bundle?.getString("totalracEmbP2")

        setup(totalracCultP1 ?: "", totalracEmbP1 ?: "", totalracCultP2 ?: "", totalracEmbP2 ?: "")


    }

    private fun setup(totalracCultP1: String, totalracEmbP1: String, totalracCultP2: String, totalracEmbP2: String) {


        binding.ButtonPropInv.setOnClickListener {
            val intent1 = Intent(this@InventarioActivity, PropiedadesInventario::class.java).apply {
                putExtra("TracimosCultivadosP1", totalracCultP1)
                putExtra("TracimosEmbolsadosP1", totalracEmbP1)
                putExtra("TracimosCultivadosP2", totalracCultP2)
                putExtra("TracimosEmbolsadosP2", totalracEmbP2)
            }
            startActivity(intent1)

        }
            binding.ButtonInfInv.setOnClickListener {
                val intent3 = Intent(this@InventarioActivity, InformeInventario::class.java).apply{
                    putExtra("TracimosCultivadosP1", totalracCultP1)
                    putExtra("TracimosCultivadosP2", totalracCultP2)
                }
                startActivity(intent3)
            }

            binding.ButtonEstaInv.setOnClickListener {
                val intent2 = Intent(this, EstadisticaInventario::class.java).apply {
                        //putExtra("TracimosCultivadosP1", totalracCultP1)
                        //putExtra("TracimosEmbolsadosP1", totalracEmbP1)
                        //putExtra("TracimosCultivadosP2", totalracCultP2)
                       // putExtra("TracimosEmbolsadosP2", totalracEmbP2)
                    }
                startActivity(intent2)

            }
    }
}