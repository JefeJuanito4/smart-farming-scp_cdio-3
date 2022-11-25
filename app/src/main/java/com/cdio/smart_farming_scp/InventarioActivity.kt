package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cdio.smart_farming_scp.databinding.ActivityInventarioBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_inventario.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class InventarioActivity : AppCompatActivity() {

    private val database = Firebase.database
    private lateinit var binding: ActivityInventarioBinding
    private val db = Firebase.database//.reference
    private var id_propiedad1cul = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/P1TotalCultivados")
    private var id_propiedad1emb = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/P1TotalEmbolsados")
    private var id_propiedad1culP2 = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/P2TotalCultivados")
    private var id_propiedad1embP2 = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/P2TotalEmbolsados")
    var lanzar = false
    var local = ""
    var local2 = ""
    var local3 = ""
    var local4 = ""

    var totalracCultP1 = ""
    var totalracEmbP1 = ""
    var totalracCultP2 = ""
    var totalracEmbP2 = ""


        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            binding = ActivityInventarioBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)


            val bundle: Bundle? = intent.extras
            /*val totalracCultP1: String? = bundle?.getString("totalracCultP1")
            val totalracEmbP1: String? = bundle?.getString("totalracEmbP1")
            val totalracCultP2: String? = bundle?.getString("totalracCultP2")
            val totalracEmbP2: String? = bundle?.getString("totalracEmbP2")*/
            GlobalScope.launch {
                local = id_propiedad1cul.get().await().value as String
                local2 = id_propiedad1emb.get().await().value as String
                local3 = id_propiedad1culP2.get().await().value as String
                local4 = id_propiedad1embP2.get().await().value as String
            }


            setup( )


        }

        private fun setup() {


            binding.ButtonPropInv.setOnClickListener {
                val intent1 =
                    Intent(this@InventarioActivity, PropiedadesInventario::class.java).apply {
                        imprimir ()
                        putExtra("TracimosCultivadosP1", totalracCultP1)
                        putExtra("TracimosEmbolsadosP1", totalracEmbP1)
                        putExtra("TracimosCultivadosP2", totalracCultP2)
                        putExtra("TracimosEmbolsadosP2", totalracEmbP2)
                    }
                startActivity(intent1)

            }
            binding.ButtonInfInv.setOnClickListener {
                val intent3 = Intent(this@InventarioActivity, InformeInventario::class.java).apply {
                    imprimir ()
                    putExtra("TracimosCultivadosP1", totalracCultP1)
                    putExtra("TracimosCultivadosP2", totalracCultP2)
                }
                startActivity(intent3)
            }

            binding.ButtonEstaInv.setOnClickListener {
                val intent2 = Intent(this, EstadisticaInventario::class.java).apply {
                    imprimir ()
                    //putExtra("TracimosCultivadosP1", totalracCultP1)
                    //putExtra("TracimosEmbolsadosP1", totalracEmbP1)
                    //putExtra("TracimosCultivadosP2", totalracCultP2)
                    // putExtra("TracimosEmbolsadosP2", totalracEmbP2)
                }
                startActivity(intent2)

            }
        }

    private fun imprimir (){
        PRUEBA.setText(local)
        totalracCultP1 = local.toString()
        totalracEmbP1 =local2
        totalracCultP2 = local3
        totalracEmbP2 = local4

        println("jueputaaaaaaaaaaaa:  " + totalracCultP1)
        println("")
        println("jueputaaaaaaaaaaaa:  " + totalracEmbP1)
    }

}
