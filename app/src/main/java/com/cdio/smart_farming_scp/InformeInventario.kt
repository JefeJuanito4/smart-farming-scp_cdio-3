package com.cdio.smart_farming_scp

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextPaint
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cdio.smart_farming_scp.databinding.InformeInventarioBinding
import kotlinx.android.synthetic.main.informe_inventario.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOError
import java.lang.Exception

class InformeInventario : AppCompatActivity() {
    private lateinit var binding: InformeInventarioBinding
    var titulo1Text= "El total de producción de la propiedad es: "
    var tituloText = "INFORME DE PRODUCCIÓN"
    var descripcionText =  "Con el fin de contribuir a procesos internos como lo es el control y manejo de la producción platanera y  \n" +
            "aportar con dicha información a organizaciones públicas, tales como el Instituto Colombiano Agropecuario ICA, \n" +
            "que tiene como fin contribuir al desarrollo del sector, velando por la sanidad agropecuaria y el Sistema \n" +
            "de Información de Gestión y Desempeño de las Organizaciones de Cadenas SIOC, el cual facilita la toma de decisiones\n" +
            "para establecer metas de las Organizaciones en Cadenas para el mejoramiento continuo y amplie su competitividad.\n" +
            "Se ha generado este documento el cual contiene la información que cuenta con el total de producción registrado \n" +
            "en el inventario que desarrollo la compañía Smart Farming,  facilitando procesos de control de inventarios \n"+
            "y así sistematización la industria.\n";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InformeInventarioBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle: Bundle? = intent.extras
        val cantTotcos1: String? = bundle?.getString("TracimosCultivadosP1")


        val botonpdf =  findViewById<ImageButton>(R.id.btnCrearPdf)
        if(checkPermission()) {
            Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG).show()
        } else {
            requestPermissions()
        }

            botonpdf.setOnClickListener {
                if (cantTotcos1 != null) {
                    generarPdf(cantTotcos1)
                }
        }
    }

    fun generarPdf(cantTotcos1: String) {

        var pdfDocument = PdfDocument()
        var paint = Paint()
        var titulo1 = TextPaint()
        var descripcion1 = TextPaint()
        var titulo = TextPaint()
        var descripcion = TextPaint()

        var paginaInfo = PdfDocument.PageInfo.Builder(816, 1054, 1).create()
        var pagina1 = pdfDocument.startPage(paginaInfo)

        var canvas = pagina1.canvas

        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.avatar_usuario)
        var bitmapEscala = Bitmap.createScaledBitmap(bitmap, 80,80, false)
        canvas.drawBitmap(bitmapEscala, 368f, 20f, paint)

        titulo.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        titulo.textSize = 20f
        canvas.drawText(tituloText, 268f, 150f, titulo)

        titulo1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        titulo1.textSize = 20f
        canvas.drawText(titulo1Text, 50f, 350f, titulo1)

        descripcion1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        descripcion1.textSize = 20f
        canvas.drawText(cantTotcos1, 420f, 350f, descripcion1)

        descripcion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL))
        descripcion.textSize = 14f

        var arrDescripcion = descripcionText.split("\n")

        var y = 200f
        for (item in arrDescripcion) {
            canvas.drawText(item, 50f, y, descripcion)
            y += 15
        }

        pdfDocument.finishPage(pagina1)
        val file = File(applicationContext.getExternalFilesDir(null), "informe de producción.pdf")

        //val file = File(Environment.getExternalStorageDirectory(), "Archivo.pdf")
       // val file = File(applicationContext.filesDir, "Archivo.pdf")

        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(this, "Se creo el PDF correctamente", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        pdfDocument.close()

    }

    private fun checkPermission(): Boolean {
        val permission1 = ContextCompat.checkSelfPermission(applicationContext, WRITE_EXTERNAL_STORAGE)
        val permission2 = ContextCompat.checkSelfPermission(applicationContext, READ_EXTERNAL_STORAGE)
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
            200
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 200) {
            if(grantResults.size > 0) {
                val writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if(writeStorage && readStorage) {
                    Toast.makeText(this, "Permisos rechazados", Toast.LENGTH_LONG).show()
               // finish()
                } else {
                    Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG).show()

                }
            }
        }
    }
}
