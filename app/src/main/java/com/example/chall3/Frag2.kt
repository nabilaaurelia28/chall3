package com.example.chall3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.chall3.databinding.FragmentFrag1Binding
import com.example.chall3.databinding.FragmentFrag2Binding

class Frag2 : Fragment() {

    private  lateinit var  binding : FragmentFrag2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFrag2Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnHalDua.setOnClickListener{
            val namaOrang = Frag2Directions.actionFrag2ToFrag3(null,binding.etNama.text.toString())
            findNavController().navigate(namaOrang)
        }
                }

}

