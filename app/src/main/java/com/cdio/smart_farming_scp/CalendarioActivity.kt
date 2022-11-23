package com.cdio.smart_farming_scp


import android.os.Build


import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView

import androidx.annotation.RequiresApi
//import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase.*

import com.cdio.smart_farming_scp.databinding.ActivityCalendarioBinding

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.text.SimpleDateFormat
import java.util.*


class CalendarioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCalendarioBinding
    // on below line we are creating
    // variables for text view and calendar view

    private val db = Firebase.database//.reference
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    lateinit var calendar: Calendar
    var myID= ArrayList<String>()
    var racimosEMBOLSADOS = ArrayList<String>()
    var racimosCULTIVADOS = ArrayList<String>()
    var fechas=ArrayList<String>()



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


    //Variables auxiliares
    var info = true // esta ---------------------> debo verificar si se han subido datos para llamar la info nueva.



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCalendarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // initializing variables of
        // list view with their ids.
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)

        calendarView.setDate(1669397846 )//1668965846

        val formatter2 = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        val fechaactual = formatter2.format(date)
        dateTV.setText(fechaactual)//muestro la fecha actual
        val mesActual = SimpleDateFormat("MM",Locale.getDefault()).format(Date())
        //calendar.set(2022,11,22)

        println(mesActual)
        println("   ")

        while (info){
            llamarinfoDb()
            info = !info
        } // traigo la info de la bd
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
        var i=0
        for(g in myID.indices){
            if (i == 0) racimosEMBOLSADOS.add(myID[g])
            else if (i in 1..3)  fechas.add(myID[g])
            else if (i == 4) racimosCULTIVADOS.add(myID[g])
            else if (i in 5..7) fechas.add(myID[g])
            i++
            if(i==8)i=0


        }
        //calendar.set(2022,11,22)
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
                //println(ruta)

                var id_CULT = db.getReference(ruta)
                GlobalScope.launch {
                    myID.add(id_CULT.get().await().value as String)
                }
                i++
                if(i==8)i=0
            }
            println("   ")
        }
        for (i in myID.indices) {
            print("sdddddddddDDFFFGGGGdddd: ")
            println(myID[i])

        }

    }
    private fun sumar4meses(dia: String, mes: String, annio: String){

        var totaldias = dia.toInt() + (mes.toInt()*30) + (annio.toInt()*365)

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

}

