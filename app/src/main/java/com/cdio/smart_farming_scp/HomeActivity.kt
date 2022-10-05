package com.cdio.smart_farming_scp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

enum class ProviderType{
    BASIC
}
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //setup
        val bundle: Bundle? = intent.extras
        val email: String? = bundle?.getString( "email")
        val provider: String? = bundle?.getString( "provider")
        setup( email ?: "",  provider ?:"")

    }

    private fun setup(email: String, provider: String){
        title ="Inicio"

        texthome_correo.text = email
        texthome_provider.text= provider
        buttonOutSession.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
            //posible error
        }
    }
}