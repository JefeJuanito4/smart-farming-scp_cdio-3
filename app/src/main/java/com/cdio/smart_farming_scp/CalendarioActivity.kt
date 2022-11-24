package com.cdio.smart_farming_scp


import android.content.Intent
import android.os.Build


import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.CalendarView
import android.widget.CalendarView.OnDateChangeListener
import android.widget.TextView


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
    lateinit var mascerccana:TextView
    lateinit var cerccana:TextView
    lateinit var pococerccana:TextView
    lateinit var calendarView: CalendarView


    val inforbd: MutableList<String> = ArrayList()


    var totalembolsados = 0
    var totalcultivados = 0
    var myID = ArrayList<String>()
    var racimosEMBOLSADOS = ArrayList<String>()
    var racimosCULTIVADOS = ArrayList<String>()
    var fechas = ArrayList<String>()


    //variables categoicas
    var usu = "USUARIO"
    var numusu = 1//2 //numero usuario
    var pros = "PROPIEDADES"
    var numpros = 1//2 //numero propiedades
    var pro = "PROPIEDAD"
    var numpro = 11//2 //numero propiedades
    var zon = "ZONA"
    var numzon = 11//3 //numero usuario
    var numzonas = 3
    var fech = "FECHAINV"
    var numfech = 111 //numero FECHAINV
    var numerofechas = 10 // variable que itera en los for
    var pesoKilo = 20


    //Variables auxiliares
    var info = 0 // esta ---------------------> debo verificar si se han subido datos para llamar la info nueva.


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCalendarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // initializing variables of
        // list view with their ids.
        dateTV = findViewById(R.id.idTVDate)
        mascerccana = findViewById(R.id.editTextverde)
        cerccana = findViewById(R.id.editTextamarillo)
        pococerccana = findViewById(R.id.editTextrojo)
        calendarView = findViewById(R.id.calendarView)


        //calendarView.setDate(1669397846)//1668965846

        val formatter2 = SimpleDateFormat("yyyy-MM-dd")
        val date = Date()
        val fechaactual = formatter2.format(date)
        dateTV.setText(fechaactual)//muestro la fecha actual
        val mesActual = SimpleDateFormat("MM", Locale.getDefault()).format(Date())
        val diaActual = SimpleDateFormat("dd", Locale.getDefault()).format(Date())
        //calendar.set(2022,11,22)

        while (info<3) {
            println("awslllllllllllllllllllllllll" + info)
            if(info == 0){ llamarinfoDb()
                traerInfo(diaActual, mesActual)
                println("awslllllllllllllllllllggggggggggggggg" + info)
            }
            else {traerInfo(diaActual, mesActual)
                println("him hrte")
            }
            info++
        } // traigo la info de la bd



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
                    traerInfo(diaActual, mesActual)
                    //llamarinfoDb()


                })


        //sumar4meses( )
        val intent = Intent(this@CalendarioActivity, HomeActivity::class.java)
        intent.putExtra("P1totalEnbolsados", totalembolsados)
        intent.putExtra("P1totalCultivados", totalcultivados)


    }

    private fun estableccerFechas(diaActual: String, mesActual: String) {
        var i = 0
        var j = 0
        for (g in myID.indices) {
            if (i == 0) {
                if(myID[g] == "2022")racimosEMBOLSADOS.add(myID[g-1])
                else racimosEMBOLSADOS.add(myID[g])
            }
            else if (i in 1..3) {
                fechas.add(myID[g])

                var mesproximo =0
if(i==2){
     mesproximo = myID[g].toInt() + 4
    if(mesproximo > 12) mesproximo = 11
    println("mes proximo 22222222222 = " + mesproximo)
}

         /*       if(mesproximo > 16) mesproximo = 11

                println("mes proximo = " + mesproximo)
                if (i ==2 &&  mesproximo >=12){
                var mesproxannio =0

                    mesproximo = mesproximo - 12
                    var anniopromimo = 2023
                }*/



                    var internoshoy = 0
                var internosmanana = 0
                var internospasadomanana = 0

                    if(mesproximo.toString() == mesActual.toString() && i==2){//&& j==1
                    var diasproximos = diaActual.toInt() +1

                    if(diaActual == myID[g+1] ){
                        var fechaponida = ""

                        //if(c==0)  fechaponida = myID[c] +"racimosssss" + fechas[c-1] +"-"+fechas[c]+"-"+fechas[c+1]

                        if(myID[g-2] == "2022"){
                            internoshoy += myID[g-1].toInt()
                            fechaponida = "Hoy " +internoshoy +" racimos (" + myID[g-2].toInt()*pesoKilo + " Kg aprox) "//+ myID[g-1] +"-"+myID[g]+"-"+myID[g+1]
                            mascerccana.setText( fechaponida)
                        }
                        else{
                            internoshoy += myID[g-2].toInt()
                        fechaponida = "Hoy " +internoshoy +" racimos (" + myID[g-2].toInt()*pesoKilo + " Kg aprox) "//+ myID[g-1] +"-"+myID[g]+"-"+myID[g+1]
                        mascerccana.setText( fechaponida)}}


                    else if(diasproximos.toString() == myID[g+1] ){
                        var fechaponida = ""
                        fechaponida = "Mañana " + myID[g-2] +" racimos (" + myID[g-2].toInt()*pesoKilo + " Kg aprox) "//+ myID[g-1] +"-"+myID[g]+"-"+myID[g+1]
                        cerccana.setText( fechaponida)}

                    else if((diasproximos+1).toString() == myID[g+1] ){
                        var fechaponida = ""
                        fechaponida = myID[g-2] +" racimos (" + myID[g-2].toInt()*20 + " Kg aprox) "+myID[g+1]+"-"+myID[g] +"-"+ myID[g-1]
                        pococerccana.setText( fechaponida)}

                }

            }
            else if (i == 4) racimosCULTIVADOS.add(myID[g])
            else if (i in 5..7) fechas.add(myID[g])
            i++
            if (i == 8) i = 0



        }

        /*for(c in fechas.indices){
            if(mesActual.toString() == fechas[c].toString() && j==1){//&& j==1
                if(diaActual == fechas[c+1] ){
                    var fechaponida = ""
                    //if(c==0)  fechaponida = myID[c] +"racimosssss" + fechas[c-1] +"-"+fechas[c]+"-"+fechas[c+1]
                    fechaponida = myID[c] +"racimosssss" + fechas[c-1] +"-"+fechas[c]+"-"+fechas[c+1]
                    //else  fechaponida = myID[c*8] +"racimosssss" + fechas[c-1] +"-"+fechas[c]+"-"+fechas[c+1]

                    mascerccana.setText( fechaponida)
                }
            }
            j++
            if (j == 6) j = 0
        }*/
        //calendar.set(2022,11,22)
    }

    private fun llamarinfoDb() {


        val Varint = arrayOf(
            "EMBOLSADOS",
            "año",
            "mes",
            "dia",
            "CULTIVADOS",
            "año",
            "mes",
            "dia"
        )//variablesInternas
        var i = 0

        var ruta: String

       /*  ruta = usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "/" + zon + numzon + "/" + fech + numfech + 1 + "/" + Varint[6]+ numfech + 1 + "cult"
        println(ruta)

        var id_CULT = db.getReference(ruta)

        GlobalScope.launch {
            myID.add((id_CULT.get().await().value as Long).toString())

            println(ninj)
        }*/

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
        for(h in 1..numzonas) {
            for (j in 1..numerofechas) {
                for (x in Varint) {
                    if (i <= 4) {
                        ruta =
                            usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "/" + zon + numzon + h +"/" + fech  + numzon + h + j + "/" + x   + numzon + h + j
                    } else {
                        ruta =
                            usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "/" + zon + numzon + h + "/" + fech  + numzon+ h + j + "/" + x   + numzon + h + j + "cult"
                    }
                    println(ruta)

                    var id_CULT = db.getReference(ruta)
                    GlobalScope.launch {
                        myID.add(id_CULT.get().await().value as String)
                        inforbd.add(id_CULT.get().await().value as String)
                        //= id_CULT.get().await().value as String
                    }
                    i++
                    if (i == 8) i = 0
                }
                println("   ")
            }
        }

    }
    private fun sumar4meses(mes: String): Int {

        var mesproximo = mes.toInt() + 4
        var mesproxannio =0
        if(mesproximo >12){
            mesproximo = mesproximo - 12
            var anniopromimo = 2023
        }

return mesproximo
    }

    private fun traerInfo(diaActual: String, mesActual: String){
        /*firebaseDatabase = getInstance()
        databaseReference = firebaseDatabase?.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111")
        //database = getInstance().getReference("USUARIO1")
            //FirebaseDatabase.getInstance().getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111")
        val child = databaseReference?.child("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111")?.get()?.addOnSuccessListener {

        }*/
        estableccerFechas(diaActual, mesActual)

        println()
        println()
        println("Toda la info")
        for (i in inforbd.indices) {
            print("sdddddddddddddddddd: ")
            println(inforbd[i])

        }
        println("Racimos embolsados")
        for (i in racimosEMBOLSADOS.indices) {
            totalembolsados += racimosEMBOLSADOS[i].toInt()
            print("sdddddddddddddddddd: ")
            println(racimosEMBOLSADOS[i])
        }
        println("---------------> Total cultivados: " + totalembolsados)
        println()
        println("Racimos cultivados")
        for (i in racimosCULTIVADOS.indices) {
            totalcultivados += racimosCULTIVADOS[i].toInt()
            print("sdddddddddddddddddd: ")
            println(racimosCULTIVADOS[i])

        }
        println("---------------> Total cultivados: " + totalcultivados)
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

