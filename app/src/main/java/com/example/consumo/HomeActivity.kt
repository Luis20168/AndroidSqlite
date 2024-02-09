package com.example.consumo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.consumo.R
import com.example.consumo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi() //navegacion



    }




    private fun initUi() {
        initNavigation()
    }

    private fun initNavigation() {
        val navHost= supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController= navHost.navController
        binding.menuBottom.setupWithNavController(navController)

    }




}