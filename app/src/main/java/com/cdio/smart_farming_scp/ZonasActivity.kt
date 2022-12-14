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
import com.cdio.smart_farming_scp.databinding.ActivityZonasBinding
import kotlinx.android.synthetic.main.activity_propiedades.*

class ZonasActivity : AppCompatActivity() {

        private lateinit var binding: ActivityZonasBinding

        var idprop=0
        var idzona=0
        // usuario 1
                // propiedad 1
                var contadorcultivados111 = 0
                var contadorembolsados111 = 0
                var contadorcultivados112 = 0
                var contadorembolsados112 = 0
                var contadorcultivados113 = 0
                var contadorembolsados113 = 0
                // propiedad 2
                var contadorcultivados121 = 0
                var contadorembolsados121 = 0
                var contadorcultivados122 = 0
                var contadorembolsados122 = 0
                var contadorcultivados123 = 0
                var contadorembolsados123 = 0

        private val database = Firebase.database
        // ID
        private var id_botonprop = database.getReference("ID/IDBOTONPROPIEDAD")
        private var id_botonzona = database.getReference("ID/IDBOTONZONA")

        ////// usuario 1
                ////// propiedad 1

                // CONTADORES FECHAS
                private var contcultivados111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/CONTCULTIVADOS111")
                private var contembolsados111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/CONTEMBOLSADOS111")
                private var contcultivados112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/CONTCULTIVADOS112")
                private var contembolsados112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/CONTEMBOLSADOS112")
                private var contcultivados113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/CONTCULTIVADOS113")
                private var contembolsados113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/CONTEMBOLSADOS113")

                // FECHA 1 propiedad 1
                private var cultivados1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/CULTIVADOS1111")
                private var dia1111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/dia1111cult")
                private var mes1111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/mes1111cult")
                private var a??o1111cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/a??o1111cult")
                private var embolsados1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/EMBOLSADOS1111")
                private var dia1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/dia1111")
                private var mes1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/mes1111")
                private var a??o1111 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1111/a??o1111")

                private var cultivados1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/CULTIVADOS1121")
                private var dia1121cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/dia1121cult")
                private var mes1121cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/mes1121cult")
                private var a??o1121cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/a??o1121cult")
                private var embolsados1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/EMBOLSADOS1121")
                private var dia1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/dia1121")
                private var mes1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/mes1121")
                private var a??o1121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1121/a??o1121")

                private var cultivados1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/CULTIVADOS1131")
                private var dia1131cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/dia1131cult")
                private var mes1131cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/mes1131cult")
                private var a??o1131cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/a??o1131cult")
                private var embolsados1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/EMBOLSADOS1131")
                private var dia1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/dia1131")
                private var mes1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/mes1131")
                private var a??o1131 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1131/a??o1131")

                // FECHA 2 propiedad 1
                private var cultivados1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/CULTIVADOS1112")
                private var dia1112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/dia1112cult")
                private var mes1112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/mes1112cult")
                private var a??o1112cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/a??o1112cult")
                private var embolsados1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/EMBOLSADOS1112")
                private var dia1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/dia1112")
                private var mes1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/mes1112")
                private var a??o1112 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1112/a??o1112")

                private var cultivados1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/CULTIVADOS1122")
                private var dia1122cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/dia1122cult")
                private var mes1122cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/mes1122cult")
                private var a??o1122cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/a??o1122cult")
                private var embolsados1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/EMBOLSADOS1122")
                private var dia1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/dia1122")
                private var mes1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/mes1122")
                private var a??o1122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1122/a??o1122")

                private var cultivados1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/CULTIVADOS1132")
                private var dia1132cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/dia1132cult")
                private var mes1132cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/mes1132cult")
                private var a??o1132cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/a??o1132cult")
                private var embolsados1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/EMBOLSADOS1132")
                private var dia1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/dia1132")
                private var mes1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/mes1132")
                private var a??o1132 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1132/a??o1132")

                // FECHA 3 propiedad 1
                private var cultivados1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/CULTIVADOS1113")
                private var dia1113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/dia1113cult")
                private var mes1113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/mes1113cult")
                private var a??o1113cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/a??o1113cult")
                private var embolsados1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/EMBOLSADOS1113")
                private var dia1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/dia1113")
                private var mes1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/mes1113")
                private var a??o1113 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1113/a??o1113")

                private var cultivados1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/CULTIVADOS1123")
                private var dia1123cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/dia1123cult")
                private var mes1123cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/mes1123cult")
                private var a??o1123cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/a??o1123cult")
                private var embolsados1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/EMBOLSADOS1123")
                private var dia1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/dia1123")
                private var mes1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/mes1123")
                private var a??o1123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1123/a??o1123")

                private var cultivados1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/CULTIVADOS1133")
                private var dia1133cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/dia1133cult")
                private var mes1133cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/mes1133cult")
                private var a??o1133cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/a??o1133cult")
                private var embolsados1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/EMBOLSADOS1133")
                private var dia1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/dia1133")
                private var mes1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/mes1133")
                private var a??o1133 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1133/a??o1133")

                // FECHA 4 propiedad 1
                private var cultivados1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/CULTIVADOS1114")
                private var dia1114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/dia1114cult")
                private var mes1114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/mes1114cult")
                private var a??o1114cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/a??o1114cult")
                private var embolsados1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/EMBOLSADOS1114")
                private var dia1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/dia1114")
                private var mes1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/mes1114")
                private var a??o1114 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1114/a??o1114")

                private var cultivados1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/CULTIVADOS1124")
                private var dia1124cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/dia1124cult")
                private var mes1124cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/mes1124cult")
                private var a??o1124cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/a??o1124cult")
                private var embolsados1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/EMBOLSADOS1124")
                private var dia1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/dia1124")
                private var mes1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/mes1124")
                private var a??o1124 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1124/a??o1124")

                private var cultivados1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/CULTIVADOS1134")
                private var dia1134cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/dia1134cult")
                private var mes1134cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/mes1134cult")
                private var a??o1134cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/a??o1134cult")
                private var embolsados1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/EMBOLSADOS1134")
                private var dia1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/dia1134")
                private var mes1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/mes1134")
                private var a??o1134 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1134/a??o1134")

                // FECHA 5 propiedad 1
                private var cultivados1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/CULTIVADOS1115")
                private var dia1115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/dia1115cult")
                private var mes1115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/mes1115cult")
                private var a??o1115cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/a??o1115cult")
                private var embolsados1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/EMBOLSADOS1115")
                private var dia1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/dia1115")
                private var mes1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/mes1115")
                private var a??o1115 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1115/a??o1115")

                private var cultivados1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/CULTIVADOS1125")
                private var dia1125cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/dia1125cult")
                private var mes1125cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/mes1125cult")
                private var a??o1125cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/a??o1125cult")
                private var embolsados1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/EMBOLSADOS1125")
                private var dia1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/dia1125")
                private var mes1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/mes1125")
                private var a??o1125 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1125/a??o1125")

                private var cultivados1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/CULTIVADOS1135")
                private var dia1135cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/dia1135cult")
                private var mes1135cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/mes1135cult")
                private var a??o1135cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/a??o1135cult")
                private var embolsados1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/EMBOLSADOS1135")
                private var dia1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/dia1135")
                private var mes1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/mes1135")
                private var a??o1135 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1135/a??o1135")

                // FECHA 6 propiedad 1
                private var cultivados1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/CULTIVADOS1116")
                private var dia1116cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/dia1116cult")
                private var mes1116cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/mes1116cult")
                private var a??o1116cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/a??o1116cult")
                private var embolsados1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/EMBOLSADOS1116")
                private var dia1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/dia1116")
                private var mes1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/mes1116")
                private var a??o1116 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1116/a??o1116")

                private var cultivados1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/CULTIVADOS1126")
                private var dia1126cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/dia1126cult")
                private var mes1126cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/mes1126cult")
                private var a??o1126cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/a??o1126cult")
                private var embolsados1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/EMBOLSADOS1126")
                private var dia1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/dia1126")
                private var mes1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/mes1126")
                private var a??o1126 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1126/a??o1126")

                private var cultivados1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/CULTIVADOS1136")
                private var dia1136cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/dia1136cult")
                private var mes1136cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/mes1136cult")
                private var a??o1136cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/a??o1136cult")
                private var embolsados1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/EMBOLSADOS1136")
                private var dia1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/dia1136")
                private var mes1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/mes1136")
                private var a??o1136 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1136/a??o1136")

                // FECHA 7 propiedad 1
                private var cultivados1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/CULTIVADOS1117")
                private var dia1117cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/dia1117cult")
                private var mes1117cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/mes1117cult")
                private var a??o1117cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/a??o1117cult")
                private var embolsados1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/EMBOLSADOS1117")
                private var dia1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/dia1117")
                private var mes1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/mes1117")
                private var a??o1117 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1117/a??o1117")

                private var cultivados1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/CULTIVADOS1127")
                private var dia1127cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/dia1127cult")
                private var mes1127cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/mes1127cult")
                private var a??o1127cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/a??o1127cult")
                private var embolsados1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/EMBOLSADOS1127")
                private var dia1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/dia1127")
                private var mes1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/mes1127")
                private var a??o1127 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1127/a??o1127")

                private var cultivados1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/CULTIVADOS1137")
                private var dia1137cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/dia1137cult")
                private var mes1137cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/mes1137cult")
                private var a??o1137cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/a??o1137cult")
                private var embolsados1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/EMBOLSADOS1137")
                private var dia1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/dia1137")
                private var mes1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/mes1137")
                private var a??o1137 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1137/a??o1137")

                // FECHA 8 propiedad 1
                private var cultivados1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/CULTIVADOS1118")
                private var dia1118cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/dia1118cult")
                private var mes1118cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/mes1118cult")
                private var a??o1118cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/a??o1118cult")
                private var embolsados1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/EMBOLSADOS1118")
                private var dia1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/dia1118")
                private var mes1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/mes1118")
                private var a??o1118 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1118/a??o1118")

                private var cultivados1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/CULTIVADOS1128")
                private var dia1128cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/dia1128cult")
                private var mes1128cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/mes1128cult")
                private var a??o1128cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/a??o1128cult")
                private var embolsados1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/EMBOLSADOS1128")
                private var dia1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/dia1128")
                private var mes1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/mes1128")
                private var a??o1128 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1128/a??o1128")

                private var cultivados1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/CULTIVADOS1138")
                private var dia1138cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/dia1138cult")
                private var mes1138cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/mes1138cult")
                private var a??o1138cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/a??o1138cult")
                private var embolsados1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/EMBOLSADOS1138")
                private var dia1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/dia1138")
                private var mes1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/mes1138")
                private var a??o1138 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1138/a??o1138")

                // FECHA 9 propiedad 1
                private var cultivados1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/CULTIVADOS1119")
                private var dia1119cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/dia1119cult")
                private var mes1119cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/mes1119cult")
                private var a??o1119cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/a??o1119cult")
                private var embolsados1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/EMBOLSADOS1119")
                private var dia1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/dia1119")
                private var mes1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/mes1119")
                private var a??o1119 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV1119/a??o1119")

