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
   // val bundle: Bundle? = intent.extras

    //val embolsados11: String? = bundle?.getString("TracimosEmbolsadosP1")

    //val cantTotcos1: String? = bundle?.getString("TracimosCultivadosP1")

   // val cantTotemb2: String? = bundle?.getString("TracimosCultivadosP2")

   // val cantTotcos2: String? = bundle?.getString("TracimosCultivadosP2")

    val embo: String= "Tembolsados1"
    var embolsados1 = 5
    private lateinit var binding: EstadisticasInventarioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = EstadisticasInventarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val puntos1= ArrayList<Bar>()
        val barra = Bar()
        val color = generarColorHexAleatorio()
        barra.color = Color.parseColor(color)
        barra.name = embo
        barra.value = embolsados1.toFloat()

        puntos1.add(barra)

        val grafica = findViewById<View>(R.id.graphBar) as BarGraph
        grafica.bars = puntos1


        val puntos = ArrayList<Bar>()
      // val puntos1 = ArrayList<Bar>()

        binding.botonGrficar.setOnClickListener {
            graficarBarras(puntos)
        }

        binding.buttonAgregar.setOnClickListener{
            agregarGraficasBarras(puntos1)
        }


    }


    fun agregarGraficasBarras(puntos1: ArrayList<Bar>) {

        val barra = Bar()
        val color = generarColorHexAleatorio()
        barra.color = Color.parseColor(color)
        barra.name = embo
        barra.value = embolsados1.toFloat()

        puntos1.add(barra)

        val grafica = findViewById<View>(R.id.graphBar) as BarGraph
        grafica.bars = puntos1


    }

    fun graficarBarras( puntos: ArrayList<Bar>) {

        val barra = Bar()
        val color = generarColorHexAleatorio()
        barra.color = Color.parseColor(color)
        barra.name = binding.concepto.text.toString()
        barra.value = binding.valor.text.toString().toFloat()

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