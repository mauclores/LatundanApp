package com.mauclores.latundanapp.api

import com.mauclores.latundanapp.data.cities.City
import com.mauclores.latundanapp.data.food.Food

data class CitiesFoodResponse(
    val foods: List<Food>,
    val cities: List<City>
)