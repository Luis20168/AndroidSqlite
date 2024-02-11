package com.example.consumo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.consumo.databinding.ActivityTwoBinding
import com.example.consumo.model.ManagerBd

class twoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var btnIrMapa= binding.btnMapa
        btnIrMapa.setOnClickListener {

                // Crea un Intent para iniciar ActivityB
                val intent = Intent(this, MapsActivity::class.java)

                // Inicia ActivityB utilizando el Intent
                startActivity(intent)


        }

        var btnLlennarCiudad= binding.btnDbcity
        btnLlennarCiudad.setOnClickListener {


            val intent = Intent(this, MainActivity::class.java)


            startActivity(intent)


        }


        binding.btnData.setOnClickListener {
            val codData= binding.codData.text.toString()
            val codNombre= binding.nombreData.text.toString()
            val codTelefono= binding.telefonoData.text.toString()
            val codDireccion= binding.direccionData.text.toString()
            val codCiudad= binding.ciudadData.text.toString()

            if (codData.isEmpty() || codNombre.isEmpty() || codTelefono.isEmpty() || codTelefono.isEmpty() || codDireccion.isEmpty() || codCiudad.isEmpty()){
                Toast.makeText(this, "Los campos no pueden ir vacios", Toast.LENGTH_SHORT).show()
            }
            else{
                val manager = ManagerBd(this)
                manager.insertData2(codData.toInt(), codNombre, codTelefono.toInt(), codDireccion, codCiudad)

                Toast.makeText(this, "Base de Datos Creada ::)", Toast.LENGTH_SHORT).show()

            }


        }
    }
}