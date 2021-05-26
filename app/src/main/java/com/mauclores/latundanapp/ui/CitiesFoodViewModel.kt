package com.mauclores.latundanapp.ui

import androidx.lifecycle.*
import com.mauclores.latundanapp.data.cities.City
import com.mauclores.latundanapp.data.AppRepository
import com.mauclores.latundanapp.data.food.Food
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CitiesFoodViewModel @Inject constructor(
    repository: AppRepository
): ViewModel() {
    val cities = repository.getCities().asLiveData()
    val food = repository.getFood().asLiveData()
}
