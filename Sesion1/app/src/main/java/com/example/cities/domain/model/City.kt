package com.example.cities.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class City(val id: Int, val name: String, val description: String, val sunshineHours: Int) :Parcelable