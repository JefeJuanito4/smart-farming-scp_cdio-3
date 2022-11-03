package com.cdio.smart_farming_scp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_zonas.*
import kotlinx.android.synthetic.main.activity_zonas.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ZonasActivity : AppCompatActivity() {

    var idprop=0
    var idzona=0

    private val database = Firebase.database
    // ID
    private var id_botonprop = database.getReference("ID/IDBOTONPROPIEDAD")
    private var id_botonzona = database.getReference("ID/IDBOTONZONA")
    // usuario 1
    // propiedad 1
    private var cultivados111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/CULTIVADOS111")
    private var embolsados111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/EMBOLSADOS111")
    private var cultivados112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/CULTIVADOS112")
    private var embolsados112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/EMBOLSADOS112")
    private var cultivados113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/CULTIVADOS113")
    private var embolsados113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/EMBOLSADOS113")
    private var cultivados114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/CULTIVADOS114")
    private var embolsados114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/EMBOLSADOS114")
    // propiedad 2
    private var cultivados121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/CULTIVADOS121")
    private var embolsados121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/EMBOLSADOS121")
    private var cultivados122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/CULTIVADOS122")
    private var embolsados122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/EMBOLSADOS122")
    private var cultivados123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/CULTIVADOS123")
    private var embolsados123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/EMBOLSADOS123")
    private var cultivados124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA124/CULTIVADOS124")
    private var embolsados124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA124/EMBOLSADOS124")
    // propiedad 3
    private var cultivados131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA131/CULTIVADOS131")
    private var embolsados131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA131/EMBOLSADOS131")
    private var cultivados132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA132/CULTIVADOS132")
    private var embolsados132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA132/EMBOLSADOS132")
    private var cultivados133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA133/CULTIVADOS133")
    private var embolsados133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA133/EMBOLSADOS133")
    private var cultivados134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA134/CULTIVADOS134")
    private var embolsados134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA134/EMBOLSADOS134")
    // propiedad 4
    private var cultivados141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA141/CULTIVADOS141")
    private var embolsados141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA141/EMBOLSADOS141")
    private var cultivados142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA142/CULTIVADOS142")
    private var embolsados142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA142/EMBOLSADOS142")
    private var cultivados143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA143/CULTIVADOS143")
    private var embolsados143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA143/EMBOLSADOS143")
    private var cultivados144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA144/CULTIVADOS144")
    private var embolsados144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA144/EMBOLSADOS144")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas)

        GlobalScope.launch {
            var dbIDprop = id_botonprop.get().await().value as Long
            var dbIDzona = id_botonzona.get().await().value as Long
            idprop = dbIDprop.toInt()
            idzona = dbIDzona.toInt()

            runOnUiThread {
                botonGuardarZonas.setOnClickListener {
                    if(idprop==1){
                        if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                            editTxtEmbolsados.text.
                        }
                    }
                }
            }
        }
    }
}