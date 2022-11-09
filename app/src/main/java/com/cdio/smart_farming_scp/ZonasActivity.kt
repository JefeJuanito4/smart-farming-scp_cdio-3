package com.cdio.smart_farming_scp

import android.annotation.SuppressLint
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
import kotlinx.android.synthetic.main.activity_propiedades.*

class ZonasActivity : AppCompatActivity() {

    var idprop=0
    var idzona=0
    var contadorcultivados111 = 0
    var contadorembolsados111 = 0
    var contadorcultivados112 = 0
    var contadorembolsados112 = 0
    var contadorcultivados113 = 0
    var contadorembolsados113 = 0
    var contadorcultivados114 = 0
    var contadorembolsados114 = 0

    private val database = Firebase.database
    // ID
    private var id_botonprop = database.getReference("ID/IDBOTONPROPIEDAD")
    private var id_botonzona = database.getReference("ID/IDBOTONZONA")

                    // usuario 1
                    // propiedad 1

    // CONTADORES FECHAS
    private var contcultivados111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/CONTCULTIVADOS111")
    private var contembolsados111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/CONTEMBOLSADOS111")
    private var contcultivados112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/CONTCULTIVADOS112")
    private var contembolsados112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/CONTEMBOLSADOS112")
    private var contcultivados113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/CONTCULTIVADOS113")
    private var contembolsados113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/CONTEMBOLSADOS113")
    private var contcultivados114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/CONTCULTIVADOS114")
    private var contembolsados114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/CONTEMBOLSADOS114")
    // FECHA 1
    private var cultivados1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/CULTIVADOS1111")
    private var dia1111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/dia1111cult")
    private var mes1111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/mes1111cult")
    private var año1111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/año1111cult")
    private var embolsados1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/EMBOLSADOS1111")
    private var dia1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/dia1111")
    private var mes1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/mes1111")
    private var año1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/año1111")

    private var cultivados1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/CULTIVADOS1121")
    private var dia1121cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/dia1121cult")
    private var mes1121cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/mes1121cult")
    private var año1121cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/año1121cult")
    private var embolsados1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/EMBOLSADOS1121")
    private var dia1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/dia1121")
    private var mes1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/mes1121")
    private var año1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/año1121")

    private var cultivados1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/CULTIVADOS1131")
    private var dia1131cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/dia1131cult")
    private var mes1131cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/mes1131cult")
    private var año1131cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/año1131cult")
    private var embolsados1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/EMBOLSADOS1131")
    private var dia1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/dia1131")
    private var mes1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/mes1131")
    private var año1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/año1131")

    private var cultivados1141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/CULTIVADOS1141")
    private var dia1141cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/dia1141cult")
    private var mes1141cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/mes1141cult")
    private var año1141cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/año1141cult")
    private var embolsados1141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/EMBOLSADOS1141")
    private var dia1141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/dia1141")
    private var mes1141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/mes1141")
    private var año1141 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1141/año1141")
    // FECHA 2
    private var cultivados1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/CULTIVADOS1112")
    private var dia1112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/dia1112cult")
    private var mes1112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/mes1112cult")
    private var año1112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/año1112cult")
    private var embolsados1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/EMBOLSADOS1112")
    private var dia1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/dia1112")
    private var mes1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/mes1112")
    private var año1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/año1112")

    private var cultivados1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/CULTIVADOS1122")
    private var dia1122cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/dia1122cult")
    private var mes1122cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/mes1122cult")
    private var año1122cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/año1122cult")
    private var embolsados1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/EMBOLSADOS1122")
    private var dia1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/dia1122")
    private var mes1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/mes1122")
    private var año1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/año1122")

    private var cultivados1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/CULTIVADOS1132")
    private var dia1132cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/dia1132cult")
    private var mes1132cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/mes1132cult")
    private var año1132cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/año1132cult")
    private var embolsados1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/EMBOLSADOS1132")
    private var dia1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/dia1132")
    private var mes1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/mes1132")
    private var año1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/año1132")

    private var cultivados1142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/CULTIVADOS1142")
    private var dia1142cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/dia1142cult")
    private var mes1142cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/mes1142cult")
    private var año1142cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/año1142cult")
    private var embolsados1142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/EMBOLSADOS1142")
    private var dia1142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/dia1142")
    private var mes1142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/mes1142")
    private var año1142 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1142/año1142")
    // FECHA 3
    private var cultivados1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/CULTIVADOS1113")
    private var dia1113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/dia1113cult")
    private var mes1113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/mes1113cult")
    private var año1113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/año1113cult")
    private var embolsados1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/EMBOLSADOS1113")
    private var dia1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/dia1113")
    private var mes1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/mes1113")
    private var año1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/año1113")

    private var cultivados1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/CULTIVADOS1123")
    private var dia1123cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/dia1123cult")
    private var mes1123cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/mes1123cult")
    private var año1123cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/año1123cult")
    private var embolsados1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/EMBOLSADOS1123")
    private var dia1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/dia1123")
    private var mes1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/mes1123")
    private var año1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/año1123")

    private var cultivados1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/CULTIVADOS1133")
    private var dia1133cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/dia1133cult")
    private var mes1133cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/mes1133cult")
    private var año1133cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/año1133cult")
    private var embolsados1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/EMBOLSADOS1133")
    private var dia1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/dia1133")
    private var mes1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/mes1133")
    private var año1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/año1133")

    private var cultivados1143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/CULTIVADOS1143")
    private var dia1143cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/dia1143cult")
    private var mes1143cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/mes1143cult")
    private var año1143cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/año1143cult")
    private var embolsados1143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/EMBOLSADOS1143")
    private var dia1143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/dia1143")
    private var mes1143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/mes1143")
    private var año1143 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1143/año1143")
    // FECHA 4
    private var cultivados1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/CULTIVADOS1114")
    private var dia1114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/dia1114cult")
    private var mes1114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/mes1114cult")
    private var año1114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/año1114cult")
    private var embolsados1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/EMBOLSADOS1114")
    private var dia1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/dia1114")
    private var mes1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/mes1114")
    private var año1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/año1114")

    private var cultivados1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/CULTIVADOS1124")
    private var dia1124cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/dia1124cult")
    private var mes1124cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/mes1124cult")
    private var año1124cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/año1124cult")
    private var embolsados1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/EMBOLSADOS1124")
    private var dia1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/dia1124")
    private var mes1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/mes1124")
    private var año1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/año1124")

    private var cultivados1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/CULTIVADOS1134")
    private var dia1134cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/dia1134cult")
    private var mes1134cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/mes1134cult")
    private var año1134cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/año1134cult")
    private var embolsados1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/EMBOLSADOS1134")
    private var dia1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/dia1134")
    private var mes1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/mes1134")
    private var año1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/año1134")

    private var cultivados1144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/CULTIVADOS1144")
    private var dia1144cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/dia1144cult")
    private var mes1144cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/mes1144cult")
    private var año1144cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/año1144cult")
    private var embolsados1144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/EMBOLSADOS1144")
    private var dia1144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/dia1144")
    private var mes1144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/mes1144")
    private var año1144 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1144/año1144")
    // FECHA 5
    private var cultivados1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/CULTIVADOS1115")
    private var dia1115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/dia1115cult")
    private var mes1115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/mes1115cult")
    private var año1115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/año1115cult")
    private var embolsados1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/EMBOLSADOS1115")
    private var dia1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/dia1115")
    private var mes1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/mes1115")
    private var año1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/año1115")

    private var cultivados1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/CULTIVADOS1125")
    private var dia1125cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/dia1125cult")
    private var mes1125cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/mes1125cult")
    private var año1125cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/año1125cult")
    private var embolsados1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/EMBOLSADOS1125")
    private var dia1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/dia1125")
    private var mes1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/mes1125")
    private var año1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/año1125")

    private var cultivados1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/CULTIVADOS1135")
    private var dia1135cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/dia1135cult")
    private var mes1135cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/mes1135cult")
    private var año1135cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/año1135cult")
    private var embolsados1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/EMBOLSADOS1135")
    private var dia1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/dia1135")
    private var mes1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/mes1135")
    private var año1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/año1135")

