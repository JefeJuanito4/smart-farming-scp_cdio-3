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


    var totalracCult = 409
    var totalracEmb = 1209

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


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


}