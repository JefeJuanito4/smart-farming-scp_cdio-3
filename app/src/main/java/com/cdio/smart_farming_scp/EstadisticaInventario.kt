package com.cdio.smart_farming_scp
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cdio.smart_farming_scp.databinding.EstadisticasInventarioBinding
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import kotlin.math.roundToInt


class EstadisticaInventario : AppCompatActivity() {


    val embo: String= "Total embolsados"
    val cosecha: String= " Total cosecha"
    private lateinit var binding: EstadisticasInventarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EstadisticasInventarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val embolsados11: String? = bundle?.getString("TracimosEmbolsadosP1")
        val cantTotcos1: String? = bundle?.getString("TracimosCultivadosP1")
        val cantTotemb2: String? = bundle?.getString("TracimosCultivadosP2")
        val cantTotcos2: String? = bundle?.getString("TracimosCultivadosP2")

        val puntos = ArrayList<Bar>()


        binding.botonGrficar.setOnClickListener {
            graficarBarras(puntos)
        }

      // binding.buttonAgregar.setOnClickListener{
        if (embolsados11 != null) {
            if (cantTotcos1 != null) {
                agregarGraficasBarras(puntos, embolsados11, cantTotcos1)
            }
        }



    }


    fun agregarGraficasBarras(puntos: ArrayList<Bar>, embolsados11: String, cantTotcos1: String) {
        val barra2 = Bar()
        val barra1 = Bar()
        val color = generarColorHexAleatorio()
        barra1.color = Color.parseColor(color)
        barra1.name = embo
        barra1.value = embolsados11.toFloat()
        barra2.name = cosecha
        barra2.value = cantTotcos1.toFloat()

        puntos.add(barra1)
        puntos.add(barra2)

    }

    fun graficarBarras( puntos: ArrayList<Bar>) {

        val barra = Bar()
        val color = generarColorHexAleatorio()
        barra.color = Color.parseColor(color)
        barra.name = binding.concepto.text.toString()
        barra.value = binding.valor.text.toString().toFloat()
       /* barra1.name = embo
        barra1.value = embolsados1.toFloat()
        barra2.name = cosecha
        barra2.value = cos.toFloat()
        puntos.add(barra1)
        puntos.add(barra2)*/
        puntos.add(barra)
        val grafica = findViewById<View>(R.id.graphBar) as BarGraph
        grafica.bars = puntos


    }


    fun generarColorHexAleatorio(): String {
        val letras = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F")
        var color = "#"
        for (i in 0 ..5){
            color += letras [(Math.random()*15).roundToInt()]
        }
        return color
    }
}