package com.example.consumo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.consumo.databinding.ActivityListarDatosBinding
import com.example.consumo.model.Ciudad
import com.example.consumo.model.ManagerBd

class listarDatosActivity : AppCompatActivity() {

    private lateinit var binding:ActivityListarDatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityListarDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mananger=ManagerBd(this)
        val arrayCiudad= mananger.getData()

        val listCiudad= binding.listvCiudad
        val arrayAdapter= ArrayAdapter<Ciudad>(this, android.R.layout.simple_list_item_1, arrayCiudad)

        listCiudad.adapter=arrayAdapter
        Toast.makeText(this, "Datos listados", Toast.LENGTH_LONG).show()

    }
}