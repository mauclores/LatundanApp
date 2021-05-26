package com.mauclores.latundanapp.data.cities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun getAllCities(): Flow<List<City>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(cities: List<City>)

    @Query("DELETE FROM cities")
    suspend fun deleteAllCities()
}