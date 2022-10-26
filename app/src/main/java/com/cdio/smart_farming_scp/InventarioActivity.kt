package com.cdio.smart_farming_scp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_inventario.*


class InventarioActivity : AppCompatActivity(){

        private lateinit var tabLayout: TabLayout
        private lateinit var viewPager: ViewPager

        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_inventario)

            tabLayout = findViewById(R.id.tablayout)
            viewPager = findViewById(R.id.viewpager)

            //tabLayout.setupWithViewPager(viewPager)

            val adaptador1 = Adaptador1(
                supportFragmentManager
            )
            adaptador1.addFragment(PropiedadesInventario(), "Propiedades")
            adaptador1.addFragment(DemandaInventario(), "Demanda")
            adaptador1.addFragment(InformeInventario(), "Informe")
            viewPager.adapter = adaptador1

        }
    }