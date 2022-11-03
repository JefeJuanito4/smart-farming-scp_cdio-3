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
import android.widget.EditText
import android.widget.Toast
import android.view.View

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

            //runOnUiThread {
                botonGuardarZonas.setOnClickListener {
                    // propiedad 1
                    if(idprop==1){
                        if(idzona==1){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados111.setValue(editTxtEmbolsados)
                                cultivados111.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados112.setValue(editTxtEmbolsados)
                                cultivados112.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados113.setValue(editTxtEmbolsados)
                                cultivados113.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados114.setValue(editTxtEmbolsados)
                                cultivados114.setValue(editTxtCultivados)
                            }
                        }
                    }
                    // propiedad 2
                    if(idprop==2){
                        if(idzona==1){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados121.setValue(editTxtEmbolsados)
                                cultivados121.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados122.setValue(editTxtEmbolsados)
                                cultivados122.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados123.setValue(editTxtEmbolsados)
                                cultivados123.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados124.setValue(editTxtEmbolsados)
                                cultivados124.setValue(editTxtCultivados)
                            }
                        }
                    }
                    //propiedad 3
                    if(idprop==3){
                        if(idzona==1){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados131.setValue(editTxtEmbolsados)
                                cultivados131.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados132.setValue(editTxtEmbolsados)
                                cultivados132.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados133.setValue(editTxtEmbolsados)
                                cultivados133.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados134.setValue(editTxtEmbolsados)
                                cultivados134.setValue(editTxtCultivados)
                            }
                        }
                    }
                    // propiedad 4
                    if(idprop==4){
                        if(idzona==1){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados141.setValue(editTxtEmbolsados)
                                cultivados141.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados142.setValue(editTxtEmbolsados)
                                cultivados142.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados143.setValue(editTxtEmbolsados)
                                cultivados143.setValue(editTxtCultivados)
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty()) {
                                embolsados144.setValue(editTxtEmbolsados)
                                cultivados144.setValue(editTxtCultivados)
                            }
                        }
                    }
                }
            //}
        }
    }
}