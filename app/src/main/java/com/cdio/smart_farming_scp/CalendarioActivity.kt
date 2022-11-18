package com.cdio.smart_farming_scp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.google.android.gms.safetynet.SafetyNetApi.VerifyAppsUserResponse
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.FirebaseDatabase.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*


class CalendarioActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for text view and calendar view

    private val db = Firebase.database//.reference
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    lateinit var calendar: Calendar
    var myID= ArrayList<String>()
    val rows = 10
    val cols = 4

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
    var numerofechas = 2 // variable que itera en los for

    val arr = Array(rows) { IntArray(cols) }

    private lateinit var database: FirebaseDatabase

    private var databaseReference: DatabaseReference? = null
    private var firebaseDatabase: FirebaseDatabase? = null



    private var plaemb = 0


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        // initializing variables of
        // list view with their ids.
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)

        var asf = calendarView.setDate(2333-22-22)

        val formatter2 = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        val fechaactual = formatter2.format(date)
        dateTV.setText(fechaactual)//muestro la fecha actual
        val mesActual = SimpleDateFormat("MM",Locale.getDefault()).format(Date())


        println(mesActual)
        println("   ")
        llamarinfoDb() // traigo la info de la bd
        estableccerFechas()

        // on below line we are adding set on
        // date change listener for calendar view.
        calendarView
            .setOnDateChangeListener(
                OnDateChangeListener { view, year, month, dayOfMonth ->
                    // In this Listener we are getting values
                    // such as year, month and day of month
                    // on below line we are creating a variable
                    // in which we are adding all the variables in it.
                    val Date = (dayOfMonth.toString() + "-"
                            + (month + 1) + "-" + year)

                    // set this date in TextView for Display
                    dateTV.setText(Date)
                    traerInfo()
                    //llamarinfoDb()


                })

        //sumar4meses( )



    }

    private fun estableccerFechas() {
        for(g in 1..numerofechas){

        }
    }

    private fun llamarinfoDb(){



        val Varint = arrayOf("EMBOLSADOS", "año",  "mes",  "dia", "CULTIVADOS","año","mes", "dia")//variablesInternas
        var i = 0
        var ruta: String

        var cantidades = arrayOf(0)
        val info = ArrayList<String>()


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
                    println(myID)
                }
                i++
                if(i==8)i=0
            }
            println("   ")
        }
        println("jueputaaaaaaaaaaaaaaaaaaaaaaa")
        for (i in myID.indices) {
            print("sdddddddddddddddddd: ")
            println(myID[i])

        }


    }
    private fun sumar4meses(dia: String, mes: String, annio: String){

        var totaldias = dia.toInt() + (mes.toInt()*30) + (annio.toInt()*365)
        var aRecol = totaldias
    }

    private fun traerInfo(){
        /*firebaseDatabase = getInstance()
        databaseReference = firebaseDatabase?.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111")
        //database = getInstance().getReference("USUARIO1")
            //FirebaseDatabase.getInstance().getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111")
        val child = databaseReference?.child("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111")?.get()?.addOnSuccessListener {

        }*/

        println("jueputaaaaaaaaaaaaaaaaaaaaaaa")
        for (i in myID.indices) {
            print("sdddddddddddddddddd: ")
            println(myID[i])

        }
    }

}

