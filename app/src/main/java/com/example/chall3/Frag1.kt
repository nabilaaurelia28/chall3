package com.example.chall3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.chall3.databinding.FragmentFrag1Binding

class Frag1 : Fragment() {

    private lateinit var binding  : FragmentFrag1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentFrag1Binding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHalSatu.setOnClickListener {
            it.findNavController().navigate(R.id.action_frag1_to_frag2)
        }
    }

}
