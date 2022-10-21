package com.cdio.smart_farming_scp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.encabezado_menulateral.*




enum class ProviderType{
    BASIC
}
class HomeActivity : AppCompatActivity() {
    lateinit var texto_correo:TextView
    lateinit var texto_provider:TextView
    lateinit var outSession: MenuItem
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.navegadorLateral)
        texto_correo=navView.getHeaderView(0).findViewById(R.id.texthome_correo)
        texto_provider=navView.getHeaderView(0).findViewById(R.id.texthome_provider)
        outSession=navView.menu.findItem(R.id.buttonOutSession)


        //setup
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString("email")
        val provider: String? = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")

    }

    private fun setup(email: String, provider: String) {
        title = "Inicio"

        texto_correo.text = email
        texto_provider.text=provider
        //texthome_provider.text = provider
        outSession.setOnMenuItemClickListener {
               FirebaseAuth.getInstance().signOut()
              onBackPressed()
              true
            //posible error

        }


    }
}