    private var cultivados1145 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/CULTIVADOS1145")
    private var dia1145cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/dia1145cult")
    private var mes1145cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/mes1145cult")
    private var año1145cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/año1145cult")
    private var embolsados1145 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/EMBOLSADOS1145")
    private var dia1145 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/dia1145")
    private var mes1145 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/mes1145")
    private var año1145 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1145/año1145")
    // FECHA 6
    private var cultivados1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/CULTIVADOS1116")
    private var dia1116cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/dia1116cult")
    private var mes1116cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/mes1116cult")
    private var año1116cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/año1116cult")
    private var embolsados1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/EMBOLSADOS1116")
    private var dia1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/dia1116")
    private var mes1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/mes1116")
    private var año1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/año1116")

    private var cultivados1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/CULTIVADOS1126")
    private var dia1126cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/dia1126cult")
    private var mes1126cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/mes1126cult")
    private var año1126cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/año1126cult")
    private var embolsados1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/EMBOLSADOS1126")
    private var dia1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/dia1126")
    private var mes1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/mes1126")
    private var año1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/año1126")

    private var cultivados1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/CULTIVADOS1136")
    private var dia1136cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/dia1136cult")
    private var mes1136cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/mes1136cult")
    private var año1136cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/año1136cult")
    private var embolsados1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/EMBOLSADOS1136")
    private var dia1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/dia1136")
    private var mes1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/mes1136")
    private var año1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/año1136")

    private var cultivados1146 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/CULTIVADOS1146")
    private var dia1146cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/dia1146cult")
    private var mes1146cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/mes1146cult")
    private var año1146cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/año1146cult")
    private var embolsados1146 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/EMBOLSADOS1146")
    private var dia1146 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/dia1146")
    private var mes1146 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/mes1146")
    private var año1146 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1146/año1146")
    // FECHA 7
    private var cultivados1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/CULTIVADOS1117")
    private var dia1117cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/dia1117cult")
    private var mes1117cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/mes1117cult")
    private var año1117cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/año1117cult")
    private var embolsados1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/EMBOLSADOS1117")
    private var dia1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/dia1117")
    private var mes1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/mes1117")
    private var año1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/año1117")

    private var cultivados1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/CULTIVADOS1127")
    private var dia1127cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/dia1127cult")
    private var mes1127cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/mes1127cult")
    private var año1127cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/año1127cult")
    private var embolsados1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/EMBOLSADOS1127")
    private var dia1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/dia1127")
    private var mes1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/mes1127")
    private var año1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/año1127")

    private var cultivados1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/CULTIVADOS1137")
    private var dia1137cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/dia1137cult")
    private var mes1137cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/mes1137cult")
    private var año1137cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/año1137cult")
    private var embolsados1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/EMBOLSADOS1137")
    private var dia1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/dia1137")
    private var mes1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/mes1137")
    private var año1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/año1137")

    private var cultivados1147 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/CULTIVADOS1147")
    private var dia1147cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/dia1147")
    private var mes1147cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/mes1147")
    private var año1147cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/año1147")
    private var embolsados1147 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/EMBOLSADOS1147")
    private var dia1147 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/dia1147")
    private var mes1147 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/mes1147")
    private var año1147 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1147/año1147")
    // FECHA 8
    private var cultivados1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/CULTIVADOS1118")
    private var dia1118cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/dia1118")
    private var mes1118cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/mes1118")
    private var año1118cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/año1118")
    private var embolsados1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/EMBOLSADOS1118")
    private var dia1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/dia1118")
    private var mes1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/mes1118")
    private var año1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/año1118")

    private var cultivados1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/CULTIVADOS1128")
    private var dia1128cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/dia1128")
    private var mes1128cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/mes1128")
    private var año1128cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/año1128")
    private var embolsados1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/EMBOLSADOS1128")
    private var dia1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/dia1128")
    private var mes1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/mes1128")
    private var año1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/año1128")

    private var cultivados1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/CULTIVADOS1138")
    private var dia1138cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/dia1138")
    private var mes1138cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/mes1138")
    private var año1138cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/año1138")
    private var embolsados1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/EMBOLSADOS1138")
    private var dia1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/dia1138")
    private var mes1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/mes1138")
    private var año1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/año1138")

    private var cultivados1148 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/CULTIVADOS1148")
    private var dia1148cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/dia1148")
    private var mes1148cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/mes1148")
    private var año1148cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/año1148")
    private var embolsados1148 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/EMBOLSADOS1148")
    private var dia1148 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/dia1148")
    private var mes1148 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/mes1148")
    private var año1148 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1148/año1148")
    // FECHA 9
    private var cultivados1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/CULTIVADOS1119")
    private var dia1119cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/dia1119")
    private var mes1119cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/mes1119")
    private var año1119cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/año1119")
    private var embolsados1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/EMBOLSADOS1119")
    private var dia1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/dia1119")
    private var mes1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/mes1119")
    private var año1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/año1119")

    private var cultivados1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/CULTIVADOS1129")
    private var dia1129cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/dia1129")
    private var mes1129cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/mes1129")
    private var año1129cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/año1129")
    private var embolsados1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/EMBOLSADOS1129")
    private var dia1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/dia1129")
    private var mes1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/mes1129")
    private var año1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/año1129")

    private var cultivados1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/CULTIVADOS1139")
    private var dia1139cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/dia1139")
    private var mes1139cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/mes1139")
    private var año1139cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/año1139")
    private var embolsados1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/EMBOLSADOS1139")
    private var dia1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/dia1139")
    private var mes1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/mes1139")
    private var año1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/año1139")

    private var cultivados1149 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/CULTIVADOS1149")
    private var dia1149cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/dia1149")
    private var mes1149cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/mes1149")
    private var año1149cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/año1149")
    private var embolsados1149 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/EMBOLSADOS1149")
    private var dia1149 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/dia1149")
    private var mes1149 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/mes1149")
    private var año1149 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV1149/año1149")
    // FECHA 10
    private var cultivados11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/CULTIVADOS11110")
    private var dia11110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/dia11110")
    private var mes11110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/mes11110")
    private var año11110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/año11110")
    private var embolsados11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/EMBOLSADOS11110")
    private var dia11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/dia11110")
    private var mes11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/mes11110")
    private var año11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/año11110")

    private var cultivados11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/CULTIVADOS11210")
    private var dia11210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/dia11210")
    private var mes11210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/mes11210")
    private var año11210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/año11210")
    private var embolsados11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/EMBOLSADOS11210")
    private var dia11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/dia11210")
    private var mes11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/mes11210")
    private var año11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/año11210")

    private var cultivados11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/CULTIVADOS11310")
    private var dia11310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/dia11310")
    private var mes11310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/mes11310")
    private var año11310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/año11310")
    private var embolsados11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/EMBOLSADOS11310")
    private var dia11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/dia11310")
    private var mes11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/mes11310")
    private var año11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/año11310")

    private var cultivados11410 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/CULTIVADOS11410")
    private var dia11410cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/dia11410")
    private var mes11410cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/mes11410")
    private var año11410cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/año11410")
    private var embolsados11410 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/EMBOLSADOS11410")
    private var dia11410 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/dia11410")
    private var mes11410 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/mes11410")
    private var año11410 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11410/año11410")
    // FECHA 11
    private var cultivados11111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/CULTIVADOS11111")
    private var dia11111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/dia11111")
    private var mes11111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/mes11111")
    private var año11111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/año11111")
    private var embolsados11111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/EMBOLSADOS11111")
    private var dia11111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/dia11111")
    private var mes11111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/mes11111")
    private var año11111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11111/año11111")

    private var cultivados11211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/CULTIVADOS11211")
    private var dia11211cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/dia11211")
    private var mes11211cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/mes11211")
    private var año11211cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/año11211")
    private var embolsados11211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/EMBOLSADOS11211")
    private var dia11211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/dia11211")
    private var mes11211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/mes11211")
    private var año11211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11211/año11211")

    private var cultivados11311 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/CULTIVADOS11311")
    private var dia11311cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/dia11311")
    private var mes11311cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/mes11311")
    private var año11311cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/año11311")
    private var embolsados11311 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/EMBOLSADOS11311")
    private var dia11311 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/dia11311")
    private var mes11311 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/mes11311")
    private var año11311 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11311/año11311")