                private var cultivados1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/CULTIVADOS1129")
                private var dia1129cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/dia1129cult")
                private var mes1129cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/mes1129cult")
                private var a??o1129cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/a??o1129cult")
                private var embolsados1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/EMBOLSADOS1129")
                private var dia1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/dia1129")
                private var mes1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/mes1129")
                private var a??o1129 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV1129/a??o1129")

                private var cultivados1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/CULTIVADOS1139")
                private var dia1139cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/dia1139cult")
                private var mes1139cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/mes1139cult")
                private var a??o1139cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/a??o1139cult")
                private var embolsados1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/EMBOLSADOS1139")
                private var dia1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/dia1139")
                private var mes1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/mes1139")
                private var a??o1139 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV1139/a??o1139")

                // FECHA 10 propiedad 1
                private var cultivados11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/CULTIVADOS11110")
                private var dia11110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/dia11110cult")
                private var mes11110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/mes11110cult")
                private var a??o11110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/a??o11110cult")
                private var embolsados11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/EMBOLSADOS11110")
                private var dia11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/dia11110")
                private var mes11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/mes11110")
                private var a??o11110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA111/FECHAINV11110/a??o11110")

                private var cultivados11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/CULTIVADOS11210")
                private var dia11210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/dia11210cult")
                private var mes11210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/mes11210cult")
                private var a??o11210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/a??o11210cult")
                private var embolsados11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/EMBOLSADOS11210")
                private var dia11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/dia11210")
                private var mes11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/mes11210")
                private var a??o11210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA112/FECHAINV11210/a??o11210")

                private var cultivados11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/CULTIVADOS11310")
                private var dia11310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/dia11310cult")
                private var mes11310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/mes11310cult")
                private var a??o11310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/a??o11310cult")
                private var embolsados11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/EMBOLSADOS11310")
                private var dia11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/dia11310")
                private var mes11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/mes11310")
                private var a??o11310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD11/ZONA113/FECHAINV11310/a??o11310")

                ////// propiedad 2

                // CONTADORES FECHAS
                private var contcultivados121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/CONTCULTIVADOS121")
                private var contembolsados121 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/CONTEMBOLSADOS121")
                private var contcultivados122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/CONTCULTIVADOS122")
                private var contembolsados122 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/CONTEMBOLSADOS122")
                private var contcultivados123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/CONTCULTIVADOS123")
                private var contembolsados123 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/CONTEMBOLSADOS123")

                // FECHA 1 propiedad 2
                private var cultivados1211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/CULTIVADOS1211")
                private var dia1211cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/dia1211cult")
                private var mes1211cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/mes1211cult")
                private var a??o1211cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/a??o1211cult")
                private var embolsados1211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/EMBOLSADOS1211")
                private var dia1211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/dia1211")
                private var mes1211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/mes1211")
                private var a??o1211 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1211/a??o1211")

                private var cultivados1221 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/CULTIVADOS1221")
                private var dia1221cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/dia1221cult")
                private var mes1221cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/mes1221cult")
                private var a??o1221cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/a??o1221cult")
                private var embolsados1221 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/EMBOLSADOS1221")
                private var dia1221 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/dia1221")
                private var mes1221 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/mes1221")
                private var a??o1221 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1221/a??o1221")

                private var cultivados1231 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/CULTIVADOS1231")
                private var dia1231cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/dia1231cult")
                private var mes1231cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/mes1231cult")
                private var a??o1231cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/a??o1231cult")
                private var embolsados1231 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/EMBOLSADOS1231")
                private var dia1231 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/dia1231")
                private var mes1231 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/mes1231")
                private var a??o1231 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1231/a??o1231")

                // FECHA 2 propiedad 2
                private var cultivados1212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/CULTIVADOS1212")
                private var dia1212cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/dia1212cult")
                private var mes1212cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/mes1212cult")
                private var a??o1212cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/a??o1212cult")
                private var embolsados1212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/EMBOLSADOS1212")
                private var dia1212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/dia1212")
                private var mes1212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/mes1212")
                private var a??o1212 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1212/a??o1212")

                private var cultivados1222 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/CULTIVADOS1222")
                private var dia1222cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/dia1222cult")
                private var mes1222cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/mes1222cult")
                private var a??o1222cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/a??o1222cult")
                private var embolsados1222 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/EMBOLSADOS1222")
                private var dia1222 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/dia1222")
                private var mes1222 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/mes1222")
                private var a??o1222 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1222/a??o1222")

                private var cultivados1232 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/CULTIVADOS1232")
                private var dia1232cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/dia1232cult")
                private var mes1232cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/mes1232cult")
                private var a??o1232cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/a??o1232cult")
                private var embolsados1232 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/EMBOLSADOS1232")
                private var dia1232 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/dia1232")
                private var mes1232 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/mes1232")
                private var a??o1232 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1232/a??o1232")

                // FECHA 3 propiedad 2
                private var cultivados1213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/CULTIVADOS1213")
                private var dia1213cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/dia1213cult")
                private var mes1213cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/mes1213cult")
                private var a??o1213cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/a??o1213cult")
                private var embolsados1213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/EMBOLSADOS1213")
                private var dia1213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/dia1213")
                private var mes1213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/mes1213")
                private var a??o1213 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1213/a??o1213")

                private var cultivados1223 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/CULTIVADOS1223")
                private var dia1223cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/dia1223cult")
                private var mes1223cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/mes1223cult")
                private var a??o1223cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/a??o1223cult")
                private var embolsados1223 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/EMBOLSADOS1223")
                private var dia1223 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/dia1223")
                private var mes1223 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/mes1223")
                private var a??o1223 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1223/a??o1223")

                private var cultivados1233 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/CULTIVADOS1233")
                private var dia1233cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/dia1233cult")
                private var mes1233cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/mes1233cult")
                private var a??o1233cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/a??o1233cult")
                private var embolsados1233 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/EMBOLSADOS1233")
                private var dia1233 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/dia1233")
                private var mes1233 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/mes1233")
                private var a??o1233 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1233/a??o1233")

                // FECHA 4 propiedad 2
                private var cultivados1214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/CULTIVADOS1214")
                private var dia1214cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/dia1214cult")
                private var mes1214cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/mes1214cult")
                private var a??o1214cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/a??o1214cult")
                private var embolsados1214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/EMBOLSADOS1214")
                private var dia1214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/dia1214")
                private var mes1214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/mes1214")
                private var a??o1214 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1214/a??o1214")

                private var cultivados1224 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/CULTIVADOS1224")
                private var dia1224cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/dia1224cult")
                private var mes1224cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/mes1224cult")
                private var a??o1224cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/a??o1224cult")
                private var embolsados1224 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/EMBOLSADOS1224")
                private var dia1224 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/dia1224")
                private var mes1224 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/mes1224")
                private var a??o1224 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1224/a??o1224")

                private var cultivados1234 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/CULTIVADOS1234")
                private var dia1234cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/dia1234cult")
                private var mes1234cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/mes1234cult")
                private var a??o1234cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/a??o1234cult")
                private var embolsados1234 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/EMBOLSADOS1234")
                private var dia1234 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/dia1234")
                private var mes1234 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/mes1234")
                private var a??o1234 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1234/a??o1234")

                // FECHA 5 propiedad 2
                private var cultivados1215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/CULTIVADOS1215")
                private var dia1215cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/dia1215cult")
                private var mes1215cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/mes1215cult")
                private var a??o1215cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/a??o1215cult")
                private var embolsados1215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/EMBOLSADOS1215")
                private var dia1215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/dia1215")
                private var mes1215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/mes1215")
                private var a??o1215 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1215/a??o1215")

                private var cultivados1225 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/CULTIVADOS1225")
                private var dia1225cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/dia1225cult")
                private var mes1225cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/mes1225cult")
                private var a??o1225cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/a??o1225cult")
                private var embolsados1225 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/EMBOLSADOS1225")
                private var dia1225 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/dia1225")
                private var mes1225 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/mes1225")
                private var a??o1225 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1225/a??o1225")

                private var cultivados1235 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/CULTIVADOS1235")
                private var dia1235cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/dia1235cult")
                private var mes1235cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/mes1235cult")
                private var a??o1235cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/a??o1235cult")
                private var embolsados1235 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/EMBOLSADOS1235")
                private var dia1235 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/dia1235")
                private var mes1235 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/mes1235")
                private var a??o1235 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1235/a??o1235")

                // FECHA 6 propiedad 2
                private var cultivados1216 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/CULTIVADOS1216")
                private var dia1216cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/dia1216cult")
                private var mes1216cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/mes1216cult")
                private var a??o1216cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/a??o1216cult")
                private var embolsados1216 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/EMBOLSADOS1216")
                private var dia1216 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/dia1216")
                private var mes1216 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/mes1216")
                private var a??o1216 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1216/a??o1216")

                private var cultivados1226 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/CULTIVADOS1226")
                private var dia1226cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/dia1226cult")
                private var mes1226cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/mes1226cult")
                private var a??o1226cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/a??o1226cult")
                private var embolsados1226 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/EMBOLSADOS1226")
                private var dia1226 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/dia1226")
                private var mes1226 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/mes1226")
                private var a??o1226 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1226/a??o1226")

                private var cultivados1236 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/CULTIVADOS1236")
                private var dia1236cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/dia1236cult")
                private var mes1236cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/mes1236cult")
                private var a??o1236cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/a??o1236cult")
                private var embolsados1236 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/EMBOLSADOS1236")
                private var dia1236 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/dia1236")
                private var mes1236 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/mes1236")
                private var a??o1236 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1236/a??o1236")

                // FECHA 7 propiedad 2
                private var cultivados1217 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/CULTIVADOS1217")
                private var dia1217cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/dia1217cult")
                private var mes1217cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/mes1217cult")
                private var a??o1217cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/a??o1217cult")
                private var embolsados1217 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/EMBOLSADOS1217")
                private var dia1217 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/dia1217")
                private var mes1217 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/mes1217")
                private var a??o1217 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1217/a??o1217")

                private var cultivados1227 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/CULTIVADOS1227")
                private var dia1227cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/dia1227cult")
                private var mes1227cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/mes1227cult")
                private var a??o1227cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/a??o1227cult")
                private var embolsados1227 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/EMBOLSADOS1227")
                private var dia1227 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/dia1227")
                private var mes1227 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/mes1227")
                private var a??o1227 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1227/a??o1227")

                private var cultivados1237 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/CULTIVADOS1237")
                private var dia1237cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/dia1237cult")
                private var mes1237cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/mes1237cult")
                private var a??o1237cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/a??o1237cult")
                private var embolsados1237 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/EMBOLSADOS1237")
                private var dia1237 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/dia1237")
                private var mes1237 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/mes1237")
                private var a??o1237 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1237/a??o1237")

