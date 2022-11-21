package com.cdio.smart_farming_scp

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.Environment
import android.text.TextPaint
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.cdio.smart_farming_scp.databinding.InformeInventarioBinding
import java.io.File
import java.io.FileOutputStream

class InformeInventario : AppCompatActivity() {
    private lateinit var binding: InformeInventarioBinding
    var tituloText = "Este es el titulo del documento"
    var  descripcionText = "Informe para certificar la producción. \n"+ "de tu finca manuelita \n"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = InformeInventarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val botonpdf =  findViewById<ImageButton>(R.id.botonInforme)

        if(checkPermission()){
            Toast.makeText(this, "Permiso Aceptado", Toast.LENGTH_LONG).show()
        } else{
            requestPermissions()
        }

        botonpdf.setOnClickListener(View.OnClickListener {
            generarPdf()
        })

    }

    fun generarPdf(){

        val pdfDocument = PdfDocument()
        val paint = Paint()
        val titulo = TextPaint()
        val descripcion = TextPaint()

        val paginaInfo = PdfDocument.PageInfo.Builder(816,1054,1).create()
        val pagina1 = pdfDocument.startPage(paginaInfo)

        val canvas = pagina1.canvas

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.avatar_usuario)
        val bitmapEscala = Bitmap.createScaledBitmap(bitmap, 80,80,false)
        canvas.drawBitmap(bitmapEscala, 368f, 20f, paint)

        titulo.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        titulo.textSize = 20f
        canvas.drawText(tituloText, 10f, 150f, titulo)

        descripcion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL))
        descripcion.textSize = 14f

        val arrDescripcion = descripcionText.split("\n")

        var y=200f
        for (item in arrDescripcion) {
         canvas.drawText(item, 10f, y, descripcion)
            y += 15
        }

        pdfDocument.finishPage(pagina1)

        val file = File (Environment.getExternalStorageDirectory(), "Archivo.pdf")
        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(this, "Se creo el PDF correctament", Toast.LENGTH_LONG).show()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        pdfDocument.close()
    }

    private  fun checkPermission(): Boolean{
        val permission1 = ContextCompat.checkSelfPermission(applicationContext, WRITE_EXTERNAL_STORAGE)
        val permission2 = ContextCompat.checkSelfPermission(applicationContext, READ_EXTERNAL_STORAGE)

        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED
    }

    private  fun  requestPermissions () {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
            200
        )
    }

        override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray){
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            if (requestCode == 200){
                if (grantResults.size > 0){

                    val writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED
                    val readStorage = grantResults[1]== PackageManager.PERMISSION_GRANTED

                    if(writeStorage && readStorage) {
                        Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(this, "Pemisos rechazados", Toast.LENGTH_LONG).show()
                        finish()

                }
            }
        }
    }
}
