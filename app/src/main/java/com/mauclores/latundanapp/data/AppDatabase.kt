package com.mauclores.latundanapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mauclores.latundanapp.data.cities.City
import com.mauclores.latundanapp.data.cities.CityDao
import com.mauclores.latundanapp.data.food.Food
import com.mauclores.latundanapp.data.food.FoodDao

@Database(entities = [City::class, Food::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun cityDao(): CityDao

    abstract fun foodDao(): FoodDao
}