                // FECHA 8 propiedad 2
                private var cultivados1218 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/CULTIVADOS1218")
                private var dia1218cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/dia1218cult")
                private var mes1218cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/mes1218cult")
                private var a??o1218cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/a??o1218cult")
                private var embolsados1218 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/EMBOLSADOS1218")
                private var dia1218 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/dia1218")
                private var mes1218 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/mes1218")
                private var a??o1218 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1218/a??o1218")

                private var cultivados1228 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/CULTIVADOS1228")
                private var dia1228cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/dia1228cult")
                private var mes1228cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/mes1228cult")
                private var a??o1228cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/a??o1228cult")
                private var embolsados1228 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/EMBOLSADOS1228")
                private var dia1228 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/dia1228")
                private var mes1228 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/mes1228")
                private var a??o1228 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1228/a??o1228")

                private var cultivados1238 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/CULTIVADOS1238")
                private var dia1238cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/dia1238cult")
                private var mes1238cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/mes1238cult")
                private var a??o1238cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/a??o1238cult")
                private var embolsados1238 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/EMBOLSADOS1238")
                private var dia1238 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/dia1238")
                private var mes1238 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/mes1238")
                private var a??o1238 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1238/a??o1238")

                // FECHA 9 propiedad 2
                private var cultivados1219 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/CULTIVADOS1219")
                private var dia1219cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/dia1219cult")
                private var mes1219cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/mes1219cult")
                private var a??o1219cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/a??o1219cult")
                private var embolsados1219 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/EMBOLSADOS1219")
                private var dia1219 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/dia1219")
                private var mes1219 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/mes1219")
                private var a??o1219 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV1219/a??o1219")

                private var cultivados1229 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/CULTIVADOS1229")
                private var dia1229cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/dia1229cult")
                private var mes1229cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/mes1229cult")
                private var a??o1229cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/a??o1229cult")
                private var embolsados1229 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/EMBOLSADOS1229")
                private var dia1229 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/dia1229")
                private var mes1229 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/mes1229")
                private var a??o1229 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV1229/a??o1229")

                private var cultivados1239 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/CULTIVADOS1239")
                private var dia1239cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/dia1239cult")
                private var mes1239cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/mes1239cult")
                private var a??o1239cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/a??o1239cult")
                private var embolsados1239 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/EMBOLSADOS1239")
                private var dia1239 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/dia1239")
                private var mes1239 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/mes1239")
                private var a??o1239 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV1239/a??o1239")

                // FECHA 10 propiedad 2
                private var cultivados12110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/CULTIVADOS12110")
                private var dia12110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/dia12110cult")
                private var mes12110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/mes12110cult")
                private var a??o12110cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/a??o12110cult")
                private var embolsados12110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/EMBOLSADOS12110")
                private var dia12110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/dia12110")
                private var mes12110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/mes12110")
                private var a??o12110 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA121/FECHAINV12110/a??o12110")

                private var cultivados12210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/CULTIVADOS12210")
                private var dia12210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/dia12210cult")
                private var mes12210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/mes12210cult")
                private var a??o12210cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/a??o12210cult")
                private var embolsados12210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/EMBOLSADOS12210")
                private var dia12210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/dia12210")
                private var mes12210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/mes12210")
                private var a??o12210 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA122/FECHAINV12210/a??o12210")

                private var cultivados12310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/CULTIVADOS12310")
                private var dia12310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/dia12310cult")
                private var mes12310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/mes12310cult")
                private var a??o12310cult = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/a??o12310cult")
                private var embolsados12310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/EMBOLSADOS12310")
                private var dia12310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/dia12310")
                private var mes12310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/mes12310")
                private var a??o12310 = database.getReference("USUARIO1/PROPIEDADES1/PROPIEDAD12/ZONA123/FECHAINV12310/a??o12310")

        @SuppressLint("SuspiciousIndentation")
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                binding = ActivityZonasBinding.inflate(layoutInflater)
                val view = binding.root
                setContentView(view)

