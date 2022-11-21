package com.cdio.smart_farming_scp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout

import com.cdio.smart_farming_scp.databinding.ActivityHomeBinding

import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.encabezado_menulateral.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.ArrayList


enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {


    private val db = Firebase.database//.reference

    private lateinit var binding: ActivityHomeBinding

    // se crea la variable con el tipo de objeto que representa
    //vamo a llorar
    //este es el ultimo commit del dia
    lateinit var texto_correo:TextView
    lateinit var texto_provider:TextView
    lateinit var outSession: MenuItem
    lateinit var  actividad_propiedades: MenuItem
    lateinit var  actividad_inventario: MenuItem
    lateinit var  actividad_calendario: MenuItem

    //VARIABLES QUE TRAEN LA INFO DE LA BASE DE DATOS
    var myID= ArrayList<String>()
    var racimosEMBOLSADOS = ArrayList<String>()
    var totalracCult = 409
    var totalracEmb = 1209
    var racimosCULTIVADOS = ArrayList<String>()
    var fechas= ArrayList<String>()

    //variables categoicas
    var usu = "USUARIO"
    var numusu = 1//2 //numero usuario
    var pros = "PROPIEDADES"
    var numpros = 1//2 //numero propiedades
    var pro = "PROPIEDAD"
    var numpro = 11//2 //numero propiedades
    var zon = "ZONA"
    var numzon = 111//3 //numero usuario
    var fech = "FECHAINV"
    var numfech = 111 //numero FECHAINV
    var numerofechas = 2 // variable que itera en los for <---------------------

    //Variables auxiliares
    var info = true // esta ---------------------> debo verificar si se han subido datos para llamar la info nueva.

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        while (info){
            llamarinfoDb()
            info = !info
        } // traigo la info de la bd
        traerInfo()
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navegadorLateral)
        //asignar la varriable local los valores de variable gloaal
        texto_correo=navView.getHeaderView(0).findViewById(R.id.texthome_correo)
        texto_provider=navView.getHeaderView(0).findViewById(R.id.texthome_provider)
        outSession=navView.menu.findItem(R.id.buttonOutSession)
        actividad_propiedades=navView.menu.findItem(R.id.activid_Propiedad)
        actividad_inventario=navView.menu.findItem(R.id.activid_inventario)
        actividad_calendario=navView.menu.findItem(R.id.activid_Calendario)


        //setup
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")
        //FUNCION QUE LLAMA LA INFO 1 VEZ, SI NO SE REAALIZAN CAMBIOS EN LA BD




    }


    //COMO CREAR NUEVAS ACTIVIDADES con los archivos .kt y xml:
    //1. Crear un archivo .kt,
    //#. en AndroidManifest se especifica que se creo la nueva actividad
    private fun setup(email: String, provider: String) {
        title = "Inicio"

        texto_correo.text = email
        texto_provider.text=provider

        // si se presiona algun boton del menu lateral sera remitido a la actividad correspondiente
        outSession.setOnMenuItemClickListener {
               FirebaseAuth.getInstance().signOut()
              onBackPressed()// este metodo en un futuro será obsoleto
              true
            //posible error
        }
        actividad_propiedades.setOnMenuItemClickListener{
            val homeIntent2 = Intent(this, PropiedadesActivity::class.java).apply {
                putExtra("email", email )
            }
            startActivity(homeIntent2)
            true
        }
        actividad_inventario.setOnMenuItemClickListener{
            val homeIntent2 = Intent(this, InventarioActivity::class.java).apply {
                putExtra("TracimosCultivados", totalracCult)
                putExtra("TracimosEmbolsados", totalracEmb )
            }
            startActivity(homeIntent2)
            true
        }
        actividad_calendario.setOnMenuItemClickListener{
            val homeIntent2 = Intent(this, CalendarioActivity::class.java).apply {
            }
            startActivity(homeIntent2)
            true
        }

    }

    private fun llamarinfoDb(){

        val Varint = arrayOf("EMBOLSADOS", "año",  "mes",  "dia", "CULTIVADOS","año","mes", "dia")//variablesInternas
        var i = 0

        var ruta: String

        //for para traer fechas del mes actual
//for (i in 1..10 step 3)
        /*for (j in 1..10) {
            for (x in 1..2) {
                if (x == 1) {
                    ruta = usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "/" + zon + numzon + "/" + fech + numfech + j + "/" + Varint[2] + numfech + j
                } else {
                    ruta = usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "/" + zon + numzon + "/" + fech + numfech + j + "/" + Varint[6]+ numfech + j + "cult"
                }

                 var id_CULT = db.getReference(ruta)

                GlobalScope.launch {
                    myID.add(id_CULT.get().await().value as String)


                    println(myID)
                }

            }
            println("   ")
        }*/


        //for (x in Varint.indices) {
        for (j in 1..numerofechas) {
            for (x in Varint) {
                if (i <= 4) {
                    ruta = usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "/" + zon + numzon + "/" + fech + numfech + j + "/" + x + numfech + j
                } else {
                    ruta = usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "/" + zon + numzon + "/" + fech + numfech + j + "/" + x + numfech + j + "cult"
                }
                println(ruta)

                var id_CULT = db.getReference(ruta)
                GlobalScope.launch {
                    myID.add(id_CULT.get().await().value as String)
                }
                i++
                if(i==8)i=0
            }
            println("   ")
        }
        println("Racimos toda la info2222222222222222222")
        for (i in myID.indices) {
            print("sdddddddddddddddddd: ")
            println(myID[i])

        }
    }

    private fun traerInfo(){
        /*firebaseDatabase = getInstance()
        databaseReference = firebaseDatabase?.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111")
        //database = getInstance().getReference("USUARIO1")
            //FirebaseDatabase.getInstance().getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111")
        val child = databaseReference?.child("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111")?.get()?.addOnSuccessListener {

        }*/
        estableccerFechas()
        println("Racimos toda la info")
        for (i in myID.indices) {
            print("sdddddddddddddddddd: ")
            println(myID[i])

        }
        println()
        println("Racimos embolsados")
        for (i in racimosEMBOLSADOS.indices) {
            print("sdddddddddddddddddd: ")
            println(racimosEMBOLSADOS[i])

        }
        println()
        println("Racimos cultivados")
        for (i in racimosCULTIVADOS.indices) {
            print("sdddddddddddddddddd: ")
            println(racimosCULTIVADOS[i])

        }
        println()
        println("FEchass")
        for (array in fechas) {
            for (value in array) {
                print(value)
            }
            println()
        }
    }

    private fun estableccerFechas() {
        var i=0
        for(g in myID.indices){
            if (i == 0) racimosEMBOLSADOS.add(myID[g])
            else if (i in 1..3)  fechas.add(myID[g])
            else if (i == 4) racimosCULTIVADOS.add(myID[g])
            else if (i in 5..7) fechas.add(myID[g])
            i++
            if(i==8)i=0
        }
        println("PFGHHHHHHHHHHHHHHHHHHHHHHHHH")
        //calendar.set(2022,11,22)
    }
}