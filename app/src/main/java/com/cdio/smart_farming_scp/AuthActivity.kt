package com.cdio.smart_farming_scp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        //Setup
        setup()


    }

    private fun setup() {
        title = "Autenticación"
        registerButt.setOnClickListener {
            if (editText_correo.text.isNotEmpty() && editText_contraseña.text.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(
                        editText_correo.text.toString(),
                        editText_contraseña.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }

        }

        button_login.setOnClickListener {
            if (editText_correo.text.isNotEmpty() && editText_contraseña.text.isNotEmpty()) {

                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(
                        editText_correo.text.toString(),
                        editText_contraseña.text.toString()
                    ).addOnCompleteListener {
                        if (it.isSuccessful) {
                            showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                        } else {
                            showAlert()
                        }
                    }
            }

        }
    }


    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario :c")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()


    }

    private fun showHome(email: String, provider: ProviderType) {

        val homeIntent = Intent(this, menuActivity::class.java).apply {
            putExtra("email", email)
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email )
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }


}
