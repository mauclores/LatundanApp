package com.mauclores.latundanapp.data.food

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mauclores.latundanapp.data.food.Food
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {

    @Query("SELECT * FROM food")
    fun getAllFood(): Flow<List<Food>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllFood(food: List<Food>)

    @Query("DELETE FROM food")
    suspend fun deleteAllFood()
}