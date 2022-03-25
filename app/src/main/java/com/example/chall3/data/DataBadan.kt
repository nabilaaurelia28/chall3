package com.example.chall3.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataBadan (val usia : Int, val beratBadan : Int, val tinggiBadan : Double) : Parcelable {
    }

