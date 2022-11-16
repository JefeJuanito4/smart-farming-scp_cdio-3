package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class CalendarioActivity : AppCompatActivity() {
    // on below line we are creating
    // variables for text view and calendar view

    private val db = Firebase.database
    lateinit var dateTV: TextView
    lateinit var calendarView: CalendarView
    private var id_propiedad1 = db.getReference("USUARIO1/IDU1/IDPROPIEDADU1")
    private var id_plaemb = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/CONTCULTIVADOS111")
    private var plaemb = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendario)

        // initializing variables of
        // list view with their ids.
        dateTV = findViewById(R.id.idTVDate)
        calendarView = findViewById(R.id.calendarView)


        GlobalScope.launch {
            var myID = id_propiedad1.get().await().value as Long
            var plaemb = id_plaemb.get().await().value as Long
            println("HOLAaaaaaaaaaaaaaaa ${myID}myID")
            println(myID)

        }
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
                })

        sumar4meses( )



    }

    private fun sumar4meses(dia: String, mes: String, annio: String){
     var totaldias = dia.toInt() + (mes.toInt()*30) + (annio.toInt()*365)
        var aRecol = totaldias
    }
}