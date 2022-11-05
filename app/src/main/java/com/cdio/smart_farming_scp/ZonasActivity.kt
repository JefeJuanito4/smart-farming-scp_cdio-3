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


    // fecha usuario 1
    // propiedad 1
    private var dia111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/dia111")
    private var mes111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/mes111")
    private var año111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/año111")
    private var dia112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/dia112")
    private var mes112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/mes112")
    private var año112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/año112")
    private var dia113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/dia113")
    private var mes113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/mes113")
    private var año113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/año113")
    private var dia114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/dia114")
    private var mes114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/mes114")
    private var año114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/año114")
    // propiedad 2
    private var dia121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/dia121")
    private var mes121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/mes121")
    private var año121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/año121")
    private var dia122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/dia122")
    private var mes122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/mes122")
    private var año122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/año122")
    private var dia123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/dia123")
    private var mes123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/mes123")
    private var año123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/año123")
    private var dia124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA124/dia124")
    private var mes124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA124/mes124")
    private var año124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA124/año124")
    // propiedad 3
    private var dia131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA131/dia131")
    private var mes131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA131/mes131")
    private var año131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA131/año131")
    private var dia132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA132/dia132")
    private var mes132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA132/mes132")
    private var año132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA132/año132")
    private var dia133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA133/dia133")
    private var mes133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA133/mes133")
    private var año133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA133/año133")
    private var dia134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA134/dia134")
    private var mes134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA134/mes134")
    private var año134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD13/ZONA134/año134")
    // propiedad 4
    private var dia141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA141/dia141")
    private var mes141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA141/mes141")
    private var año141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA141/año141")
    private var dia142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA142/dia142")
    private var mes142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA142/mes142")
    private var año142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA142/año142")
    private var dia143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA143/dia143")
    private var mes143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA143/mes143")
    private var año143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA143/año143")
    private var dia144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA144/dia144")
    private var mes144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA144/mes144")
    private var año144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD14/ZONA144/año144")

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
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados111.setValue(editTxtEmbolsados.text.toString())
                                cultivados111.setValue(editTxtCultivados.text.toString())
                                dia111.setValue(editTxtDia.text.toString())
                                mes111.setValue(editTxtMes.text.toString())
                                año111.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados112.setValue(editTxtEmbolsados.text.toString())
                                cultivados112.setValue(editTxtCultivados.text.toString())
                                dia112.setValue(editTxtDia.text.toString())
                                mes112.setValue(editTxtMes.text.toString())
                                año112.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados113.setValue(editTxtEmbolsados.text.toString())
                                cultivados113.setValue(editTxtCultivados.text.toString())
                                dia113.setValue(editTxtDia.text.toString())
                                mes113.setValue(editTxtMes.text.toString())
                                año113.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados114.setValue(editTxtEmbolsados.text.toString())
                                cultivados114.setValue(editTxtCultivados.text.toString())
                                dia114.setValue(editTxtDia.text.toString())
                                mes114.setValue(editTxtMes.text.toString())
                                año114.setValue(editTxtAño.text.toString())
                            }
                        }
                    }
                    // propiedad 2
                    if(idprop==2){
                        if(idzona==1){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados121.setValue(editTxtEmbolsados.text.toString())
                                cultivados121.setValue(editTxtCultivados.text.toString())
                                dia121.setValue(editTxtDia.text.toString())
                                mes121.setValue(editTxtMes.text.toString())
                                año121.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados122.setValue(editTxtEmbolsados.text.toString())
                                cultivados122.setValue(editTxtCultivados.text.toString())
                                dia122.setValue(editTxtDia.text.toString())
                                mes122.setValue(editTxtMes.text.toString())
                                año122.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados123.setValue(editTxtEmbolsados.text.toString())
                                cultivados123.setValue(editTxtCultivados.text.toString())
                                dia123.setValue(editTxtDia.text.toString())
                                mes123.setValue(editTxtMes.text.toString())
                                año123.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados124.setValue(editTxtEmbolsados.text.toString())
                                cultivados124.setValue(editTxtCultivados.text.toString())
                                dia124.setValue(editTxtDia.text.toString())
                                mes124.setValue(editTxtMes.text.toString())
                                año124.setValue(editTxtAño.text.toString())
                            }
                        }
                    }
                    //propiedad 3
                    if(idprop==3){
                        if(idzona==1){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados131.setValue(editTxtEmbolsados.text.toString())
                                cultivados131.setValue(editTxtCultivados.text.toString())
                                dia131.setValue(editTxtDia.text.toString())
                                mes131.setValue(editTxtMes.text.toString())
                                año131.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados132.setValue(editTxtEmbolsados.text.toString())
                                cultivados132.setValue(editTxtCultivados.text.toString())
                                dia132.setValue(editTxtDia.text.toString())
                                mes132.setValue(editTxtMes.text.toString())
                                año132.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados133.setValue(editTxtEmbolsados.text.toString())
                                cultivados133.setValue(editTxtCultivados.text.toString())
                                dia133.setValue(editTxtDia.text.toString())
                                mes133.setValue(editTxtMes.text.toString())
                                año133.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados134.setValue(editTxtEmbolsados.text.toString())
                                cultivados134.setValue(editTxtCultivados.text.toString())
                                dia134.setValue(editTxtDia.text.toString())
                                mes134.setValue(editTxtMes.text.toString())
                                año134.setValue(editTxtAño.text.toString())
                            }
                        }
                    }
                    // propiedad 4
                    if(idprop==4){
                        if(idzona==1){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados141.setValue(editTxtEmbolsados.text.toString())
                                cultivados141.setValue(editTxtCultivados.text.toString())
                                dia141.setValue(editTxtDia.text.toString())
                                mes141.setValue(editTxtMes.text.toString())
                                año141.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==2){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados142.setValue(editTxtEmbolsados.text.toString())
                                cultivados142.setValue(editTxtCultivados.text.toString())
                                dia142.setValue(editTxtDia.text.toString())
                                mes142.setValue(editTxtMes.text.toString())
                                año142.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==3){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados143.setValue(editTxtEmbolsados.text.toString())
                                cultivados143.setValue(editTxtCultivados.text.toString())
                                dia143.setValue(editTxtDia.text.toString())
                                mes143.setValue(editTxtMes.text.toString())
                                año143.setValue(editTxtAño.text.toString())
                            }
                        }
                        if(idzona==4){
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                embolsados144.setValue(editTxtEmbolsados.text.toString())
                                cultivados144.setValue(editTxtCultivados.text.toString())
                                dia144.setValue(editTxtDia.text.toString())
                                mes144.setValue(editTxtMes.text.toString())
                                año144.setValue(editTxtAño.text.toString())
                            }
                        }
                    }
                }
            //}
        }
    }
}