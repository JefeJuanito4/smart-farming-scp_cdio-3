package com.cdio.smart_farming_scp
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cdio.smart_farming_scp.databinding.FragmentDemandaInventarioBinding
import com.cdio.smart_farming_scp.databinding.FragmentDemandaInventarioBinding.inflate
import com.echo.holographlibrary.Bar
import com.echo.holographlibrary.BarGraph
import kotlin.math.roundToInt


class DemandaInventario : AppCompatActivity() {
    private lateinit var binding: FragmentDemandaInventarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        val puntos= ArrayList<Bar>()

        binding.botonAgregar.setOnClickListener {
            graficarBarras(puntos)
        }

    }

    fun graficarBarras( puntos: ArrayList<Bar>){
        val barra = Bar()
        val color =generarColorHexAleatorio()
        barra.color =Color.parseColor(color)
        barra.name =binding.concepto.text.toString()
        barra.value = binding.valor.text.toString().toFloat()

        puntos.add(barra)

        val grafica =findViewById<View>(R.id.graphBar) as BarGraph
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