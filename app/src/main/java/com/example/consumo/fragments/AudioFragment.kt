package com.example.consumo.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.consumo.R
import com.example.consumo.databinding.FragmentAudioBinding


class AudioFragment : Fragment() {

    private var _binding: FragmentAudioBinding?=null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding=FragmentAudioBinding.inflate(layoutInflater,container,false)
        return binding.root

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.musica)

        btnMusic()

    }

    private fun btnMusic() {
        binding.btnPlayMusic.setOnClickListener {
            mediaPlayer?.start()
        }
    }


}