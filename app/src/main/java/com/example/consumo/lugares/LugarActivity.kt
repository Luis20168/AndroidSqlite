package com.example.consumo.lugares

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.consumo.R
import com.example.consumo.databinding.ActivityLugarBinding
import com.example.consumo.model.ManagerBd

class LugarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLugarBinding
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLugarBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtener los datos enviados desde la actividad anterior
        val nombreLugar = intent.getStringExtra("nombre_lugar")
        val info = intent.getStringExtra("info")
        val latitude = intent.getDoubleExtra(
            "latitude",
            0.0
        ) // El segundo parámetro es el valor predeterminado
        val longitude = intent.getDoubleExtra(
            "longitude",
            0.0
        )
        val img= intent.getIntExtra("img",0)


        binding.title.text = nombreLugar
        binding.info.text = info
        binding.img.setImageResource(img)

        binding.btnSave.setOnClickListener {
            val manager=ManagerBd(this)
            if (nombreLugar != null) {
                manager.insertData3(nombreLugar, longitude, latitude)
                Toast.makeText(this, "Datos gaurdados de $nombreLugar", Toast.LENGTH_SHORT).show()

                mediaPlayer?.release() // Liberar el reproductor de medios anterior si existe
                mediaPlayer = MediaPlayer.create(this, R.raw.guardado)
                mediaPlayer?.start()
            }

        }







    }
}