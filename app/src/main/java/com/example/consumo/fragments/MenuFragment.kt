package com.example.consumo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.consumo.R
import com.example.consumo.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding:FragmentMenuBinding?=null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding=FragmentMenuBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}