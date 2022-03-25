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


class Frag3 : Fragment() {

    private lateinit var binding : FragmentFrag3Binding
    val args : Frag3Args by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFrag3Binding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val namaOrang = args.nama
        binding.tvNama.text ="Selamat Pagi... $namaOrang"

        binding.btnHalTiga.setOnClickListener{
            val data = DataBadan(0,0 ,0.0)
            val nama  = Frag3Directions.actionFrag3ToFrag4(data,namaOrang)
            findNavController().navigate(nama)
        }
        with(binding){

            val hasil = args.hasilImt

            if( hasil == null){

                tvUsia.visibility = View.GONE
                tvBeratBadan.visibility = View.GONE
                tvTinggiBadan.visibility = View.GONE
                tvHasiImt.visibility = View.GONE

            }else{

                val usia = hasil.usia
                val beratBadan = hasil.beratBadan
                val tinggiBadan = hasil.tinggiBadan

                val nilaiImt = beratBadan / (tinggiBadan*tinggiBadan)
                var ket = " "

                when{
                    nilaiImt < 18.5 -> {
                     ket = "BERAT BADAN ANDA KURANG!"
                    }
                    nilaiImt in 18.5..22.9 -> {
                        ket = "BERAT BADAN ANDA NORMAL!"
                    }
                    nilaiImt in 23.0..29.9-> {
                        ket = "BERAT BADAN ANDA BERLEBIH!"
                    }
                    nilaiImt > 30.0 -> {
                        ket = " ANDA SUDAH OBESITAS !! TURUNKAN BERAT BADAN"
                    }
                }

                tvUsia.text = "Usia anda : $usia"
                tvBeratBadan.text = "Berat badan anda : $beratBadan"
                tvTinggiBadan.text = "Tinggi badan anda : $tinggiBadan"
                tvHasiImt.text = " Nilai IMT anda adalah : $nilaiImt"
                tvKet.text = ket
                btnHalTiga.visibility = View.GONE
                tvUsia.visibility = View.VISIBLE
                tvBeratBadan.visibility = View.VISIBLE
                tvTinggiBadan.visibility = View.VISIBLE
                tvHasiImt.visibility = View.VISIBLE
                tvKet.visibility=View.VISIBLE


            }


        }

    }


}