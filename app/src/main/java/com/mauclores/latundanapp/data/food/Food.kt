package com.mauclores.latundanapp.data.food

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "food")
data class Food(
    @PrimaryKey val name: String,
    val image: String
)