    private var cultivados11411 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/CULTIVADOS11411")
    private var dia11411cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/dia11411")
    private var mes11411cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/mes11411")
    private var año11411cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/año11411")
    private var embolsados11411 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/EMBOLSADOS11411")
    private var dia11411 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/dia11411")
    private var mes11411 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/mes11411")
    private var año11411 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11411/año11411")
    // FECHA 12
    private var cultivados11112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/CULTIVADOS11112")
    private var dia11112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/dia11112")
    private var mes11112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/mes11112")
    private var año11112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/año11112")
    private var embolsados11112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/EMBOLSADOS11112")
    private var dia11112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/dia11112")
    private var mes11112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/mes11112")
    private var año11112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11112/año11112")

    private var cultivados11212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/CULTIVADOS11212")
    private var dia11212cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/dia11212")
    private var mes11212cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/mes11212")
    private var año11212cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/año11212")
    private var embolsados11212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/EMBOLSADOS11212")
    private var dia11212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/dia11212")
    private var mes11212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/mes11212")
    private var año11212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11212/año11212")

    private var cultivados11312 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/CULTIVADOS11312")
    private var dia11312cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/dia11312")
    private var mes11312cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/mes11312")
    private var año11312cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/año11312")
    private var embolsados11312 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/EMBOLSADOS11312")
    private var dia11312 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/dia11312")
    private var mes11312 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/mes11312")
    private var año11312 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11312/año11312")

    private var cultivados11412 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/CULTIVADOS11412")
    private var dia11412cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/dia11412")
    private var mes11412cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/mes11412")
    private var año11412cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/año11412")
    private var embolsados11412 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/EMBOLSADOS11412")
    private var dia11412 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/dia11412")
    private var mes11412 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/mes11412")
    private var año11412 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11412/año11412")
    // FECHA 13
    private var cultivados11113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/CULTIVADOS11113")
    private var dia11113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/dia11113")
    private var mes11113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/mes11113")
    private var año11113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/año11113")
    private var embolsados11113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/EMBOLSADOS11113")
    private var dia11113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/dia11113")
    private var mes11113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/mes11113")
    private var año11113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11113/año11113")

    private var cultivados11213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/CULTIVADOS11213")
    private var dia11213cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/dia11213")
    private var mes11213cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/mes11213")
    private var año11213cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/año11213")
    private var embolsados11213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/EMBOLSADOS11213")
    private var dia11213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/dia11213")
    private var mes11213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/mes11213")
    private var año11213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11213/año11213")

    private var cultivados11313 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/CULTIVADOS11313")
    private var dia11313cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/dia11313")
    private var mes11313cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/mes11313")
    private var año11313cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/año11313")
    private var embolsados11313 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/EMBOLSADOS11313")
    private var dia11313 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/dia11313")
    private var mes11313 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/mes11313")
    private var año11313 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11313/año11313")

    private var cultivados11413 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/CULTIVADOS11413")
    private var dia11413cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/dia11413")
    private var mes11413cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/mes11413")
    private var año11413cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/año11413")
    private var embolsados11413 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/EMBOLSADOS11413")
    private var dia11413 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/dia11413")
    private var mes11413 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/mes11413")
    private var año11413 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11413/año11413")
    // FECHA 14
    private var cultivados11114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/CULTIVADOS11114")
    private var dia11114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/dia11114")
    private var mes11114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/mes11114")
    private var año11114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/año11114")
    private var embolsados11114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/EMBOLSADOS11114")
    private var dia11114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/dia11114")
    private var mes11114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/mes11114")
    private var año11114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11114/año11114")

    private var cultivados11214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/CULTIVADOS11214")
    private var dia11214cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/dia11214")
    private var mes11214cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/mes11214")
    private var año11214cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/año11214")
    private var embolsados11214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/EMBOLSADOS11214")
    private var dia11214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/dia11214")
    private var mes11214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/mes11214")
    private var año11214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11214/año11214")

    private var cultivados11314 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/CULTIVADOS11314")
    private var dia11314cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/dia11314")
    private var mes11314cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/mes11314")
    private var año11314cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/año11314")
    private var embolsados11314 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/EMBOLSADOS11314")
    private var dia11314 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/dia11314")
    private var mes11314 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/mes11314")
    private var año11314 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11314/año11314")

    private var cultivados11414 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/CULTIVADOS11414")
    private var dia11414cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/dia11414")
    private var mes11414cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/mes11414")
    private var año11414cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/año11414")
    private var embolsados11414 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/EMBOLSADOS11414")
    private var dia11414 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/dia11414")
    private var mes11414 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/mes11414")
    private var año11414 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11414/año11414")
    // FECHA 15
    private var cultivados11115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/CULTIVADOS11115")
    private var dia11115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/dia11115")
    private var mes11115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/mes11115")
    private var año11115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/año11115")
    private var embolsados11115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/EMBOLSADOS11115")
    private var dia11115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/dia11115")
    private var mes11115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/mes11115")
    private var año11115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11115/año11115")

    private var cultivados11215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/CULTIVADOS11215")
    private var dia11215cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/dia11215")
    private var mes11215cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/mes11215")
    private var año11215cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/año11215")
    private var embolsados11215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/EMBOLSADOS11215")
    private var dia11215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/dia11215")
    private var mes11215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/mes11215")
    private var año11215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11215/año11215")

    private var cultivados11315 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/CULTIVADOS11315")
    private var dia11315cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/dia11315")
    private var mes11315cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/mes11315")
    private var año11315cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/año11315")
    private var embolsados11315 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/EMBOLSADOS11315")
    private var dia11315 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/dia11315")
    private var mes11315 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/mes11315")
    private var año11315 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11315/año11315")

