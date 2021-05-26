package com.mauclores.latundanapp.data.cities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cities")
data class City(
    @PrimaryKey val name: String,
    val image: String,
    val description: String
): Parcelable {
    @Ignore
    constructor(): this("", "", "") {}
}