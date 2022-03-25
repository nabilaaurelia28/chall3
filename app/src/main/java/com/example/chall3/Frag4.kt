package com.example.chall3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.chall3.data.DataBadan
import com.example.chall3.databinding.FragmentFrag2Binding
import com.example.chall3.databinding.FragmentFrag3Binding
import com.example.chall3.databinding.FragmentFrag4Binding


class Frag4 : Fragment() {
    private lateinit var binding : FragmentFrag4Binding

    val args : Frag4Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFrag4Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnHalEmpat.setOnClickListener{
            val data = DataBadan(
                binding.etUsia.text.toString().toInt(),
                binding.etBeratBadan.text.toString().toInt(),
                binding.etTinggiBadan.text.toString().toDouble()
            )
            val imt = Frag4Directions.actionFrag4ToFrag3(data,args.nama)
            findNavController().navigate(imt)
        }
    }

}
