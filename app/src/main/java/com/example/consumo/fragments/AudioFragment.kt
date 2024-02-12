package com.example.consumo.fragments

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.consumo.R
import com.example.consumo.databinding.FragmentAudioBinding

class AudioFragment : Fragment() {

    private var _binding: FragmentAudioBinding? = null
    private val binding get() = _binding!!

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAudioBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Liberar el reproductor de medios anterior si existe
        mediaPlayer?.release()

        // Crear y empezar a reproducir el nuevo reproductor de medios
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.tema)
        mediaPlayer?.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release() // Liberar el reproductor de medios cuando se destruye el fragmento
    }
}
