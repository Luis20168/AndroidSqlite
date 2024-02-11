package com.example.consumo

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.consumo.databinding.ActivityMapsBinding
import com.example.consumo.lugares.LugarActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var currentMarker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val items = listOf("Sena", "Morro", "Parque Caldas","Miami")
        val autoComplete: AutoCompleteTextView = binding.autoComplete
        val adapter = ArrayAdapter(this, R.layout.list_item, items)

        autoComplete.setAdapter(adapter)
        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, _, i, _ ->

            val itemSelected = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this, "Dirigiendose a: $itemSelected", Toast.LENGTH_SHORT).show()

            val location = when (itemSelected) {
                "Sena" -> LatLng(2.4834441115192067, -76.56176399432523)
                "Morro" -> LatLng(2.444727408287769, -76.60014311631677)
                "Parque Caldas" -> LatLng(2.4403349421351277, -76.6123671868507)
                "Miami" -> LatLng(25.762288015091034, -80.19718931058006)
                else -> null
            }
            binding.btnInfo.setOnClickListener {

                if (itemSelected == "Sena") {


                    val intent = Intent(this, LugarActivity::class.java)



                    intent.putExtra("nombre_lugar", itemSelected)
                    intent.putExtra("img", R.drawable.sena)
                    intent.putExtra("latitude", 2.444727408287769)
                    intent.putExtra("longitude", -76.56176399432523)
                    intent.putExtra("info", "El SENA en Popayán es una institución educativa que ofrece formación técnica y tecnológica en diversas áreas. Es un centro de aprendizaje que contribuye al desarrollo socioeconómico de la región mediante programas de educación y capacitación profesional.")

                    startActivity(intent)
                }

                else if (itemSelected == "Morro") {


                    val intent = Intent(this, LugarActivity::class.java)
                    intent.putExtra("nombre_lugar", itemSelected)
                    intent.putExtra("latitude", 2.444727408287769)
                    intent.putExtra("longitude", -76.60014311631677)
                    intent.putExtra("img", R.drawable.morro)
                    intent.putExtra("info","El Morro de Popayán es una colina emblemática en la ciudad de Popayán, Colombia. Conocido también como \"Cerro de la Tulia\" o \"Cerro de las Tres Cruces\", ofrece una vista panorámica de la ciudad y alrededores desde su cima, donde se encuentran tres cruces blancas. Es un lugar de interés histórico, religioso y turístico, frecuentado por locales y visitantes para actividades al aire libre y disfrutar de su belleza natural.")

                    startActivity(intent)
                }

                else if (itemSelected=="Parque Caldas"){

                    val intent:Intent=Intent(this,LugarActivity::class.java )
                    intent.putExtra("nombre_lugar", itemSelected)
                    intent.putExtra("latitude", 2.4403349421351277 )
                    intent.putExtra("longitude", -76.6123671868507 )

                    intent.putExtra("img", R.drawable.parque)
                    intent.putExtra("info", "El Parque Caldas es un espacio público en el centro histórico de Popayán, Colombia. Es conocido por su arquitectura colonial, áreas verdes y estatua de Francisco José de Caldas. Es un lugar popular para actividades recreativas y culturales en la ciudad.")

                    startActivity(intent)



                }
                else if (itemSelected=="Miami"){

                    val intent:Intent=Intent(this, LugarActivity::class.java )

                    intent.putExtra("nombre_lugar", itemSelected)
                    intent.putExtra("latitude", 25.762288015091034)
                    intent.putExtra("longitude", -80.19718931058006 )

                    intent.putExtra("img", R.drawable.miami)
                    intent.putExtra("info", "Miami es una ciudad ubicada en Florida, Estados Unidos, famosa por sus playas, clima cálido y diversidad cultural. Es un importante centro financiero y de entretenimiento con una vibrante vida nocturna y una escena artística reconocida.")
                    startActivity(intent)



                }
                else{
                    Toast.makeText(this, "Seleccione un luager primero", Toast.LENGTH_SHORT).show()

                }



            }

            location?.let {
                currentMarker?.remove()
                currentMarker = mMap.addMarker(MarkerOptions().position(it).title("Marker"))
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(it, 15f), 2000, null)


                //mMap.moveCamera(CameraUpdateFactory.newLatLng(it))
            } ?: run {
                Toast.makeText(this, "Ubicacion Invalida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
