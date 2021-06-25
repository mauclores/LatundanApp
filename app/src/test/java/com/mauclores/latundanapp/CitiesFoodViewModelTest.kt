package com.mauclores.latundanapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mauclores.latundanapp.data.AppRepository
import com.mauclores.latundanapp.ui.CitiesFoodViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.spy
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class CitiesFoodViewModelTest {

    @Mock
    private lateinit var viewModel: CitiesFoodViewModel

    @Mock
    private lateinit var repository: AppRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = spy(CitiesFoodViewModel(repository))
    }
}