                GlobalScope.launch {
                var dbIDprop = id_botonprop.get().await().value as Long
                var dbIDzona = id_botonzona.get().await().value as Long
                // usuario 1
                        // propiedad 1
                        var dbcontcult111 = contcultivados111.get().await().value as Long
                        var dbcontemb111 = contembolsados111.get().await().value as Long
                        var dbcontcult112 = contcultivados112.get().await().value as Long
                        var dbcontemb112 = contembolsados112.get().await().value as Long
                        var dbcontcult113 = contcultivados113.get().await().value as Long
                        var dbcontemb113 = contembolsados113.get().await().value as Long
                        // propiedad 2
                        var dbcontcult121 = contcultivados121.get().await().value as Long
                        var dbcontemb121 = contembolsados121.get().await().value as Long
                        var dbcontcult122 = contcultivados122.get().await().value as Long
                        var dbcontemb122 = contembolsados122.get().await().value as Long
                        var dbcontcult123 = contcultivados123.get().await().value as Long
                        var dbcontemb123 = contembolsados123.get().await().value as Long

                idprop = dbIDprop.toInt()
                idzona = dbIDzona.toInt()
                 // usuario 1
                        // propiedad 1
                        contadorcultivados111 = dbcontcult111.toInt()
                        contadorembolsados111 = dbcontemb111.toInt()
                        contadorcultivados112 = dbcontcult112.toInt()
                        contadorembolsados112 = dbcontemb112.toInt()
                        contadorcultivados113 = dbcontcult113.toInt()
                        contadorembolsados113 = dbcontemb113.toInt()
                        // propiedad 2
                        contadorcultivados121 = dbcontcult121.toInt()
                        contadorembolsados121 = dbcontemb121.toInt()
                        contadorcultivados122 = dbcontcult122.toInt()
                        contadorembolsados122 = dbcontemb122.toInt()
                        contadorcultivados123 = dbcontcult123.toInt()
                        contadorembolsados123 = dbcontemb123.toInt()

                botonGuardarZonas.visibility = View.VISIBLE

                        binding.botonGuardarZonas.setOnClickListener {
                                // propiedad 1
                                if (idprop == 1) {
                                        if (idzona == 1) {
                                                if(editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()){
                                                        when(contadorembolsados111) {
                                                                0 -> {
                                                                        embolsados1111.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1111.setValue(editTxtDia.text.toString())
                                                                        mes1111.setValue(editTxtMes.text.toString())
                                                                        a??o1111.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=1
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                1 -> {
                                                                        embolsados1112.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1112.setValue(editTxtDia.text.toString())
                                                                        mes1112.setValue(editTxtMes.text.toString())
                                                                        a??o1112.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=2
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                2 -> {
                                                                        embolsados1113.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1113.setValue(editTxtDia.text.toString())
                                                                        mes1113.setValue(editTxtMes.text.toString())
                                                                        a??o1113.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=3
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                3 -> {
                                                                        embolsados1114.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1114.setValue(editTxtDia.text.toString())
                                                                        mes1114.setValue(editTxtMes.text.toString())
                                                                        a??o1114.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=4
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                4 -> {
                                                                        embolsados1115.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1115.setValue(editTxtDia.text.toString())
                                                                        mes1115.setValue(editTxtMes.text.toString())
                                                                        a??o1115.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=5
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                5 -> {
                                                                        embolsados1116.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1116.setValue(editTxtDia.text.toString())
                                                                        mes1116.setValue(editTxtMes.text.toString())
                                                                        a??o1116.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=6
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                6 -> {
                                                                        embolsados1117.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1117.setValue(editTxtDia.text.toString())
                                                                        mes1117.setValue(editTxtMes.text.toString())
                                                                        a??o1117.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=7
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                7 -> {
                                                                        embolsados1118.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1118.setValue(editTxtDia.text.toString())
                                                                        mes1118.setValue(editTxtMes.text.toString())
                                                                        a??o1118.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=8
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                8 -> {
                                                                        embolsados1119.setValue(editTxtEmbolsados.text.toString())
                                                                        dia1119.setValue(editTxtDia.text.toString())
                                                                        mes1119.setValue(editTxtMes.text.toString())
                                                                        a??o1119.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=9
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                }
                                                                9 -> {
                                                                        embolsados11110.setValue(editTxtEmbolsados.text.toString())
                                                                        dia11110.setValue(editTxtDia.text.toString())
                                                                        mes11110.setValue(editTxtMes.text.toString())
                                                                        a??o11110.setValue(editTxtA??o.text.toString())
                                                                        contadorembolsados111=10
                                                                        contembolsados111.setValue(contadorembolsados111)
                                                                        if(contadorcultivados111==10){
                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                        }else
                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                }
                                                        }
                                                        when(contadorcultivados111) {
                                                                0 -> {
                                                                        cultivados1111.setValue(editTxtCultivados.text.toString())
                                                                        dia1111cult.setValue(editTxtDia.text.toString())
                                                                        mes1111cult.setValue(editTxtMes.text.toString())
                                                                        a??o1111cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=1
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                1 -> {
                                                                        cultivados1112.setValue(editTxtCultivados.text.toString())
                                                                        dia1112cult.setValue(editTxtDia.text.toString())
                                                                        mes1112cult.setValue(editTxtMes.text.toString())
                                                                        a??o1112cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=2
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                2 -> {
                                                                        cultivados1113.setValue(editTxtCultivados.text.toString())
                                                                        dia1113cult.setValue(editTxtDia.text.toString())
                                                                        mes1113cult.setValue(editTxtMes.text.toString())
                                                                        a??o1113cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=3
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                3 -> {
                                                                        cultivados1114.setValue(editTxtCultivados.text.toString())
                                                                        dia1114cult.setValue(editTxtDia.text.toString())
                                                                        mes1114cult.setValue(editTxtMes.text.toString())
                                                                        a??o1114cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=4
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                4 -> {
                                                                        cultivados1115.setValue(editTxtCultivados.text.toString())
                                                                        dia1115cult.setValue(editTxtDia.text.toString())
                                                                        mes1115cult.setValue(editTxtMes.text.toString())
                                                                        a??o1115cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=5
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                5 -> {
                                                                        cultivados1116.setValue(editTxtCultivados.text.toString())
                                                                        dia1116cult.setValue(editTxtDia.text.toString())
                                                                        mes1116cult.setValue(editTxtMes.text.toString())
                                                                        a??o1116cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=6
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                6 -> {
                                                                        cultivados1117.setValue(editTxtCultivados.text.toString())
                                                                        dia1117cult.setValue(editTxtDia.text.toString())
                                                                        mes1117cult.setValue(editTxtMes.text.toString())
                                                                        a??o1117cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=7
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                7 -> {
                                                                        cultivados1118.setValue(editTxtCultivados.text.toString())
                                                                        dia1118cult.setValue(editTxtDia.text.toString())
                                                                        mes1118cult.setValue(editTxtMes.text.toString())
                                                                        a??o1118cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=8
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                8 -> {
                                                                        cultivados1119.setValue(editTxtCultivados.text.toString())
                                                                        dia1119cult.setValue(editTxtDia.text.toString())
                                                                        mes1119cult.setValue(editTxtMes.text.toString())
                                                                        a??o1119cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=9
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                }
                                                                9 -> {
                                                                        cultivados11110.setValue(editTxtCultivados.text.toString())
                                                                        dia11110cult.setValue(editTxtDia.text.toString())
                                                                        mes11110cult.setValue(editTxtMes.text.toString())
                                                                        a??o11110cult.setValue(editTxtA??o.text.toString())
                                                                        contadorcultivados111=10
                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                        if(contadorembolsados111==10){
                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                        }else
                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                }
                                                        }
                                                }else  // if 2 llenos zona 1 prop 1
                                                        if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                when(contadorembolsados111) {
                                                                        0 -> {
                                                                                embolsados1111.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1111.setValue(editTxtDia.text.toString())
                                                                                mes1111.setValue(editTxtMes.text.toString())
                                                                                a??o1111.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=1
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        1 -> {
                                                                                embolsados1112.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1112.setValue(editTxtDia.text.toString())
                                                                                mes1112.setValue(editTxtMes.text.toString())
                                                                                a??o1112.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=2
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        2 -> {
                                                                                embolsados1113.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1113.setValue(editTxtDia.text.toString())
                                                                                mes1113.setValue(editTxtMes.text.toString())
                                                                                a??o1113.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=3
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        3 -> {
                                                                                embolsados1114.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1114.setValue(editTxtDia.text.toString())
                                                                                mes1114.setValue(editTxtMes.text.toString())
                                                                                a??o1114.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=4
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        4 -> {
                                                                                embolsados1115.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1115.setValue(editTxtDia.text.toString())
                                                                                mes1115.setValue(editTxtMes.text.toString())
                                                                                a??o1115.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=5
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        5 -> {
                                                                                embolsados1116.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1116.setValue(editTxtDia.text.toString())
                                                                                mes1116.setValue(editTxtMes.text.toString())
                                                                                a??o1116.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=6
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        6 -> {
                                                                                embolsados1117.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1117.setValue(editTxtDia.text.toString())
                                                                                mes1117.setValue(editTxtMes.text.toString())
                                                                                a??o1117.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=7
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        7 -> {
                                                                                embolsados1118.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1118.setValue(editTxtDia.text.toString())
                                                                                mes1118.setValue(editTxtMes.text.toString())
                                                                                a??o1118.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=8
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        8 -> {
                                                                                embolsados1119.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1119.setValue(editTxtDia.text.toString())
                                                                                mes1119.setValue(editTxtMes.text.toString())
                                                                                a??o1119.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=9
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                        }
                                                                        9 -> {
                                                                                embolsados11110.setValue(editTxtEmbolsados.text.toString())
                                                                                dia11110.setValue(editTxtDia.text.toString())
                                                                                mes11110.setValue(editTxtMes.text.toString())
                                                                                a??o11110.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados111=10
                                                                                contembolsados111.setValue(contadorembolsados111)
                                                                                if(contadorcultivados111==10){
                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                }else
                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                        }
                                                                }
                                                        }else
                                                                if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                        when(contadorcultivados111) {
                                                                                0 -> {
                                                                                        cultivados1111.setValue(editTxtCultivados.text.toString())
                                                                                        dia1111cult.setValue(editTxtDia.text.toString())
                                                                                        mes1111cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1111cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=1
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                1 -> {
                                                                                        cultivados1112.setValue(editTxtCultivados.text.toString())
                                                                                        dia1112cult.setValue(editTxtDia.text.toString())
                                                                                        mes1112cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1112cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=2
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                2 -> {
                                                                                        cultivados1113.setValue(editTxtCultivados.text.toString())
                                                                                        dia1113cult.setValue(editTxtDia.text.toString())
                                                                                        mes1113cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1113cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=3
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                3 -> {
                                                                                        cultivados1114.setValue(editTxtCultivados.text.toString())
                                                                                        dia1114cult.setValue(editTxtDia.text.toString())
                                                                                        mes1114cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1114cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=4
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                4 -> {
                                                                                        cultivados1115.setValue(editTxtCultivados.text.toString())
                                                                                        dia1115cult.setValue(editTxtDia.text.toString())
                                                                                        mes1115cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1115cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=5
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                5 -> {
                                                                                        cultivados1116.setValue(editTxtCultivados.text.toString())
                                                                                        dia1116cult.setValue(editTxtDia.text.toString())
                                                                                        mes1116cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1116cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=6
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                6 -> {
                                                                                        cultivados1117.setValue(editTxtCultivados.text.toString())
                                                                                        dia1117cult.setValue(editTxtDia.text.toString())
                                                                                        mes1117cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1117cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=7
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                7 -> {
                                                                                        cultivados1118.setValue(editTxtCultivados.text.toString())
                                                                                        dia1118cult.setValue(editTxtDia.text.toString())
                                                                                        mes1118cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1118cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=8
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                8 -> {
                                                                                        cultivados1119.setValue(editTxtCultivados.text.toString())
                                                                                        dia1119cult.setValue(editTxtDia.text.toString())
                                                                                        mes1119cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1119cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=9
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                }
                                                                                9 -> {
                                                                                        cultivados11110.setValue(editTxtCultivados.text.toString())
                                                                                        dia11110cult.setValue(editTxtDia.text.toString())
                                                                                        mes11110cult.setValue(editTxtMes.text.toString())
                                                                                        a??o11110cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados111=10
                                                                                        contcultivados111.setValue(contadorcultivados111)
                                                                                        if(contadorembolsados111==10){
                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                        }else
                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                }
                                                                        }
                                                                }
                    //////////////////////////////////
                                        }else
                                                if (idzona == 2) {
                                                        if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                when(contadorembolsados112) {
                                                                        0 -> {
                                                                                embolsados1121.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1121.setValue(editTxtDia.text.toString())
                                                                                mes1121.setValue(editTxtMes.text.toString())
                                                                                a??o1121.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=1
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        1 -> {
                                                                                embolsados1122.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1122.setValue(editTxtDia.text.toString())
                                                                                mes1122.setValue(editTxtMes.text.toString())
                                                                                a??o1122.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=2
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        2 -> {
                                                                                embolsados1123.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1123.setValue(editTxtDia.text.toString())
                                                                                mes1123.setValue(editTxtMes.text.toString())
                                                                                a??o1123.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=3
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        3 -> {
                                                                                embolsados1124.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1124.setValue(editTxtDia.text.toString())
                                                                                mes1124.setValue(editTxtMes.text.toString())
                                                                                a??o1124.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=4
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        4 -> {
                                                                                embolsados1125.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1125.setValue(editTxtDia.text.toString())
                                                                                mes1125.setValue(editTxtMes.text.toString())
                                                                                a??o1125.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=5
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        5 -> {
                                                                                embolsados1126.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1126.setValue(editTxtDia.text.toString())
                                                                                mes1126.setValue(editTxtMes.text.toString())
                                                                                a??o1126.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=6
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        6 -> {
                                                                                embolsados1127.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1127.setValue(editTxtDia.text.toString())
                                                                                mes1127.setValue(editTxtMes.text.toString())
                                                                                a??o1127.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=7
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        7 -> {
                                                                                embolsados1128.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1128.setValue(editTxtDia.text.toString())
                                                                                mes1128.setValue(editTxtMes.text.toString())
                                                                                a??o1128.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=8
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        8 -> {
                                                                                embolsados1129.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1129.setValue(editTxtDia.text.toString())
                                                                                mes1129.setValue(editTxtMes.text.toString())
                                                                                a??o1129.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=9
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                        }
                                                                        9 -> {
                                                                                embolsados11210.setValue(editTxtEmbolsados.text.toString())
                                                                                dia11210.setValue(editTxtDia.text.toString())
                                                                                mes11210.setValue(editTxtMes.text.toString())
                                                                                a??o11210.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados112=10
                                                                                contembolsados112.setValue(contadorembolsados112)
                                                                                if(contadorcultivados112==10){
                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                }else
                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                        }
                                                                }
                                                                when(contadorcultivados112) {
                                                                        0 -> {
                                                                                cultivados1121.setValue(editTxtCultivados.text.toString())
                                                                                dia1121cult.setValue(editTxtDia.text.toString())
                                                                                mes1121cult.setValue(editTxtMes.text.toString())
                                                                                a??o1121cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 1
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        1 -> {
                                                                                cultivados1122.setValue(editTxtCultivados.text.toString())
                                                                                dia1122cult.setValue(editTxtDia.text.toString())
                                                                                mes1122cult.setValue(editTxtMes.text.toString())
                                                                                a??o1122cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 2
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        2 -> {
                                                                                cultivados1123.setValue(editTxtCultivados.text.toString())
                                                                                dia1123cult.setValue(editTxtDia.text.toString())
                                                                                mes1123cult.setValue(editTxtMes.text.toString())
                                                                                a??o1123cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 3
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        3 -> {
                                                                                cultivados1124.setValue(editTxtCultivados.text.toString())
                                                                                dia1124cult.setValue(editTxtDia.text.toString())
                                                                                mes1124cult.setValue(editTxtMes.text.toString())
                                                                                a??o1124cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 4
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        4 -> {
                                                                                cultivados1125.setValue(editTxtCultivados.text.toString())
                                                                                dia1125cult.setValue(editTxtDia.text.toString())
                                                                                mes1125cult.setValue(editTxtMes.text.toString())
                                                                                a??o1125cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 5
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        5 -> {
                                                                                cultivados1126.setValue(editTxtCultivados.text.toString())
                                                                                dia1126cult.setValue(editTxtDia.text.toString())
                                                                                mes1126cult.setValue(editTxtMes.text.toString())
                                                                                a??o1126cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 6
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        6 -> {
                                                                                cultivados1127.setValue(editTxtCultivados.text.toString())
                                                                                dia1127cult.setValue(editTxtDia.text.toString())
                                                                                mes1127cult.setValue(editTxtMes.text.toString())
                                                                                a??o1127cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 7
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        7 -> {
                                                                                cultivados1128.setValue(editTxtCultivados.text.toString())
                                                                                dia1128cult.setValue(editTxtDia.text.toString())
                                                                                mes1128cult.setValue(editTxtMes.text.toString())
                                                                                a??o1128cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 8
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        8 -> {
                                                                                cultivados1129.setValue(editTxtCultivados.text.toString())
                                                                                dia1129cult.setValue(editTxtDia.text.toString())
                                                                                mes1129cult.setValue(editTxtMes.text.toString())
                                                                                a??o1129cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 9
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                        }
                                                                        9 -> {
                                                                                cultivados11210.setValue(editTxtCultivados.text.toString())
                                                                                dia11210cult.setValue(editTxtDia.text.toString())
                                                                                mes11210cult.setValue(editTxtMes.text.toString())
                                                                                a??o11210cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados112 = 10
                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                if(contadorembolsados112==10){
                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                }else
                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                        }
                                                                }
                                                        }else
                                                                if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                        when(contadorembolsados112) {
                                                                                0 -> {
                                                                                        embolsados1121.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1121.setValue(editTxtDia.text.toString())
                                                                                        mes1121.setValue(editTxtMes.text.toString())
                                                                                        a??o1121.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=1
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                1 -> {
                                                                                        embolsados1122.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1122.setValue(editTxtDia.text.toString())
                                                                                        mes1122.setValue(editTxtMes.text.toString())
                                                                                        a??o1122.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=2
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                2 -> {
                                                                                        embolsados1123.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1123.setValue(editTxtDia.text.toString())
                                                                                        mes1123.setValue(editTxtMes.text.toString())
                                                                                        a??o1123.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=3
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                3 -> {
                                                                                        embolsados1124.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1124.setValue(editTxtDia.text.toString())
                                                                                        mes1124.setValue(editTxtMes.text.toString())
                                                                                        a??o1124.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=4
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                4 -> {
                                                                                        embolsados1125.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1125.setValue(editTxtDia.text.toString())
                                                                                        mes1125.setValue(editTxtMes.text.toString())
                                                                                        a??o1125.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=5
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                5 -> {
                                                                                        embolsados1126.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1126.setValue(editTxtDia.text.toString())
                                                                                        mes1126.setValue(editTxtMes.text.toString())
                                                                                        a??o1126.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=6
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                6 -> {
                                                                                        embolsados1127.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1127.setValue(editTxtDia.text.toString())
                                                                                        mes1127.setValue(editTxtMes.text.toString())
                                                                                        a??o1127.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=7
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                7 -> {
                                                                                        embolsados1128.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1128.setValue(editTxtDia.text.toString())
                                                                                        mes1128.setValue(editTxtMes.text.toString())
                                                                                        a??o1128.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=8
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                8 -> {
                                                                                        embolsados1129.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1129.setValue(editTxtDia.text.toString())
                                                                                        mes1129.setValue(editTxtMes.text.toString())
                                                                                        a??o1129.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=9
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                }
                                                                                9 -> {
                                                                                        embolsados11210.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia11210.setValue(editTxtDia.text.toString())
                                                                                        mes11210.setValue(editTxtMes.text.toString())
                                                                                        a??o11210.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados112=10
                                                                                        contembolsados112.setValue(contadorembolsados112)
                                                                                        if(contadorcultivados112==10){
                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                        }else
                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                }
                                                                        }
                                                                }else
                                                                        if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                when(contadorcultivados112) {
                                                                                        0 -> {
                                                                                                cultivados1121.setValue(editTxtCultivados.text.toString())
                                                                                                dia1121cult.setValue(editTxtDia.text.toString())
                                                                                                mes1121cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1121cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 1
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        1 -> {
                                                                                                cultivados1122.setValue(editTxtCultivados.text.toString())
                                                                                                dia1122cult.setValue(editTxtDia.text.toString())
                                                                                                mes1122cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1122cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 2
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        2 -> {
                                                                                                cultivados1123.setValue(editTxtCultivados.text.toString())
                                                                                                dia1123cult.setValue(editTxtDia.text.toString())
                                                                                                mes1123cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1123cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 3
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        3 -> {
                                                                                                cultivados1124.setValue(editTxtCultivados.text.toString())
                                                                                                dia1124cult.setValue(editTxtDia.text.toString())
                                                                                                mes1124cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1124cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 4
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        4 -> {
                                                                                                cultivados1125.setValue(editTxtCultivados.text.toString())
                                                                                                dia1125cult.setValue(editTxtDia.text.toString())
                                                                                                mes1125cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1125cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 5
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        5 -> {
                                                                                                cultivados1126.setValue(editTxtCultivados.text.toString())
                                                                                                dia1126cult.setValue(editTxtDia.text.toString())
                                                                                                mes1126cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1126cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 6
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        6 -> {
                                                                                                cultivados1127.setValue(editTxtCultivados.text.toString())
                                                                                                dia1127cult.setValue(editTxtDia.text.toString())
                                                                                                mes1127cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1127cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 7
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        7 -> {
                                                                                                cultivados1128.setValue(editTxtCultivados.text.toString())
                                                                                                dia1128cult.setValue(editTxtDia.text.toString())
                                                                                                mes1128cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1128cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 8
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        8 -> {
                                                                                                cultivados1129.setValue(editTxtCultivados.text.toString())
                                                                                                dia1129cult.setValue(editTxtDia.text.toString())
                                                                                                mes1129cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1129cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 9
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                        }
                                                                                        9 -> {
                                                                                                cultivados11210.setValue(editTxtCultivados.text.toString())
                                                                                                dia11210cult.setValue(editTxtDia.text.toString())
                                                                                                mes11210cult.setValue(editTxtMes.text.toString())
                                                                                                a??o11210cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados112 = 10
                                                                                                contcultivados112.setValue(contadorcultivados112)
                                                                                                if(contadorembolsados112==10){
                                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                }else
                                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                                        }
                                                                                }
                                                                        }
                                                ////////////////////////////////////
                                                }else
                                                        if (idzona == 3) {
                                                                if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                        when (contadorembolsados113) {
                                                                                0 -> {
                                                                                        embolsados1131.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1131.setValue(editTxtDia.text.toString())
                                                                                        mes1131.setValue(editTxtMes.text.toString())
                                                                                        a??o1131.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 1
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                1 -> {
                                                                                        embolsados1132.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1132.setValue(editTxtDia.text.toString())
                                                                                        mes1132.setValue(editTxtMes.text.toString())
                                                                                        a??o1132.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 2
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                2 -> {
                                                                                        embolsados1133.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1133.setValue(editTxtDia.text.toString())
                                                                                        mes1133.setValue(editTxtMes.text.toString())
                                                                                        a??o1133.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 3
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                3 -> {
                                                                                        embolsados1134.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1134.setValue(editTxtDia.text.toString())
                                                                                        mes1134.setValue(editTxtMes.text.toString())
                                                                                        a??o1134.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 4
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                4 -> {
                                                                                        embolsados1135.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1135.setValue(editTxtDia.text.toString())
                                                                                        mes1135.setValue(editTxtMes.text.toString())
                                                                                        a??o1135.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 5
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                5 -> {
                                                                                        embolsados1136.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1136.setValue(editTxtDia.text.toString())
                                                                                        mes1136.setValue(editTxtMes.text.toString())
                                                                                        a??o1136.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 6
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                6 -> {
                                                                                        embolsados1137.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1137.setValue(editTxtDia.text.toString())
                                                                                        mes1137.setValue(editTxtMes.text.toString())
                                                                                        a??o1137.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 7
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                7 -> {
                                                                                        embolsados1138.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1138.setValue(editTxtDia.text.toString())
                                                                                        mes1138.setValue(editTxtMes.text.toString())
                                                                                        a??o1138.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 8
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                8 -> {
                                                                                        embolsados1139.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1139.setValue(editTxtDia.text.toString())
                                                                                        mes1139.setValue(editTxtMes.text.toString())
                                                                                        a??o1139.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 9
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                }
                                                                                9 -> {
                                                                                        embolsados11310.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia11310.setValue(editTxtDia.text.toString())
                                                                                        mes11310.setValue(editTxtMes.text.toString())
                                                                                        a??o11310.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados113 = 10
                                                                                        contembolsados113.setValue(contadorembolsados113)
                                                                                        if (contadorcultivados113 == 10) {
                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                        }else
                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                }
                                                                        }
                                                                        when (contadorcultivados113) {
                                                                                0 -> {
                                                                                        cultivados1131.setValue(editTxtCultivados.text.toString())
                                                                                        dia1131cult.setValue(editTxtDia.text.toString())
                                                                                        mes1131cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1131cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 1
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                1 -> {
                                                                                        cultivados1132.setValue(editTxtCultivados.text.toString())
                                                                                        dia1132cult.setValue(editTxtDia.text.toString())
                                                                                        mes1132cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1132cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 2
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                2 -> {
                                                                                        cultivados1133.setValue(editTxtCultivados.text.toString())
                                                                                        dia1133cult.setValue(editTxtDia.text.toString())
                                                                                        mes1133cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1133cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 3
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                3 -> {
                                                                                        cultivados1134.setValue(editTxtCultivados.text.toString())
                                                                                        dia1134cult.setValue(editTxtDia.text.toString())
                                                                                        mes1134cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1134cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 4
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                4 -> {
                                                                                        cultivados1135.setValue(editTxtCultivados.text.toString())
                                                                                        dia1135cult.setValue(editTxtDia.text.toString())
                                                                                        mes1135cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1135cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 5
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                5 -> {
                                                                                        cultivados1136.setValue(editTxtCultivados.text.toString())
                                                                                        dia1136cult.setValue(editTxtDia.text.toString())
                                                                                        mes1136cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1136cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 6
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                6 -> {
                                                                                        cultivados1137.setValue(editTxtCultivados.text.toString())
                                                                                        dia1137cult.setValue(editTxtDia.text.toString())
                                                                                        mes1137cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1137cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 7
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                7 -> {
                                                                                        cultivados1138.setValue(editTxtCultivados.text.toString())
                                                                                        dia1138cult.setValue(editTxtDia.text.toString())
                                                                                        mes1138cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1138cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 8
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                8 -> {
                                                                                        cultivados1139.setValue(editTxtCultivados.text.toString())
                                                                                        dia1139cult.setValue(editTxtDia.text.toString())
                                                                                        mes1139cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1139cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 9
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                }
                                                                                9 -> {
                                                                                        cultivados11310.setValue(editTxtCultivados.text.toString())
                                                                                        dia11310cult.setValue(editTxtDia.text.toString())
                                                                                        mes11310cult.setValue(editTxtMes.text.toString())
                                                                                        a??o11310cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados113 = 10
                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                        if (contadorembolsados113 == 10) {
                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                        } else
                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                }
                                                                        }
                                                                }else
                                                                        if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                when (contadorembolsados113) {
                                                                                        0 -> {
                                                                                                embolsados1131.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1131.setValue(editTxtDia.text.toString())
                                                                                                mes1131.setValue(editTxtMes.text.toString())
                                                                                                a??o1131.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 1
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        1 -> {
                                                                                                embolsados1132.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1132.setValue(editTxtDia.text.toString())
                                                                                                mes1132.setValue(editTxtMes.text.toString())
                                                                                                a??o1132.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 2
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        2 -> {
                                                                                                embolsados1133.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1133.setValue(editTxtDia.text.toString())
                                                                                                mes1133.setValue(editTxtMes.text.toString())
                                                                                                a??o1133.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 3
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        3 -> {
                                                                                                embolsados1134.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1134.setValue(editTxtDia.text.toString())
                                                                                                mes1134.setValue(editTxtMes.text.toString())
                                                                                                a??o1134.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 4
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        4 -> {
                                                                                                embolsados1135.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1135.setValue(editTxtDia.text.toString())
                                                                                                mes1135.setValue(editTxtMes.text.toString())
                                                                                                a??o1135.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 5
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        5 -> {
                                                                                                embolsados1136.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1136.setValue(editTxtDia.text.toString())
                                                                                                mes1136.setValue(editTxtMes.text.toString())
                                                                                                a??o1136.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 6
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        6 -> {
                                                                                                embolsados1137.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1137.setValue(editTxtDia.text.toString())
                                                                                                mes1137.setValue(editTxtMes.text.toString())
                                                                                                a??o1137.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 7
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        7 -> {
                                                                                                embolsados1138.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1138.setValue(editTxtDia.text.toString())
                                                                                                mes1138.setValue(editTxtMes.text.toString())
                                                                                                a??o1138.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 8
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        8 -> {
                                                                                                embolsados1139.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1139.setValue(editTxtDia.text.toString())
                                                                                                mes1139.setValue(editTxtMes.text.toString())
                                                                                                a??o1139.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 9
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                        }
                                                                                        9 -> {
                                                                                                embolsados11310.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia11310.setValue(editTxtDia.text.toString())
                                                                                                mes11310.setValue(editTxtMes.text.toString())
                                                                                                a??o11310.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados113 = 10
                                                                                                contembolsados113.setValue(contadorembolsados113)
                                                                                                if (contadorcultivados113 == 10) {
                                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                }else
                                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                                        }
                                                                                }
                                                                        }else
                                                                                if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                        when (contadorcultivados113) {
                                                                                                0 -> {
                                                                                                        cultivados1131.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1131cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1131cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1131cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 1
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                1 -> {
                                                                                                        cultivados1132.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1132cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1132cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1132cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 2
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                2 -> {
                                                                                                        cultivados1133.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1133cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1133cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1133cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 3
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                3 -> {
                                                                                                        cultivados1134.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1134cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1134cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1134cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 4
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                4 -> {
                                                                                                        cultivados1135.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1135cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1135cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1135cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 5
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                5 -> {
                                                                                                        cultivados1136.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1136cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1136cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1136cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 6
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                6 -> {
                                                                                                        cultivados1137.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1137cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1137cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1137cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 7
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                7 -> {
                                                                                                        cultivados1138.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1138cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1138cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1138cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 8
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                8 -> {
                                                                                                        cultivados1139.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1139cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1139cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1139cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 9
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                }
                                                                                                9 -> {
                                                                                                        cultivados11310.setValue(editTxtCultivados.text.toString())
                                                                                                        dia11310cult.setValue(editTxtDia.text.toString())
                                                                                                        mes11310cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o11310cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados113 = 10
                                                                                                        contcultivados113.setValue(contadorcultivados113)
                                                                                                        if (contadorembolsados113 == 10) {
                                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                        } else
                                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                                }
                                                                                        }
                                                                                }
                                                        ////////////////////////////////
                                                        }
                                }else //propiedad
                                        if(idprop == 2){
                                                if (idzona == 1) {
                                                        if(editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()){
                                                                when(contadorembolsados121) {
                                                                        0 -> {
                                                                                embolsados1211.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1211.setValue(editTxtDia.text.toString())
                                                                                mes1211.setValue(editTxtMes.text.toString())
                                                                                a??o1211.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=1
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        1 -> {
                                                                                embolsados1212.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1212.setValue(editTxtDia.text.toString())
                                                                                mes1212.setValue(editTxtMes.text.toString())
                                                                                a??o1212.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=2
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        2 -> {
                                                                                embolsados1213.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1213.setValue(editTxtDia.text.toString())
                                                                                mes1213.setValue(editTxtMes.text.toString())
                                                                                a??o1213.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=3
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        3 -> {
                                                                                embolsados1214.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1214.setValue(editTxtDia.text.toString())
                                                                                mes1214.setValue(editTxtMes.text.toString())
                                                                                a??o1214.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=4
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        4 -> {
                                                                                embolsados1215.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1215.setValue(editTxtDia.text.toString())
                                                                                mes1215.setValue(editTxtMes.text.toString())
                                                                                a??o1215.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=5
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        5 -> {
                                                                                embolsados1216.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1216.setValue(editTxtDia.text.toString())
                                                                                mes1216.setValue(editTxtMes.text.toString())
                                                                                a??o1216.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=6
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        6 -> {
                                                                                embolsados1217.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1217.setValue(editTxtDia.text.toString())
                                                                                mes1217.setValue(editTxtMes.text.toString())
                                                                                a??o1217.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=7
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        7 -> {
                                                                                embolsados1218.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1218.setValue(editTxtDia.text.toString())
                                                                                mes1218.setValue(editTxtMes.text.toString())
                                                                                a??o1218.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=8
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        8 -> {
                                                                                embolsados1219.setValue(editTxtEmbolsados.text.toString())
                                                                                dia1219.setValue(editTxtDia.text.toString())
                                                                                mes1219.setValue(editTxtMes.text.toString())
                                                                                a??o1219.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=9
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                        }
                                                                        9 -> {
                                                                                embolsados12110.setValue(editTxtEmbolsados.text.toString())
                                                                                dia12110.setValue(editTxtDia.text.toString())
                                                                                mes12110.setValue(editTxtMes.text.toString())
                                                                                a??o12110.setValue(editTxtA??o.text.toString())
                                                                                contadorembolsados121=10
                                                                                contembolsados121.setValue(contadorembolsados121)
                                                                                if(contadorcultivados121==10){
                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                }else
                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                        }
                                                                }
                                                                when(contadorcultivados121) {
                                                                        0 -> {
                                                                                cultivados1211.setValue(editTxtCultivados.text.toString())
                                                                                dia1211cult.setValue(editTxtDia.text.toString())
                                                                                mes1211cult.setValue(editTxtMes.text.toString())
                                                                                a??o1211cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=1
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        1 -> {
                                                                                cultivados1212.setValue(editTxtCultivados.text.toString())
                                                                                dia1212cult.setValue(editTxtDia.text.toString())
                                                                                mes1212cult.setValue(editTxtMes.text.toString())
                                                                                a??o1212cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=2
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        2 -> {
                                                                                cultivados1213.setValue(editTxtCultivados.text.toString())
                                                                                dia1213cult.setValue(editTxtDia.text.toString())
                                                                                mes1213cult.setValue(editTxtMes.text.toString())
                                                                                a??o1213cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=3
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        3 -> {
                                                                                cultivados1214.setValue(editTxtCultivados.text.toString())
                                                                                dia1214cult.setValue(editTxtDia.text.toString())
                                                                                mes1214cult.setValue(editTxtMes.text.toString())
                                                                                a??o1214cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=4
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        4 -> {
                                                                                cultivados1215.setValue(editTxtCultivados.text.toString())
                                                                                dia1215cult.setValue(editTxtDia.text.toString())
                                                                                mes1215cult.setValue(editTxtMes.text.toString())
                                                                                a??o1215cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=5
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        5 -> {
                                                                                cultivados1216.setValue(editTxtCultivados.text.toString())
                                                                                dia1216cult.setValue(editTxtDia.text.toString())
                                                                                mes1216cult.setValue(editTxtMes.text.toString())
                                                                                a??o1216cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=6
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        6 -> {
                                                                                cultivados1217.setValue(editTxtCultivados.text.toString())
                                                                                dia1217cult.setValue(editTxtDia.text.toString())
                                                                                mes1217cult.setValue(editTxtMes.text.toString())
                                                                                a??o1217cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=7
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        7 -> {
                                                                                cultivados1218.setValue(editTxtCultivados.text.toString())
                                                                                dia1218cult.setValue(editTxtDia.text.toString())
                                                                                mes1218cult.setValue(editTxtMes.text.toString())
                                                                                a??o1218cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=8
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        8 -> {
                                                                                cultivados1219.setValue(editTxtCultivados.text.toString())
                                                                                dia1219cult.setValue(editTxtDia.text.toString())
                                                                                mes1219cult.setValue(editTxtMes.text.toString())
                                                                                a??o1219cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=9
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                        }
                                                                        9 -> {
                                                                                cultivados12110.setValue(editTxtCultivados.text.toString())
                                                                                dia12110cult.setValue(editTxtDia.text.toString())
                                                                                mes12110cult.setValue(editTxtMes.text.toString())
                                                                                a??o12110cult.setValue(editTxtA??o.text.toString())
                                                                                contadorcultivados121=10
                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                if(contadorembolsados121==10){
                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                }else
                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                        }
                                                                }
                                                        }else  // if 2 llenos zona 1 prop 2
                                                                if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                        when(contadorembolsados121) {
                                                                                0 -> {
                                                                                        embolsados1211.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1211.setValue(editTxtDia.text.toString())
                                                                                        mes1211.setValue(editTxtMes.text.toString())
                                                                                        a??o1211.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=1
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                1 -> {
                                                                                        embolsados1212.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1212.setValue(editTxtDia.text.toString())
                                                                                        mes1212.setValue(editTxtMes.text.toString())
                                                                                        a??o1212.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=2
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                2 -> {
                                                                                        embolsados1213.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1213.setValue(editTxtDia.text.toString())
                                                                                        mes1213.setValue(editTxtMes.text.toString())
                                                                                        a??o1213.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=3
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                3 -> {
                                                                                        embolsados1214.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1214.setValue(editTxtDia.text.toString())
                                                                                        mes1214.setValue(editTxtMes.text.toString())
                                                                                        a??o1214.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=4
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                4 -> {
                                                                                        embolsados1215.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1215.setValue(editTxtDia.text.toString())
                                                                                        mes1215.setValue(editTxtMes.text.toString())
                                                                                        a??o1215.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=5
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                5 -> {
                                                                                        embolsados1216.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1216.setValue(editTxtDia.text.toString())
                                                                                        mes1216.setValue(editTxtMes.text.toString())
                                                                                        a??o1216.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=6
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                6 -> {
                                                                                        embolsados1217.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1217.setValue(editTxtDia.text.toString())
                                                                                        mes1217.setValue(editTxtMes.text.toString())
                                                                                        a??o1217.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=7
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                7 -> {
                                                                                        embolsados1218.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1218.setValue(editTxtDia.text.toString())
                                                                                        mes1218.setValue(editTxtMes.text.toString())
                                                                                        a??o1218.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=8
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                8 -> {
                                                                                        embolsados1219.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1219.setValue(editTxtDia.text.toString())
                                                                                        mes1219.setValue(editTxtMes.text.toString())
                                                                                        a??o1219.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=9
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                }
                                                                                9 -> {
                                                                                        embolsados12110.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia12110.setValue(editTxtDia.text.toString())
                                                                                        mes12110.setValue(editTxtMes.text.toString())
                                                                                        a??o12110.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados121=10
                                                                                        contembolsados121.setValue(contadorembolsados121)
                                                                                        if(contadorcultivados121==10){
                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                        }else
                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                }
                                                                        }
                                                                }else
                                                                        if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                when(contadorcultivados121) {
                                                                                        0 -> {
                                                                                                cultivados1211.setValue(editTxtCultivados.text.toString())
                                                                                                dia1211cult.setValue(editTxtDia.text.toString())
                                                                                                mes1211cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1211cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=1
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        1 -> {
                                                                                                cultivados1212.setValue(editTxtCultivados.text.toString())
                                                                                                dia1212cult.setValue(editTxtDia.text.toString())
                                                                                                mes1212cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1212cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=2
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        2 -> {
                                                                                                cultivados1213.setValue(editTxtCultivados.text.toString())
                                                                                                dia1213cult.setValue(editTxtDia.text.toString())
                                                                                                mes1213cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1213cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=3
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        3 -> {
                                                                                                cultivados1214.setValue(editTxtCultivados.text.toString())
                                                                                                dia1214cult.setValue(editTxtDia.text.toString())
                                                                                                mes1214cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1214cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=4
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        4 -> {
                                                                                                cultivados1215.setValue(editTxtCultivados.text.toString())
                                                                                                dia1215cult.setValue(editTxtDia.text.toString())
                                                                                                mes1215cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1215cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=5
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        5 -> {
                                                                                                cultivados1216.setValue(editTxtCultivados.text.toString())
                                                                                                dia1216cult.setValue(editTxtDia.text.toString())
                                                                                                mes1216cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1216cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=6
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        6 -> {
                                                                                                cultivados1217.setValue(editTxtCultivados.text.toString())
                                                                                                dia1217cult.setValue(editTxtDia.text.toString())
                                                                                                mes1217cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1217cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=7
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        7 -> {
                                                                                                cultivados1218.setValue(editTxtCultivados.text.toString())
                                                                                                dia1218cult.setValue(editTxtDia.text.toString())
                                                                                                mes1218cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1218cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=8
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        8 -> {
                                                                                                cultivados1219.setValue(editTxtCultivados.text.toString())
                                                                                                dia1219cult.setValue(editTxtDia.text.toString())
                                                                                                mes1219cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1219cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=9
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                        }
                                                                                        9 -> {
                                                                                                cultivados12110.setValue(editTxtCultivados.text.toString())
                                                                                                dia12110cult.setValue(editTxtDia.text.toString())
                                                                                                mes12110cult.setValue(editTxtMes.text.toString())
                                                                                                a??o12110cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados121=10
                                                                                                contcultivados121.setValue(contadorcultivados121)
                                                                                                if(contadorembolsados121==10){
                                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                }else
                                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                                        }
                                                                                }
                                                                        }
                                                        //////////////////////////////////
                                                }else
                                                        if (idzona == 2) {
                                                                if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                        when(contadorembolsados122) {
                                                                                0 -> {
                                                                                        embolsados1221.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1221.setValue(editTxtDia.text.toString())
                                                                                        mes1221.setValue(editTxtMes.text.toString())
                                                                                        a??o1221.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=1
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                1 -> {
                                                                                        embolsados1222.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1222.setValue(editTxtDia.text.toString())
                                                                                        mes1222.setValue(editTxtMes.text.toString())
                                                                                        a??o1222.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=2
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                2 -> {
                                                                                        embolsados1223.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1223.setValue(editTxtDia.text.toString())
                                                                                        mes1223.setValue(editTxtMes.text.toString())
                                                                                        a??o1223.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=3
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                3 -> {
                                                                                        embolsados1224.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1224.setValue(editTxtDia.text.toString())
                                                                                        mes1224.setValue(editTxtMes.text.toString())
                                                                                        a??o1224.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=4
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                4 -> {
                                                                                        embolsados1225.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1225.setValue(editTxtDia.text.toString())
                                                                                        mes1225.setValue(editTxtMes.text.toString())
                                                                                        a??o1225.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=5
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                5 -> {
                                                                                        embolsados1226.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1226.setValue(editTxtDia.text.toString())
                                                                                        mes1226.setValue(editTxtMes.text.toString())
                                                                                        a??o1226.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=6
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                6 -> {
                                                                                        embolsados1227.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1227.setValue(editTxtDia.text.toString())
                                                                                        mes1227.setValue(editTxtMes.text.toString())
                                                                                        a??o1227.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=7
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                7 -> {
                                                                                        embolsados1228.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1228.setValue(editTxtDia.text.toString())
                                                                                        mes1228.setValue(editTxtMes.text.toString())
                                                                                        a??o1228.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=8
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                8 -> {
                                                                                        embolsados1229.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia1229.setValue(editTxtDia.text.toString())
                                                                                        mes1229.setValue(editTxtMes.text.toString())
                                                                                        a??o1229.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=9
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                }
                                                                                9 -> {
                                                                                        embolsados12210.setValue(editTxtEmbolsados.text.toString())
                                                                                        dia12210.setValue(editTxtDia.text.toString())
                                                                                        mes12210.setValue(editTxtMes.text.toString())
                                                                                        a??o12210.setValue(editTxtA??o.text.toString())
                                                                                        contadorembolsados122=10
                                                                                        contembolsados122.setValue(contadorembolsados122)
                                                                                        if(contadorcultivados122==10){
                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                        }else
                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                }
                                                                        }
                                                                        when(contadorcultivados122) {
                                                                                0 -> {
                                                                                        cultivados1221.setValue(editTxtCultivados.text.toString())
                                                                                        dia1221cult.setValue(editTxtDia.text.toString())
                                                                                        mes1221cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1221cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 1
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                1 -> {
                                                                                        cultivados1222.setValue(editTxtCultivados.text.toString())
                                                                                        dia1222cult.setValue(editTxtDia.text.toString())
                                                                                        mes1222cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1222cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 2
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                2 -> {
                                                                                        cultivados1223.setValue(editTxtCultivados.text.toString())
                                                                                        dia1223cult.setValue(editTxtDia.text.toString())
                                                                                        mes1223cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1223cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 3
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                3 -> {
                                                                                        cultivados1224.setValue(editTxtCultivados.text.toString())
                                                                                        dia1224cult.setValue(editTxtDia.text.toString())
                                                                                        mes1224cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1224cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 4
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                4 -> {
                                                                                        cultivados1225.setValue(editTxtCultivados.text.toString())
                                                                                        dia1225cult.setValue(editTxtDia.text.toString())
                                                                                        mes1225cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1225cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 5
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                5 -> {
                                                                                        cultivados1126.setValue(editTxtCultivados.text.toString())
                                                                                        dia1226cult.setValue(editTxtDia.text.toString())
                                                                                        mes1226cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1226cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 6
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                6 -> {
                                                                                        cultivados1227.setValue(editTxtCultivados.text.toString())
                                                                                        dia1227cult.setValue(editTxtDia.text.toString())
                                                                                        mes1227cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1227cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 7
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                7 -> {
                                                                                        cultivados1228.setValue(editTxtCultivados.text.toString())
                                                                                        dia1228cult.setValue(editTxtDia.text.toString())
                                                                                        mes1228cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1228cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 8
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                8 -> {
                                                                                        cultivados1229.setValue(editTxtCultivados.text.toString())
                                                                                        dia1229cult.setValue(editTxtDia.text.toString())
                                                                                        mes1229cult.setValue(editTxtMes.text.toString())
                                                                                        a??o1229cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 9
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                }
                                                                                9 -> {
                                                                                        cultivados12210.setValue(editTxtCultivados.text.toString())
                                                                                        dia12210cult.setValue(editTxtDia.text.toString())
                                                                                        mes12210cult.setValue(editTxtMes.text.toString())
                                                                                        a??o12210cult.setValue(editTxtA??o.text.toString())
                                                                                        contadorcultivados122 = 10
                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                        if(contadorembolsados122==10){
                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                        }else
                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                }
                                                                        }
                                                                }else
                                                                        if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                when(contadorembolsados122) {
                                                                                        0 -> {
                                                                                                embolsados1221.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1221.setValue(editTxtDia.text.toString())
                                                                                                mes1221.setValue(editTxtMes.text.toString())
                                                                                                a??o1221.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=1
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        1 -> {
                                                                                                embolsados1222.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1222.setValue(editTxtDia.text.toString())
                                                                                                mes1222.setValue(editTxtMes.text.toString())
                                                                                                a??o1222.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=2
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        2 -> {
                                                                                                embolsados1223.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1223.setValue(editTxtDia.text.toString())
                                                                                                mes1223.setValue(editTxtMes.text.toString())
                                                                                                a??o1223.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=3
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        3 -> {
                                                                                                embolsados1224.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1224.setValue(editTxtDia.text.toString())
                                                                                                mes1224.setValue(editTxtMes.text.toString())
                                                                                                a??o1224.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=4
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        4 -> {
                                                                                                embolsados1225.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1225.setValue(editTxtDia.text.toString())
                                                                                                mes1225.setValue(editTxtMes.text.toString())
                                                                                                a??o1225.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=5
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        5 -> {
                                                                                                embolsados1226.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1226.setValue(editTxtDia.text.toString())
                                                                                                mes1226.setValue(editTxtMes.text.toString())
                                                                                                a??o1226.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=6
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        6 -> {
                                                                                                embolsados1227.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1227.setValue(editTxtDia.text.toString())
                                                                                                mes1227.setValue(editTxtMes.text.toString())
                                                                                                a??o1227.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=7
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        7 -> {
                                                                                                embolsados1228.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1228.setValue(editTxtDia.text.toString())
                                                                                                mes1228.setValue(editTxtMes.text.toString())
                                                                                                a??o1228.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=8
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        8 -> {
                                                                                                embolsados1229.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1229.setValue(editTxtDia.text.toString())
                                                                                                mes1229.setValue(editTxtMes.text.toString())
                                                                                                a??o1229.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=9
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                        }
                                                                                        9 -> {
                                                                                                embolsados12210.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia12210.setValue(editTxtDia.text.toString())
                                                                                                mes12210.setValue(editTxtMes.text.toString())
                                                                                                a??o12210.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados122=10
                                                                                                contembolsados122.setValue(contadorembolsados122)
                                                                                                if(contadorcultivados122==10){
                                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                }else
                                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                                        }
                                                                                }
                                                                        }else
                                                                                if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                        when(contadorcultivados122) {
                                                                                                0 -> {
                                                                                                        cultivados1221.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1221cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1221cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1221cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 1
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                1 -> {
                                                                                                        cultivados1222.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1222cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1222cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1222cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 2
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                2 -> {
                                                                                                        cultivados1223.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1223cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1223cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1223cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 3
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                3 -> {
                                                                                                        cultivados1224.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1224cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1224cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1224cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 4
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                4 -> {
                                                                                                        cultivados1225.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1225cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1225cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1225cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 5
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                5 -> {
                                                                                                        cultivados1126.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1226cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1226cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1226cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 6
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                6 -> {
                                                                                                        cultivados1227.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1227cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1227cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1227cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 7
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                7 -> {
                                                                                                        cultivados1228.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1228cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1228cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1228cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 8
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                8 -> {
                                                                                                        cultivados1229.setValue(editTxtCultivados.text.toString())
                                                                                                        dia1229cult.setValue(editTxtDia.text.toString())
                                                                                                        mes1229cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o1229cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 9
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                }
                                                                                                9 -> {
                                                                                                        cultivados12210.setValue(editTxtCultivados.text.toString())
                                                                                                        dia12210cult.setValue(editTxtDia.text.toString())
                                                                                                        mes12210cult.setValue(editTxtMes.text.toString())
                                                                                                        a??o12210cult.setValue(editTxtA??o.text.toString())
                                                                                                        contadorcultivados122 = 10
                                                                                                        contcultivados122.setValue(contadorcultivados122)
                                                                                                        if(contadorembolsados122==10){
                                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                        }else
                                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                                }
                                                                                        }
                                                                                }
                                                                ////////////////////////////////////
                                                        }else
                                                                if (idzona == 3) {
                                                                        if (editTxtEmbolsados.text.isNotEmpty() && editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                when (contadorembolsados123) {
                                                                                        0 -> {
                                                                                                embolsados1231.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1231.setValue(editTxtDia.text.toString())
                                                                                                mes1231.setValue(editTxtMes.text.toString())
                                                                                                a??o1231.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 1
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        1 -> {
                                                                                                embolsados1232.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1232.setValue(editTxtDia.text.toString())
                                                                                                mes1232.setValue(editTxtMes.text.toString())
                                                                                                a??o1232.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 2
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        2 -> {
                                                                                                embolsados1233.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1233.setValue(editTxtDia.text.toString())
                                                                                                mes1233.setValue(editTxtMes.text.toString())
                                                                                                a??o1233.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 3
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        3 -> {
                                                                                                embolsados1234.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1234.setValue(editTxtDia.text.toString())
                                                                                                mes1234.setValue(editTxtMes.text.toString())
                                                                                                a??o1234.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 4
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        4 -> {
                                                                                                embolsados1235.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1235.setValue(editTxtDia.text.toString())
                                                                                                mes1235.setValue(editTxtMes.text.toString())
                                                                                                a??o1235.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 5
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        5 -> {
                                                                                                embolsados1236.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1236.setValue(editTxtDia.text.toString())
                                                                                                mes1236.setValue(editTxtMes.text.toString())
                                                                                                a??o1236.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 6
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        6 -> {
                                                                                                embolsados1237.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1237.setValue(editTxtDia.text.toString())
                                                                                                mes1237.setValue(editTxtMes.text.toString())
                                                                                                a??o1237.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 7
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        7 -> {
                                                                                                embolsados1238.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1238.setValue(editTxtDia.text.toString())
                                                                                                mes1238.setValue(editTxtMes.text.toString())
                                                                                                a??o1238.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 8
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        8 -> {
                                                                                                embolsados1239.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia1239.setValue(editTxtDia.text.toString())
                                                                                                mes1239.setValue(editTxtMes.text.toString())
                                                                                                a??o1239.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 9
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                        }
                                                                                        9 -> {
                                                                                                embolsados12310.setValue(editTxtEmbolsados.text.toString())
                                                                                                dia12310.setValue(editTxtDia.text.toString())
                                                                                                mes12310.setValue(editTxtMes.text.toString())
                                                                                                a??o12310.setValue(editTxtA??o.text.toString())
                                                                                                contadorembolsados123 = 10
                                                                                                contembolsados123.setValue(contadorembolsados123)
                                                                                                if (contadorcultivados123 == 10) {
                                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                }else
                                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                                        }
                                                                                }
                                                                                when (contadorcultivados123) {
                                                                                        0 -> {
                                                                                                cultivados1231.setValue(editTxtCultivados.text.toString())
                                                                                                dia1231cult.setValue(editTxtDia.text.toString())
                                                                                                mes1231cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1231cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 1
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        1 -> {
                                                                                                cultivados1232.setValue(editTxtCultivados.text.toString())
                                                                                                dia1232cult.setValue(editTxtDia.text.toString())
                                                                                                mes1232cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1232cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 2
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        2 -> {
                                                                                                cultivados1233.setValue(editTxtCultivados.text.toString())
                                                                                                dia1233cult.setValue(editTxtDia.text.toString())
                                                                                                mes1233cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1233cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 3
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        3 -> {
                                                                                                cultivados1234.setValue(editTxtCultivados.text.toString())
                                                                                                dia1234cult.setValue(editTxtDia.text.toString())
                                                                                                mes1234cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1234cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 4
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        4 -> {
                                                                                                cultivados1235.setValue(editTxtCultivados.text.toString())
                                                                                                dia1235cult.setValue(editTxtDia.text.toString())
                                                                                                mes1235cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1235cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 5
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        5 -> {
                                                                                                cultivados1236.setValue(editTxtCultivados.text.toString())
                                                                                                dia1236cult.setValue(editTxtDia.text.toString())
                                                                                                mes1236cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1236cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 6
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        6 -> {
                                                                                                cultivados1237.setValue(editTxtCultivados.text.toString())
                                                                                                dia1237cult.setValue(editTxtDia.text.toString())
                                                                                                mes1237cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1237cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 7
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        7 -> {
                                                                                                cultivados1238.setValue(editTxtCultivados.text.toString())
                                                                                                dia1238cult.setValue(editTxtDia.text.toString())
                                                                                                mes1238cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1238cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 8
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        8 -> {
                                                                                                cultivados1239.setValue(editTxtCultivados.text.toString())
                                                                                                dia1239cult.setValue(editTxtDia.text.toString())
                                                                                                mes1239cult.setValue(editTxtMes.text.toString())
                                                                                                a??o1239cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 9
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                        }
                                                                                        9 -> {
                                                                                                cultivados12310.setValue(editTxtCultivados.text.toString())
                                                                                                dia12310cult.setValue(editTxtDia.text.toString())
                                                                                                mes12310cult.setValue(editTxtMes.text.toString())
                                                                                                a??o12310cult.setValue(editTxtA??o.text.toString())
                                                                                                contadorcultivados123 = 10
                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                if (contadorembolsados123 == 10) {
                                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                } else
                                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                                        }
                                                                                }
                                                                        }else
                                                                                if (editTxtEmbolsados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                        when (contadorembolsados123) {
                                                                                                0 -> {
                                                                                                        embolsados1231.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1231.setValue(editTxtDia.text.toString())
                                                                                                        mes1231.setValue(editTxtMes.text.toString())
                                                                                                        a??o1231.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 1
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                1 -> {
                                                                                                        embolsados1232.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1232.setValue(editTxtDia.text.toString())
                                                                                                        mes1232.setValue(editTxtMes.text.toString())
                                                                                                        a??o1232.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 2
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                2 -> {
                                                                                                        embolsados1233.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1233.setValue(editTxtDia.text.toString())
                                                                                                        mes1233.setValue(editTxtMes.text.toString())
                                                                                                        a??o1233.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 3
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                3 -> {
                                                                                                        embolsados1234.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1234.setValue(editTxtDia.text.toString())
                                                                                                        mes1234.setValue(editTxtMes.text.toString())
                                                                                                        a??o1234.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 4
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                4 -> {
                                                                                                        embolsados1235.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1235.setValue(editTxtDia.text.toString())
                                                                                                        mes1235.setValue(editTxtMes.text.toString())
                                                                                                        a??o1235.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 5
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                5 -> {
                                                                                                        embolsados1236.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1236.setValue(editTxtDia.text.toString())
                                                                                                        mes1236.setValue(editTxtMes.text.toString())
                                                                                                        a??o1236.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 6
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                6 -> {
                                                                                                        embolsados1237.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1237.setValue(editTxtDia.text.toString())
                                                                                                        mes1237.setValue(editTxtMes.text.toString())
                                                                                                        a??o1237.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 7
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                7 -> {
                                                                                                        embolsados1238.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1238.setValue(editTxtDia.text.toString())
                                                                                                        mes1238.setValue(editTxtMes.text.toString())
                                                                                                        a??o1238.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 8
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                8 -> {
                                                                                                        embolsados1239.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia1239.setValue(editTxtDia.text.toString())
                                                                                                        mes1239.setValue(editTxtMes.text.toString())
                                                                                                        a??o1239.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 9
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                }
                                                                                                9 -> {
                                                                                                        embolsados12310.setValue(editTxtEmbolsados.text.toString())
                                                                                                        dia12310.setValue(editTxtDia.text.toString())
                                                                                                        mes12310.setValue(editTxtMes.text.toString())
                                                                                                        a??o12310.setValue(editTxtA??o.text.toString())
                                                                                                        contadorembolsados123 = 10
                                                                                                        contembolsados123.setValue(contadorembolsados123)
                                                                                                        if (contadorcultivados123 == 10) {
                                                                                                                botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                        }else
                                                                                                                botonGuardarZonas.visibility = View.VISIBLE
                                                                                                }
                                                                                        }
                                                                                }else
                                                                                        if (editTxtCultivados.text.isNotEmpty() && editTxtDia.text.isNotEmpty() && editTxtMes.text.isNotEmpty() && editTxtA??o.text.isNotEmpty()) {
                                                                                                when (contadorcultivados123) {
                                                                                                        0 -> {
                                                                                                                cultivados1231.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1231cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1231cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1231cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 1
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        1 -> {
                                                                                                                cultivados1232.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1232cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1232cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1232cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 2
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        2 -> {
                                                                                                                cultivados1233.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1233cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1233cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1233cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 3
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        3 -> {
                                                                                                                cultivados1234.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1234cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1234cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1234cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 4
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        4 -> {
                                                                                                                cultivados1235.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1235cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1235cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1235cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 5
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        5 -> {
                                                                                                                cultivados1236.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1236cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1236cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1236cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 6
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        6 -> {
                                                                                                                cultivados1237.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1237cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1237cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1237cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 7
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        7 -> {
                                                                                                                cultivados1238.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1238cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1238cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1238cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 8
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        8 -> {
                                                                                                                cultivados1239.setValue(editTxtCultivados.text.toString())
                                                                                                                dia1239cult.setValue(editTxtDia.text.toString())
                                                                                                                mes1239cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o1239cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 9
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                        }
                                                                                                        9 -> {
                                                                                                                cultivados12310.setValue(editTxtCultivados.text.toString())
                                                                                                                dia12310cult.setValue(editTxtDia.text.toString())
                                                                                                                mes12310cult.setValue(editTxtMes.text.toString())
                                                                                                                a??o12310cult.setValue(editTxtA??o.text.toString())
                                                                                                                contadorcultivados123 = 10
                                                                                                                contcultivados123.setValue(contadorcultivados123)
                                                                                                                if (contadorembolsados123 == 10) {
                                                                                                                        botonGuardarZonas.visibility = View.INVISIBLE
                                                                                                                } else
                                                                                                                        botonGuardarZonas.visibility = View.VISIBLE
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                        ////////////////////////////////
                                                                }
                                        }
                        }// setonclick
                } // global launcher
        }
}  // on create
// class