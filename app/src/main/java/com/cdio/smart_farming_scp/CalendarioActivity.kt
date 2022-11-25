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
    private var id_propiedad1cul = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/P1TotalCultivados")
    private var id_propiedad1emb = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/P1TotalEmbolsados")
    private var id_propiedad1culP2 = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/P2TotalCultivados")
    private var id_propiedad1embP2 = db.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/P2TotalEmbolsados")

    lateinit var dateTV: TextView
    lateinit var mascerccana:TextView
    lateinit var cerccana:TextView
    lateinit var pococerccana:TextView
    lateinit var calendarView: CalendarView


    val inforbd: MutableList<String> = ArrayList()


    var P1totalembolsados = 0
    var P1totalcultivados = 0
    var P2totalembolsados = 0
    var P2totalcultivados = 0
    var myID = ArrayList<String>()
    var myIDP2 = ArrayList<String>()
    var racimosEMBOLSADOS = ArrayList<String>()
    var racimosCULTIVADOS = ArrayList<String>()
    var fechas = ArrayList<String>()
    var racimosEMBOLSADOSP2 = ArrayList<String>()
    var racimosCULTIVADOSP2 = ArrayList<String>()
    var fechasP2 = ArrayList<String>()


    //variables categoicas
    var usu = "USUARIO"
    var numusu = 1//2 //numero usuario
    var pros = "PROPIEDADES"
    var numpros = 1//2 //numero propiedades
    var pro = "PROPIEDAD"
    var numpro = 2//2 //numero propiedades
    var zon = "ZONA"
    var numzon = 1//3 //numero usuario
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



    }

    private fun estableccerFechas(diaActual: String, mesActual: String) {
        // EL SIGUIENTE PROCESO ES UN TANTO INEFICIENTE, PUES SE REPITE DOS VECES EL MISMO CODIGO (LA SOLUCION ES IMPORATAR LASS VARIABLES A MODIFICAR E EL ARGUMENTO DE LA FUNCION
        var i = 0
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

                var internoshoy = 0
                var internosmanana = 0
                //var internospasadomanana = 0

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


// LAS SIGUIENTES LINEAS SEPARAN EL ARREGLO myIdeP2 en embolsados  cultivados y fechas
         i = 0
        for (g in myIDP2.indices) {
            if (i == 0) {
                if(myIDP2[g] == "2022")racimosEMBOLSADOSP2.add(myIDP2[g-1])
                else racimosEMBOLSADOSP2.add(myIDP2[g])
            }
            else if (i in 1..3) {
                fechasP2.add(myIDP2[g])

                var mesproximo =0
                if(i==2){ // i = 2, en g, contiene meses del vector de info
                    mesproximo = myIDP2[g].toInt() + 4
                    if(mesproximo > 12) mesproximo = 11
                    println("mes proximo 22222222222 = " + mesproximo)
                }

                var internoshoy = 0
                var internosmanana = 0
                //var internospasadomanana = 0

                if(mesproximo.toString() == mesActual.toString() && i==2){//&& j==1
                    var diasproximos = diaActual.toInt() +1

                    if(diaActual == myIDP2[g+1] ){
                        var fechaponida = ""

                        //if(c==0)  fechaponida = myID[c] +"racimosssss" + fechas[c-1] +"-"+fechas[c]+"-"+fechas[c+1]

                        if(myIDP2[g-2] == "2022"){
                            internoshoy += myIDP2[g-1].toInt()
                            fechaponida = "Hoy " +internoshoy +" racimos (" + myIDP2[g-2].toInt()*pesoKilo + " Kg aprox) "//+ myID[g-1] +"-"+myID[g]+"-"+myID[g+1]
                            //mascerccana.setText( fechaponida)
                        }
                        else{
                            internoshoy += myIDP2[g-2].toInt()
                            fechaponida = "Hoy " +internoshoy +" racimos (" + myIDP2[g-2].toInt()*pesoKilo + " Kg aprox) "//+ myID[g-1] +"-"+myID[g]+"-"+myID[g+1]
                            //mascerccana.setText( fechaponida)
                        }
                    }


                    else if(diasproximos.toString() == myIDP2[g+1] ) {
                                var fechaponida = ""
                                fechaponida =
                                    "Mañana " + myIDP2[g - 2] + " racimos (" + myIDP2[g - 2].toInt() * pesoKilo + " Kg aprox) "//+ myID[g-1] +"-"+myID[g]+"-"+myID[g+1]
                    //            cerccana.setText( fechaponida)
                    }

                    else if((diasproximos+1).toString() == myIDP2[g+1] ){
                        var fechaponida = ""
                        fechaponida = myID[g-2] +" racimos (" + myIDP2[g-2].toInt()*20 + " Kg aprox) "+myIDP2[g+1]+"-"+myIDP2[g] +"-"+ myIDP2[g-1]
                    //    pococerccana.setText( fechaponida)
                    }
                }

            }
            else if (i == 4) racimosCULTIVADOSP2.add(myIDP2[g])
            else if (i in 5..7) fechasP2.add(myIDP2[g])
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



//me falta una estructura d control para la propiedad 2
        //for (x in Varint.indices) {
        for (f in 1..numpro) {
            println("-------------------------------------------> "+numpro)
            for (h in 1..numzonas) {
                for (j in 1..numerofechas) {
                    for (x in Varint) {

                        if (i <= 4) {
                            ruta =
                                usu + numusu + "/" + pros + numzon + "/" + pro + numzon + f + "/" + zon + numzon +f + h + "/" + fech + numzon + f + h + j + "/" + x + numzon + f + h + j
                        } else {
                            ruta =
                                usu + numusu + "/" + pros + numzon + "/" + pro + numzon + f + "/" + zon + numzon +f + h + "/" + fech + numzon+ f + h + j + "/" + x + numzon + f + h + j  + "cult"
                        }
                        println(ruta)

                        var id_CULT = db.getReference(ruta)
                        GlobalScope.launch {
                            if(f==1)myID.add(id_CULT.get().await().value as String)
                            else myIDP2.add(id_CULT.get().await().value as String)
                            /*myID.add(id_CULT.get().await().value as String)
                            inforbd.add(id_CULT.get().await().value as String)
                            //= id_CULT.get().await().value as String*/
                            //println(myIDP2)
                        }
                        i++
                        if (i == 8) i = 0
                    }
                    println("   ")
                }
            }
        }

        //funcion para vaciar la base de datos---> basta con combiar el "2" (vacia la propiedad 1 usuario1) por "1" (vacia la propiedad 1 usuario1) (vacia la propiedad 2 usuario1)
        /*for (h in 1..numzonas) {
            for (j in 1..numerofechas) {
                for (x in Varint) {
                    if (i <= 4) {
                        ruta =
                            usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "2" + "/" + zon + numzon + h + "/" + fech + numzon + h + j + "/" + x + numzon + h + j
                    } else {
                        ruta =
                            usu + numusu + "/" + pros + numpros + "/" + pro + numpro + "2" + "/" + zon + numzon + h + "/" + fech + numzon + h + j + "/" + x + numzon + h + j + "cult"
                    }
                    println(ruta)

                    var id_CULT = db.getReference(ruta)
                    id_CULT.setValue("0")
                    i++
                    if (i == 8) i = 0
                }
                println("   ")
            }
        }*/


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
            P1totalembolsados += racimosEMBOLSADOS[i].toInt()
            print("sdddddddddddddddddd: ")
            println(racimosEMBOLSADOS[i])
        }
        println("---------------> Total cultivados: " + P1totalembolsados)
        println()
        println("Racimos cultivados")
        for (i in racimosCULTIVADOS.indices) {
            P1totalcultivados += racimosCULTIVADOS[i].toInt()
            print("sdddddddddddddddddd: ")
            println(racimosCULTIVADOS[i])

        }
        println("---------------> Total cultivados: " + P1totalcultivados)
        println()
        println("FEchass")
        for (array in fechas) {


            for (value in array) {
                print(value)
            }
            println()
        }

        println("cultivados ---------------> "+P1totalcultivados)
        println("embolsados ---------------> "+P1totalembolsados)
        id_propiedad1cul.setValue(P1totalcultivados.toString())
        id_propiedad1emb.setValue(P1totalembolsados.toString())
        id_propiedad1culP2.setValue(P2totalcultivados.toString())
        id_propiedad1embP2.setValue(P2totalembolsados.toString())
    }

}


