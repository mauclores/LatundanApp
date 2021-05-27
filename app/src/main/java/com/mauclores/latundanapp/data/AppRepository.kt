package com.mauclores.latundanapp.data

import androidx.room.withTransaction
import com.mauclores.latundanapp.api.CitiesFoodApi
import com.mauclores.latundanapp.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(
    private val api: CitiesFoodApi,
    private val db: AppDatabase
) {
    private val cityDao = db.cityDao()
    private val foodDao = db.foodDao()

    /* TODO: Check if it's possible to call API only once for both cities and food. */

    fun getCities() = networkBoundResource(
        query = {
            cityDao.getAllCities()
        },
        fetch = {
            //delay(2000)
            api.getCitiesAndFood()
        },
        saveFetchResult = {
            db.withTransaction {
                cityDao.deleteAllCities()
                cityDao.insertCities(it.cities)
            }
        }
    )

    fun getFood() = networkBoundResource(
        query = {
            foodDao.getAllFood()
        },
        fetch = {
            //delay(2000)
            api.getCitiesAndFood()
        },
        saveFetchResult = {
            db.withTransaction {
                foodDao.deleteAllFood()
                foodDao.insertAllFood(it.foods)
            }
        }
    )
}