    private var cultivados11415 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/CULTIVADOS11415")
    private var dia11415cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/dia11415")
    private var mes11415cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/mes11415")
    private var año11415cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/año11415")
    private var embolsados11415 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/EMBOLSADOS11415")
    private var dia11415 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/dia11415")
    private var mes11415 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/mes11415")
    private var año11415 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA114/FECHAINV11415/año11415")

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

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zonas)

        GlobalScope.launch {
            var dbIDprop = id_botonprop.get().await().value as Long
            var dbIDzona = id_botonzona.get().await().value as Long
            var dbcontcult111 = contcultivados111.get().await().value as Long
            var dbcontemb111 = contembolsados111.get().await().value as Long
            var dbcontcult112 = contcultivados112.get().await().value as Long
            var dbcontemb112 = contembolsados112.get().await().value as Long
            var dbcontcult113 = contcultivados113.get().await().value as Long
            var dbcontemb113 = contembolsados113.get().await().value as Long
            var dbcontcult114 = contcultivados114.get().await().value as Long
            var dbcontemb114 = contembolsados114.get().await().value as Long

            idprop = dbIDprop.toInt()
            idzona = dbIDzona.toInt()
            contadorcultivados111 = dbcontcult111.toInt()
            contadorembolsados111 = dbcontemb111.toInt()
            contadorcultivados112 = dbcontcult112.toInt()
            contadorembolsados112 = dbcontemb112.toInt()
            contadorcultivados113 = dbcontcult113.toInt()
            contadorembolsados113 = dbcontemb113.toInt()
            contadorcultivados114 = dbcontcult114.toInt()
            contadorembolsados114 = dbcontemb114.toInt()

            botonGuardarZonas.visibility = View.VISIBLE

            botonGuardarZonas.setOnClickListener {
                // propiedad 1
                if (idprop == 1) {
                    if (idzona == 1) {
                        if(editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()){
                            when(contadorembolsados111) {
                                0 -> {
                                    embolsados1111.setValue(editTxtEmbolsados.text.toString())
                                    dia1111.setValue(editTxtDia.text.toString())
                                    mes1111.setValue(editTxtMes.text.toString())
                                    año1111.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=1
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                1 -> {
                                    embolsados1112.setValue(editTxtEmbolsados.text.toString())
                                    dia1112.setValue(editTxtDia.text.toString())
                                    mes1112.setValue(editTxtMes.text.toString())
                                    año1112.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=2
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                2 -> {
                                    embolsados1113.setValue(editTxtEmbolsados.text.toString())
                                    dia1113.setValue(editTxtDia.text.toString())
                                    mes1113.setValue(editTxtMes.text.toString())
                                    año1113.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=3
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                3 -> {
                                    embolsados1114.setValue(editTxtEmbolsados.text.toString())
                                    dia1114.setValue(editTxtDia.text.toString())
                                    mes1114.setValue(editTxtMes.text.toString())
                                    año1114.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=4
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                4 -> {
                                    embolsados1115.setValue(editTxtEmbolsados.text.toString())
                                    dia1115.setValue(editTxtDia.text.toString())
                                    mes1115.setValue(editTxtMes.text.toString())
                                    año1115.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=5
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                5 -> {
                                    embolsados1116.setValue(editTxtEmbolsados.text.toString())
                                    dia1116.setValue(editTxtDia.text.toString())
                                    mes1116.setValue(editTxtMes.text.toString())
                                    año1116.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=6
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                6 -> {
                                    embolsados1117.setValue(editTxtEmbolsados.text.toString())
                                    dia1117.setValue(editTxtDia.text.toString())
                                    mes1117.setValue(editTxtMes.text.toString())
                                    año1117.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=7
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                7 -> {
                                    embolsados1118.setValue(editTxtEmbolsados.text.toString())
                                    dia1118.setValue(editTxtDia.text.toString())
                                    mes1118.setValue(editTxtMes.text.toString())
                                    año1118.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=8
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                8 -> {
                                    embolsados1119.setValue(editTxtEmbolsados.text.toString())
                                    dia1119.setValue(editTxtDia.text.toString())
                                    mes1119.setValue(editTxtMes.text.toString())
                                    año1119.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=9
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                9 -> {
                                    embolsados11110.setValue(editTxtEmbolsados.text.toString())
                                    dia11110.setValue(editTxtDia.text.toString())
                                    mes11110.setValue(editTxtMes.text.toString())
                                    año11110.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=10
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                10 -> {
                                    embolsados11111.setValue(editTxtEmbolsados.text.toString())
                                    dia11111.setValue(editTxtDia.text.toString())
                                    mes11111.setValue(editTxtMes.text.toString())
                                    año11111.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=11
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                11 -> {
                                    embolsados11112.setValue(editTxtEmbolsados.text.toString())
                                    dia11112.setValue(editTxtDia.text.toString())
                                    mes11112.setValue(editTxtMes.text.toString())
                                    año11112.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=12
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                12 -> {
                                    embolsados11113.setValue(editTxtEmbolsados.text.toString())
                                    dia11113.setValue(editTxtDia.text.toString())
                                    mes11113.setValue(editTxtMes.text.toString())
                                    año11113.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=13
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                13 -> {
                                    embolsados11114.setValue(editTxtEmbolsados.text.toString())
                                    dia11114.setValue(editTxtDia.text.toString())
                                    mes11114.setValue(editTxtMes.text.toString())
                                    año11114.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=14
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                14 -> {
                                    embolsados11115.setValue(editTxtEmbolsados.text.toString())
                                    dia11115.setValue(editTxtDia.text.toString())
                                    mes11115.setValue(editTxtMes.text.toString())
                                    año11115.setValue(editTxtAño.text.toString())
                                    contadorembolsados111=15
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                                15 -> {
                                    botonGuardarZonas.visibility = View.INVISIBLE
                                    contadorembolsados111=16
                                    contembolsados111.setValue(contadorembolsados111)
                                }
                            }
                            when(contadorcultivados111) {
                                0 -> {
                                    cultivados1111.setValue(editTxtCultivados.text.toString())
                                    dia1111cult.setValue(editTxtDia.text.toString())
                                    mes1111cult.setValue(editTxtMes.text.toString())
                                    año1111cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=1
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                1 -> {
                                    cultivados1112.setValue(editTxtCultivados.text.toString())
                                    dia1112cult.setValue(editTxtDia.text.toString())
                                    mes1112cult.setValue(editTxtMes.text.toString())
                                    año1112cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=2
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                2 -> {
                                    cultivados1113.setValue(editTxtCultivados.text.toString())
                                    dia1113cult.setValue(editTxtDia.text.toString())
                                    mes1113cult.setValue(editTxtMes.text.toString())
                                    año1113cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=3
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                3 -> {
                                    cultivados1114.setValue(editTxtCultivados.text.toString())
                                    dia1114cult.setValue(editTxtDia.text.toString())
                                    mes1114cult.setValue(editTxtMes.text.toString())
                                    año1114cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=4
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                4 -> {
                                    cultivados1115.setValue(editTxtCultivados.text.toString())
                                    dia1115cult.setValue(editTxtDia.text.toString())
                                    mes1115cult.setValue(editTxtMes.text.toString())
                                    año1115cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=5
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                5 -> {
                                    cultivados1116.setValue(editTxtCultivados.text.toString())
                                    dia1116cult.setValue(editTxtDia.text.toString())
                                    mes1116cult.setValue(editTxtMes.text.toString())
                                    año1116cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=6
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                6 -> {
                                    cultivados1117.setValue(editTxtCultivados.text.toString())
                                    dia1117cult.setValue(editTxtDia.text.toString())
                                    mes1117cult.setValue(editTxtMes.text.toString())
                                    año1117cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=7
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                7 -> {
                                    cultivados1118.setValue(editTxtCultivados.text.toString())
                                    dia1118cult.setValue(editTxtDia.text.toString())
                                    mes1118cult.setValue(editTxtMes.text.toString())
                                    año1118cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=8
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                8 -> {
                                    cultivados1119.setValue(editTxtCultivados.text.toString())
                                    dia1119cult.setValue(editTxtDia.text.toString())
                                    mes1119cult.setValue(editTxtMes.text.toString())
                                    año1119cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=9
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                9 -> {
                                    cultivados11110.setValue(editTxtCultivados.text.toString())
                                    dia11110cult.setValue(editTxtDia.text.toString())
                                    mes11110cult.setValue(editTxtMes.text.toString())
                                    año11110cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=10
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                10 -> {
                                    cultivados11111.setValue(editTxtCultivados.text.toString())
                                    dia11111cult.setValue(editTxtDia.text.toString())
                                    mes11111cult.setValue(editTxtMes.text.toString())
                                    año11111cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=11
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                11 -> {
                                    cultivados11112.setValue(editTxtCultivados.text.toString())
                                    dia11112cult.setValue(editTxtDia.text.toString())
                                    mes11112cult.setValue(editTxtMes.text.toString())
                                    año11112cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=12
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                12 -> {
                                    cultivados11113.setValue(editTxtCultivados.text.toString())
                                    dia11113cult.setValue(editTxtDia.text.toString())
                                    mes11113cult.setValue(editTxtMes.text.toString())
                                    año11113cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=13
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                13 -> {
                                    cultivados11114.setValue(editTxtCultivados.text.toString())
                                    dia11114cult.setValue(editTxtDia.text.toString())
                                    mes11114cult.setValue(editTxtMes.text.toString())
                                    año11114cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=14
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                14 -> {
                                    cultivados11115.setValue(editTxtCultivados.text.toString())
                                    dia11115cult.setValue(editTxtDia.text.toString())
                                    mes11115cult.setValue(editTxtMes.text.toString())
                                    año11115cult.setValue(editTxtAño.text.toString())
                                    contadorcultivados111=15
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                                15 -> {
                                    botonGuardarZonas.visibility = View.INVISIBLE
                                    contadorcultivados111=16
                                    contcultivados111.setValue(contadorcultivados111)
                                }
                            }
                        }else  // if 2 llenos zona 1 prop 1
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                when(contadorembolsados111) {
                                    0 -> {
                                        embolsados1111.setValue(editTxtEmbolsados.text.toString())
                                        dia1111.setValue(editTxtDia.text.toString())
                                        mes1111.setValue(editTxtMes.text.toString())
                                        año1111.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=1
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    1 -> {
                                        embolsados1112.setValue(editTxtEmbolsados.text.toString())
                                        dia1112.setValue(editTxtDia.text.toString())
                                        mes1112.setValue(editTxtMes.text.toString())
                                        año1112.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=2
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    2 -> {
                                        embolsados1113.setValue(editTxtEmbolsados.text.toString())
                                        dia1113.setValue(editTxtDia.text.toString())
                                        mes1113.setValue(editTxtMes.text.toString())
                                        año1113.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=3
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    3 -> {
                                        embolsados1114.setValue(editTxtEmbolsados.text.toString())
                                        dia1114.setValue(editTxtDia.text.toString())
                                        mes1114.setValue(editTxtMes.text.toString())
                                        año1114.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=4
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    4 -> {
                                        embolsados1115.setValue(editTxtEmbolsados.text.toString())
                                        dia1115.setValue(editTxtDia.text.toString())
                                        mes1115.setValue(editTxtMes.text.toString())
                                        año1115.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=5
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    5 -> {
                                        embolsados1116.setValue(editTxtEmbolsados.text.toString())
                                        dia1116.setValue(editTxtDia.text.toString())
                                        mes1116.setValue(editTxtMes.text.toString())
                                        año1116.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=6
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    6 -> {
                                        embolsados1117.setValue(editTxtEmbolsados.text.toString())
                                        dia1117.setValue(editTxtDia.text.toString())
                                        mes1117.setValue(editTxtMes.text.toString())
                                        año1117.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=7
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    7 -> {
                                        embolsados1118.setValue(editTxtEmbolsados.text.toString())
                                        dia1118.setValue(editTxtDia.text.toString())
                                        mes1118.setValue(editTxtMes.text.toString())
                                        año1118.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=8
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    8 -> {
                                        embolsados1119.setValue(editTxtEmbolsados.text.toString())
                                        dia1119.setValue(editTxtDia.text.toString())
                                        mes1119.setValue(editTxtMes.text.toString())
                                        año1119.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=9
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    9 -> {
                                        embolsados11110.setValue(editTxtEmbolsados.text.toString())
                                        dia11110.setValue(editTxtDia.text.toString())
                                        mes11110.setValue(editTxtMes.text.toString())
                                        año11110.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=10
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    10 -> {
                                        embolsados11111.setValue(editTxtEmbolsados.text.toString())
                                        dia11111.setValue(editTxtDia.text.toString())
                                        mes11111.setValue(editTxtMes.text.toString())
                                        año11111.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=11
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    11 -> {
                                        embolsados11112.setValue(editTxtEmbolsados.text.toString())
                                        dia11112.setValue(editTxtDia.text.toString())
                                        mes11112.setValue(editTxtMes.text.toString())
                                        año11112.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=12
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    12 -> {
                                        embolsados11113.setValue(editTxtEmbolsados.text.toString())
                                        dia11113.setValue(editTxtDia.text.toString())
                                        mes11113.setValue(editTxtMes.text.toString())
                                        año11113.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=13
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    13 -> {
                                        embolsados11114.setValue(editTxtEmbolsados.text.toString())
                                        dia11114.setValue(editTxtDia.text.toString())
                                        mes11114.setValue(editTxtMes.text.toString())
                                        año11114.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=14
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    14 -> {
                                        embolsados11115.setValue(editTxtEmbolsados.text.toString())
                                        dia11115.setValue(editTxtDia.text.toString())
                                        mes11115.setValue(editTxtMes.text.toString())
                                        año11115.setValue(editTxtAño.text.toString())
                                        contadorembolsados111=15
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                    15 -> {
                                        botonGuardarZonas.visibility = View.INVISIBLE
                                        contadorembolsados111=16
                                        contembolsados111.setValue(contadorembolsados111)
                                    }
                                }
                            }else
                                if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                    when(contadorcultivados111) {
                                        0 -> {
                                            cultivados1111.setValue(editTxtCultivados.text.toString())
                                            dia1111cult.setValue(editTxtDia.text.toString())
                                            mes1111cult.setValue(editTxtMes.text.toString())
                                            año1111cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=1
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        1 -> {
                                            cultivados1112.setValue(editTxtCultivados.text.toString())
                                            dia1112cult.setValue(editTxtDia.text.toString())
                                            mes1112cult.setValue(editTxtMes.text.toString())
                                            año1112cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=2
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        2 -> {
                                            cultivados1113.setValue(editTxtCultivados.text.toString())
                                            dia1113cult.setValue(editTxtDia.text.toString())
                                            mes1113cult.setValue(editTxtMes.text.toString())
                                            año1113cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=3
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        3 -> {
                                            cultivados1114.setValue(editTxtCultivados.text.toString())
                                            dia1114cult.setValue(editTxtDia.text.toString())
                                            mes1114cult.setValue(editTxtMes.text.toString())
                                            año1114cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=4
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        4 -> {
                                            cultivados1115.setValue(editTxtCultivados.text.toString())
                                            dia1115cult.setValue(editTxtDia.text.toString())
                                            mes1115cult.setValue(editTxtMes.text.toString())
                                            año1115cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=5
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        5 -> {
                                            cultivados1116.setValue(editTxtCultivados.text.toString())
                                            dia1116cult.setValue(editTxtDia.text.toString())
                                            mes1116cult.setValue(editTxtMes.text.toString())
                                            año1116cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=6
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        6 -> {
                                            cultivados1117.setValue(editTxtCultivados.text.toString())
                                            dia1117cult.setValue(editTxtDia.text.toString())
                                            mes1117cult.setValue(editTxtMes.text.toString())
                                            año1117cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=7
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        7 -> {
                                            cultivados1118.setValue(editTxtCultivados.text.toString())
                                            dia1118cult.setValue(editTxtDia.text.toString())
                                            mes1118cult.setValue(editTxtMes.text.toString())
                                            año1118cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=8
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        8 -> {
                                            cultivados1119.setValue(editTxtCultivados.text.toString())
                                            dia1119cult.setValue(editTxtDia.text.toString())
                                            mes1119cult.setValue(editTxtMes.text.toString())
                                            año1119cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=9
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        9 -> {
                                            cultivados11110.setValue(editTxtCultivados.text.toString())
                                            dia11110cult.setValue(editTxtDia.text.toString())
                                            mes11110cult.setValue(editTxtMes.text.toString())
                                            año11110cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=10
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        10 -> {
                                            cultivados11111.setValue(editTxtCultivados.text.toString())
                                            dia11111cult.setValue(editTxtDia.text.toString())
                                            mes11111cult.setValue(editTxtMes.text.toString())
                                            año11111cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=11
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        11 -> {
                                            cultivados11112.setValue(editTxtCultivados.text.toString())
                                            dia11112cult.setValue(editTxtDia.text.toString())
                                            mes11112cult.setValue(editTxtMes.text.toString())
                                            año11112cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=12
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        12 -> {
                                            cultivados11113.setValue(editTxtCultivados.text.toString())
                                            dia11113cult.setValue(editTxtDia.text.toString())
                                            mes11113cult.setValue(editTxtMes.text.toString())
                                            año11113cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=13
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        13 -> {
                                            cultivados11114.setValue(editTxtCultivados.text.toString())
                                            dia11114cult.setValue(editTxtDia.text.toString())
                                            mes11114cult.setValue(editTxtMes.text.toString())
                                            año11114cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=14
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        14 -> {
                                            cultivados11115.setValue(editTxtCultivados.text.toString())
                                            dia11115cult.setValue(editTxtDia.text.toString())
                                            mes11115cult.setValue(editTxtMes.text.toString())
                                            año11115cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados111=15
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                        15 -> {
                                            botonGuardarZonas.visibility = View.INVISIBLE
                                            contadorcultivados111=16
                                            contcultivados111.setValue(contadorcultivados111)
                                        }
                                    }
                                }
                    //////////////////////////////////
                    }else
                        if (idzona == 2) {
                            if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                when(contadorembolsados112) {
                                    0 -> {
                                        embolsados1121.setValue(editTxtEmbolsados.text.toString())
                                        dia1121.setValue(editTxtDia.text.toString())
                                        mes1121.setValue(editTxtMes.text.toString())
                                        año1121.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=1
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    1 -> {
                                        embolsados1122.setValue(editTxtEmbolsados.text.toString())
                                        dia1122.setValue(editTxtDia.text.toString())
                                        mes1122.setValue(editTxtMes.text.toString())
                                        año1122.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=2
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    2 -> {
                                        embolsados1123.setValue(editTxtEmbolsados.text.toString())
                                        dia1123.setValue(editTxtDia.text.toString())
                                        mes1123.setValue(editTxtMes.text.toString())
                                        año1123.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=3
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    3 -> {
                                        embolsados1124.setValue(editTxtEmbolsados.text.toString())
                                        dia1124.setValue(editTxtDia.text.toString())
                                        mes1124.setValue(editTxtMes.text.toString())
                                        año1124.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=4
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    4 -> {
                                        embolsados1125.setValue(editTxtEmbolsados.text.toString())
                                        dia1125.setValue(editTxtDia.text.toString())
                                        mes1125.setValue(editTxtMes.text.toString())
                                        año1125.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=5
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    5 -> {
                                        embolsados1126.setValue(editTxtEmbolsados.text.toString())
                                        dia1126.setValue(editTxtDia.text.toString())
                                        mes1126.setValue(editTxtMes.text.toString())
                                        año1126.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=6
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    6 -> {
                                        embolsados1127.setValue(editTxtEmbolsados.text.toString())
                                        dia1127.setValue(editTxtDia.text.toString())
                                        mes1127.setValue(editTxtMes.text.toString())
                                        año1127.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=7
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    7 -> {
                                        embolsados1128.setValue(editTxtEmbolsados.text.toString())
                                        dia1128.setValue(editTxtDia.text.toString())
                                        mes1128.setValue(editTxtMes.text.toString())
                                        año1128.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=8
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    8 -> {
                                        embolsados1129.setValue(editTxtEmbolsados.text.toString())
                                        dia1129.setValue(editTxtDia.text.toString())
                                        mes1129.setValue(editTxtMes.text.toString())
                                        año1129.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=9
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    9 -> {
                                        embolsados11210.setValue(editTxtEmbolsados.text.toString())
                                        dia11210.setValue(editTxtDia.text.toString())
                                        mes11210.setValue(editTxtMes.text.toString())
                                        año11210.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=10
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    10 -> {
                                        embolsados11211.setValue(editTxtEmbolsados.text.toString())
                                        dia11211.setValue(editTxtDia.text.toString())
                                        mes11211.setValue(editTxtMes.text.toString())
                                        año11211.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=11
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    11 -> {
                                        embolsados11212.setValue(editTxtEmbolsados.text.toString())
                                        dia11212.setValue(editTxtDia.text.toString())
                                        mes11212.setValue(editTxtMes.text.toString())
                                        año11212.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=12
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    12 -> {
                                        embolsados11213.setValue(editTxtEmbolsados.text.toString())
                                        dia11213.setValue(editTxtDia.text.toString())
                                        mes11213.setValue(editTxtMes.text.toString())
                                        año11213.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=13
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    13 -> {
                                        embolsados11214.setValue(editTxtEmbolsados.text.toString())
                                        dia11214.setValue(editTxtDia.text.toString())
                                        mes11214.setValue(editTxtMes.text.toString())
                                        año11214.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=14
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    14 -> {
                                        embolsados11215.setValue(editTxtEmbolsados.text.toString())
                                        dia11215.setValue(editTxtDia.text.toString())
                                        mes11215.setValue(editTxtMes.text.toString())
                                        año11215.setValue(editTxtAño.text.toString())
                                        contadorembolsados112=15
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                    15 -> {
                                        botonGuardarZonas.visibility = View.INVISIBLE
                                        contadorembolsados112=16
                                        contembolsados112.setValue(contadorembolsados112)
                                    }
                                }
                            }else
                                if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                    when(contadorcultivados112) {
                                        0 -> {
                                            cultivados1121.setValue(editTxtCultivados.text.toString())
                                            dia1121cult.setValue(editTxtDia.text.toString())
                                            mes1121cult.setValue(editTxtMes.text.toString())
                                            año1121cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 1
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        1 -> {
                                            cultivados1122.setValue(editTxtCultivados.text.toString())
                                            dia1122cult.setValue(editTxtDia.text.toString())
                                            mes1122cult.setValue(editTxtMes.text.toString())
                                            año1122cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 2
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        2 -> {
                                            cultivados1123.setValue(editTxtCultivados.text.toString())
                                            dia1123cult.setValue(editTxtDia.text.toString())
                                            mes1123cult.setValue(editTxtMes.text.toString())
                                            año1123cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 3
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        3 -> {
                                            cultivados1124.setValue(editTxtCultivados.text.toString())
                                            dia1124cult.setValue(editTxtDia.text.toString())
                                            mes1124cult.setValue(editTxtMes.text.toString())
                                            año1124cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 4
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        4 -> {
                                            cultivados1125.setValue(editTxtCultivados.text.toString())
                                            dia1125cult.setValue(editTxtDia.text.toString())
                                            mes1125cult.setValue(editTxtMes.text.toString())
                                            año1125cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 5
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        5 -> {
                                            cultivados1126.setValue(editTxtCultivados.text.toString())
                                            dia1126cult.setValue(editTxtDia.text.toString())
                                            mes1126cult.setValue(editTxtMes.text.toString())
                                            año1126cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 6
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        6 -> {
                                            cultivados1127.setValue(editTxtCultivados.text.toString())
                                            dia1127cult.setValue(editTxtDia.text.toString())
                                            mes1127cult.setValue(editTxtMes.text.toString())
                                            año1127cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 7
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        7 -> {
                                            cultivados1128.setValue(editTxtCultivados.text.toString())
                                            dia1128cult.setValue(editTxtDia.text.toString())
                                            mes1128cult.setValue(editTxtMes.text.toString())
                                            año1128cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 8
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        8 -> {
                                            cultivados1129.setValue(editTxtCultivados.text.toString())
                                            dia1129cult.setValue(editTxtDia.text.toString())
                                            mes1129cult.setValue(editTxtMes.text.toString())
                                            año1129cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 9
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        9 -> {
                                            cultivados11210.setValue(editTxtCultivados.text.toString())
                                            dia11210cult.setValue(editTxtDia.text.toString())
                                            mes11210cult.setValue(editTxtMes.text.toString())
                                            año11210cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 10
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        10 -> {
                                            cultivados11211.setValue(editTxtCultivados.text.toString())
                                            dia11211cult.setValue(editTxtDia.text.toString())
                                            mes11211cult.setValue(editTxtMes.text.toString())
                                            año11211cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 11
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        11 -> {
                                            cultivados11212.setValue(editTxtCultivados.text.toString())
                                            dia11212cult.setValue(editTxtDia.text.toString())
                                            mes11212cult.setValue(editTxtMes.text.toString())
                                            año11212cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 12
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        12 -> {
                                            cultivados11213.setValue(editTxtCultivados.text.toString())
                                            dia11213cult.setValue(editTxtDia.text.toString())
                                            mes11213cult.setValue(editTxtMes.text.toString())
                                            año11213cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 13
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        13 -> {
                                            cultivados11214.setValue(editTxtCultivados.text.toString())
                                            dia11214cult.setValue(editTxtDia.text.toString())
                                            mes11214cult.setValue(editTxtMes.text.toString())
                                            año11214cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 14
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        14 -> {
                                            cultivados11215.setValue(editTxtCultivados.text.toString())
                                            dia11215cult.setValue(editTxtDia.text.toString())
                                            mes11215cult.setValue(editTxtMes.text.toString())
                                            año11215cult.setValue(editTxtAño.text.toString())
                                            contadorcultivados112 = 15
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                        15 -> {
                                            botonGuardarZonas.visibility = View.INVISIBLE
                                            contadorcultivados112 = 16
                                            contcultivados112.setValue(contadorcultivados112)
                                        }
                                    }
                                }
                            ////////////////////////////////////
                        }else
                            if (idzona == 3) {
                                if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                    when(contadorembolsados113) {
                                        0 -> {
                                            embolsados1131.setValue(editTxtEmbolsados.text.toString())
                                            dia1131.setValue(editTxtDia.text.toString())
                                            mes1131.setValue(editTxtMes.text.toString())
                                            año1131.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 1
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        1 -> {
                                            embolsados1132.setValue(editTxtEmbolsados.text.toString())
                                            dia1132.setValue(editTxtDia.text.toString())
                                            mes1132.setValue(editTxtMes.text.toString())
                                            año1132.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 2
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        2 -> {
                                            embolsados1133.setValue(editTxtEmbolsados.text.toString())
                                            dia1133.setValue(editTxtDia.text.toString())
                                            mes1133.setValue(editTxtMes.text.toString())
                                            año1133.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 3
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        3 -> {
                                            embolsados1134.setValue(editTxtEmbolsados.text.toString())
                                            dia1134.setValue(editTxtDia.text.toString())
                                            mes1134.setValue(editTxtMes.text.toString())
                                            año1134.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 4
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        4 -> {
                                            embolsados1135.setValue(editTxtEmbolsados.text.toString())
                                            dia1135.setValue(editTxtDia.text.toString())
                                            mes1135.setValue(editTxtMes.text.toString())
                                            año1135.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 5
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        5 -> {
                                            embolsados1136.setValue(editTxtEmbolsados.text.toString())
                                            dia1136.setValue(editTxtDia.text.toString())
                                            mes1136.setValue(editTxtMes.text.toString())
                                            año1136.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 6
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        6 -> {
                                            embolsados1137.setValue(editTxtEmbolsados.text.toString())
                                            dia1137.setValue(editTxtDia.text.toString())
                                            mes1137.setValue(editTxtMes.text.toString())
                                            año1137.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 7
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        7 -> {
                                            embolsados1138.setValue(editTxtEmbolsados.text.toString())
                                            dia1138.setValue(editTxtDia.text.toString())
                                            mes1138.setValue(editTxtMes.text.toString())
                                            año1138.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 8
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        8 -> {
                                            embolsados1139.setValue(editTxtEmbolsados.text.toString())
                                            dia1139.setValue(editTxtDia.text.toString())
                                            mes1139.setValue(editTxtMes.text.toString())
                                            año1139.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 9
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        9 -> {
                                            embolsados11310.setValue(editTxtEmbolsados.text.toString())
                                            dia11310.setValue(editTxtDia.text.toString())
                                            mes11310.setValue(editTxtMes.text.toString())
                                            año11310.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 10
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        10 -> {
                                            embolsados11311.setValue(editTxtEmbolsados.text.toString())
                                            dia11311.setValue(editTxtDia.text.toString())
                                            mes11311.setValue(editTxtMes.text.toString())
                                            año11311.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 11
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        11 -> {
                                            embolsados11312.setValue(editTxtEmbolsados.text.toString())
                                            dia11312.setValue(editTxtDia.text.toString())
                                            mes11312.setValue(editTxtMes.text.toString())
                                            año11312.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 12
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        12 -> {
                                            embolsados11313.setValue(editTxtEmbolsados.text.toString())
                                            dia11313.setValue(editTxtDia.text.toString())
                                            mes11313.setValue(editTxtMes.text.toString())
                                            año11313.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 13
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        13 -> {
                                            embolsados11314.setValue(editTxtEmbolsados.text.toString())
                                            dia11314.setValue(editTxtDia.text.toString())
                                            mes11314.setValue(editTxtMes.text.toString())
                                            año11314.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 14
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        14 -> {
                                            embolsados11315.setValue(editTxtEmbolsados.text.toString())
                                            dia11315.setValue(editTxtDia.text.toString())
                                            mes11315.setValue(editTxtMes.text.toString())
                                            año11315.setValue(editTxtAño.text.toString())
                                            contadorembolsados113 = 15
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                        15 -> {
                                            botonGuardarZonas.visibility = View.INVISIBLE
                                            contadorembolsados113 = 16
                                            contembolsados113.setValue(contadorembolsados113)
                                        }
                                    }
                                }else
                                    if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                        when(contadorcultivados113) {
                                            0 -> {
                                                cultivados1131.setValue(editTxtCultivados.text.toString())
                                                dia1131cult.setValue(editTxtDia.text.toString())
                                                mes1131cult.setValue(editTxtMes.text.toString())
                                                año1131cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 1
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            1 -> {
                                                cultivados1132.setValue(editTxtCultivados.text.toString())
                                                dia1132cult.setValue(editTxtDia.text.toString())
                                                mes1132cult.setValue(editTxtMes.text.toString())
                                                año1132cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 2
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            2 -> {
                                                cultivados1133.setValue(editTxtCultivados.text.toString())
                                                dia1133cult.setValue(editTxtDia.text.toString())
                                                mes1133cult.setValue(editTxtMes.text.toString())
                                                año1133cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 3
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            3 -> {
                                                cultivados1134.setValue(editTxtCultivados.text.toString())
                                                dia1134cult.setValue(editTxtDia.text.toString())
                                                mes1134cult.setValue(editTxtMes.text.toString())
                                                año1134cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 4
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            4 -> {
                                                cultivados1135.setValue(editTxtCultivados.text.toString())
                                                dia1135cult.setValue(editTxtDia.text.toString())
                                                mes1135cult.setValue(editTxtMes.text.toString())
                                                año1135cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 5
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            5 -> {
                                                cultivados1136.setValue(editTxtCultivados.text.toString())
                                                dia1136cult.setValue(editTxtDia.text.toString())
                                                mes1136cult.setValue(editTxtMes.text.toString())
                                                año1136cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 6
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            6 -> {
                                                cultivados1137.setValue(editTxtCultivados.text.toString())
                                                dia1137cult.setValue(editTxtDia.text.toString())
                                                mes1137cult.setValue(editTxtMes.text.toString())
                                                año1137cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 7
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            7 -> {
                                                cultivados1138.setValue(editTxtCultivados.text.toString())
                                                dia1138cult.setValue(editTxtDia.text.toString())
                                                mes1138cult.setValue(editTxtMes.text.toString())
                                                año1138cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 8
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            8 -> {
                                                cultivados1139.setValue(editTxtCultivados.text.toString())
                                                dia1139cult.setValue(editTxtDia.text.toString())
                                                mes1139cult.setValue(editTxtMes.text.toString())
                                                año1139cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 9
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            9 -> {
                                                cultivados11310.setValue(editTxtCultivados.text.toString())
                                                dia11310cult.setValue(editTxtDia.text.toString())
                                                mes11310cult.setValue(editTxtMes.text.toString())
                                                año11310cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 10
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            10 -> {
                                                cultivados11311.setValue(editTxtCultivados.text.toString())
                                                dia11311cult.setValue(editTxtDia.text.toString())
                                                mes11311cult.setValue(editTxtMes.text.toString())
                                                año11311cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 11
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            11 -> {
                                                cultivados11312.setValue(editTxtCultivados.text.toString())
                                                dia11312cult.setValue(editTxtDia.text.toString())
                                                mes11312cult.setValue(editTxtMes.text.toString())
                                                año11312cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 12
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            12 -> {
                                                cultivados11313.setValue(editTxtCultivados.text.toString())
                                                dia11313cult.setValue(editTxtDia.text.toString())
                                                mes11313cult.setValue(editTxtMes.text.toString())
                                                año11313cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 13
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            13 -> {
                                                cultivados11314.setValue(editTxtCultivados.text.toString())
                                                dia11314cult.setValue(editTxtDia.text.toString())
                                                mes11314cult.setValue(editTxtMes.text.toString())
                                                año11314cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 14
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            14 -> {
                                                cultivados11315.setValue(editTxtCultivados.text.toString())
                                                dia11315cult.setValue(editTxtDia.text.toString())
                                                mes11315cult.setValue(editTxtMes.text.toString())
                                                año11315cult.setValue(editTxtAño.text.toString())
                                                contadorcultivados113 = 15
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                            15 -> {
                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                contadorcultivados113 = 16
                                                contcultivados113.setValue(contadorcultivados113)
                                            }
                                        }
                                    }
                                ////////////////////////////////
                            }else
                                if (idzona == 4) {
                                    if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                        when(contadorembolsados114) {
                                            0 -> {
                                                embolsados1121.setValue(editTxtEmbolsados.text.toString())
                                                dia1121.setValue(editTxtDia.text.toString())
                                                mes1121.setValue(editTxtMes.text.toString())
                                                año1121.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 1
                                                contembolsados114.setValue(contadorembolsados114)

                                            }
                                            1 -> {
                                                embolsados1122.setValue(editTxtEmbolsados.text.toString())
                                                dia1122.setValue(editTxtDia.text.toString())
                                                mes1122.setValue(editTxtMes.text.toString())
                                                año1122.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 2
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            2 -> {
                                                embolsados1123.setValue(editTxtEmbolsados.text.toString())
                                                dia1123.setValue(editTxtDia.text.toString())
                                                mes1123.setValue(editTxtMes.text.toString())
                                                año1123.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 3
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            3 -> {
                                                embolsados1124.setValue(editTxtEmbolsados.text.toString())
                                                dia1124.setValue(editTxtDia.text.toString())
                                                mes1124.setValue(editTxtMes.text.toString())
                                                año1124.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 4
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            4 -> {
                                                embolsados1125.setValue(editTxtEmbolsados.text.toString())
                                                dia1125.setValue(editTxtDia.text.toString())
                                                mes1125.setValue(editTxtMes.text.toString())
                                                año1125.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 5
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            5 -> {
                                                embolsados1126.setValue(editTxtEmbolsados.text.toString())
                                                dia1126.setValue(editTxtDia.text.toString())
                                                mes1126.setValue(editTxtMes.text.toString())
                                                año1126.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 6
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            6 -> {
                                                embolsados1127.setValue(editTxtEmbolsados.text.toString())
                                                dia1127.setValue(editTxtDia.text.toString())
                                                mes1127.setValue(editTxtMes.text.toString())
                                                año1127.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 7
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            7 -> {
                                                embolsados1128.setValue(editTxtEmbolsados.text.toString())
                                                dia1128.setValue(editTxtDia.text.toString())
                                                mes1128.setValue(editTxtMes.text.toString())
                                                año1128.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 8
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            8 -> {
                                                embolsados1129.setValue(editTxtEmbolsados.text.toString())
                                                dia1129.setValue(editTxtDia.text.toString())
                                                mes1129.setValue(editTxtMes.text.toString())
                                                año1129.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 9
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            9 -> {
                                                embolsados11210.setValue(editTxtEmbolsados.text.toString())
                                                dia11210.setValue(editTxtDia.text.toString())
                                                mes11210.setValue(editTxtMes.text.toString())
                                                año11210.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 10
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            10 -> {
                                                embolsados11211.setValue(editTxtEmbolsados.text.toString())
                                                dia11211.setValue(editTxtDia.text.toString())
                                                mes11211.setValue(editTxtMes.text.toString())
                                                año11211.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 11
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            11 -> {
                                                embolsados11212.setValue(editTxtEmbolsados.text.toString())
                                                dia11212.setValue(editTxtDia.text.toString())
                                                mes11212.setValue(editTxtMes.text.toString())
                                                año11212.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 12
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            12 -> {
                                                embolsados11213.setValue(editTxtEmbolsados.text.toString())
                                                dia11213.setValue(editTxtDia.text.toString())
                                                mes11213.setValue(editTxtMes.text.toString())
                                                año11213.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 13
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            13 -> {
                                                embolsados11214.setValue(editTxtEmbolsados.text.toString())
                                                dia11214.setValue(editTxtDia.text.toString())
                                                mes11214.setValue(editTxtMes.text.toString())
                                                año11214.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 14
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            14 -> {
                                                embolsados11215.setValue(editTxtEmbolsados.text.toString())
                                                dia11215.setValue(editTxtDia.text.toString())
                                                mes11215.setValue(editTxtMes.text.toString())
                                                año11215.setValue(editTxtAño.text.toString())
                                                contadorembolsados114 = 15
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                            15 -> {
                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                contadorembolsados114 = 16
                                                contembolsados114.setValue(contadorembolsados114)
                                            }
                                        }
                                    }else
                                        if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtAño.text.isNotEmpty()) {
                                            when(contadorcultivados114) {
                                                0 -> {
                                                    cultivados1121.setValue(editTxtCultivados.text.toString())
                                                    dia1121cult.setValue(editTxtDia.text.toString())
                                                    mes1121cult.setValue(editTxtMes.text.toString())
                                                    año1121cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 1
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                1 -> {
                                                    cultivados1122.setValue(editTxtCultivados.text.toString())
                                                    dia1122cult.setValue(editTxtDia.text.toString())
                                                    mes1122cult.setValue(editTxtMes.text.toString())
                                                    año1122cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 2
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                2 -> {
                                                    cultivados1123.setValue(editTxtCultivados.text.toString())
                                                    dia1123cult.setValue(editTxtDia.text.toString())
                                                    mes1123cult.setValue(editTxtMes.text.toString())
                                                    año1123cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 3
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                3 -> {
                                                    cultivados1124.setValue(editTxtCultivados.text.toString())
                                                    dia1124cult.setValue(editTxtDia.text.toString())
                                                    mes1124cult.setValue(editTxtMes.text.toString())
                                                    año1124cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 4
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                4 -> {
                                                    cultivados1125.setValue(editTxtCultivados.text.toString())
                                                    dia1125cult.setValue(editTxtDia.text.toString())
                                                    mes1125cult.setValue(editTxtMes.text.toString())
                                                    año1125cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 5
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                5 -> {
                                                    cultivados1126.setValue(editTxtCultivados.text.toString())
                                                    dia1126cult.setValue(editTxtDia.text.toString())
                                                    mes1126cult.setValue(editTxtMes.text.toString())
                                                    año1126cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 6
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                6 -> {
                                                    cultivados1127.setValue(editTxtCultivados.text.toString())
                                                    dia1127cult.setValue(editTxtDia.text.toString())
                                                    mes1127cult.setValue(editTxtMes.text.toString())
                                                    año1127cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 7
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                7 -> {
                                                    cultivados1128.setValue(editTxtCultivados.text.toString())
                                                    dia1128cult.setValue(editTxtDia.text.toString())
                                                    mes1128cult.setValue(editTxtMes.text.toString())
                                                    año1128cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 8
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                8 -> {
                                                    cultivados1129.setValue(editTxtCultivados.text.toString())
                                                    dia1129cult.setValue(editTxtDia.text.toString())
                                                    mes1129cult.setValue(editTxtMes.text.toString())
                                                    año1129cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 9
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                9 -> {
                                                    cultivados11210.setValue(editTxtCultivados.text.toString())
                                                    dia11210cult.setValue(editTxtDia.text.toString())
                                                    mes11210cult.setValue(editTxtMes.text.toString())
                                                    año11210cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 10
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                10 -> {
                                                    cultivados11211.setValue(editTxtCultivados.text.toString())
                                                    dia11211cult.setValue(editTxtDia.text.toString())
                                                    mes11211cult.setValue(editTxtMes.text.toString())
                                                    año11211cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 11
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                11 -> {
                                                    cultivados11212.setValue(editTxtCultivados.text.toString())
                                                    dia11212cult.setValue(editTxtDia.text.toString())
                                                    mes11212cult.setValue(editTxtMes.text.toString())
                                                    año11212cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 12
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                12 -> {
                                                    cultivados11213.setValue(editTxtCultivados.text.toString())
                                                    dia11213cult.setValue(editTxtDia.text.toString())
                                                    mes11213cult.setValue(editTxtMes.text.toString())
                                                    año11213cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 13
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                13 -> {
                                                    cultivados11214.setValue(editTxtCultivados.text.toString())
                                                    dia11214cult.setValue(editTxtDia.text.toString())
                                                    mes11214cult.setValue(editTxtMes.text.toString())
                                                    año11214cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 14
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                14 -> {
                                                    cultivados11215.setValue(editTxtCultivados.text.toString())
                                                    dia11215cult.setValue(editTxtDia.text.toString())
                                                    mes11215cult.setValue(editTxtMes.text.toString())
                                                    año11215cult.setValue(editTxtAño.text.toString())
                                                    contadorcultivados114 = 15
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                                15 -> {
                                                    botonGuardarZonas.visibility = View.INVISIBLE
                                                    contadorcultivados114 = 16
                                                    contcultivados114.setValue(contadorcultivados114)
                                                }
                                            }
                                        }
                                }
                } //propiedad
            } // setonclick
        } // global launcher
    } // on create
} // class
                    /** propiedad 2
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
                    }**/