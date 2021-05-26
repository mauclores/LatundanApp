package com.mauclores.latundanapp.ui.cities

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.mauclores.latundanapp.R
import com.mauclores.latundanapp.data.cities.City
import com.mauclores.latundanapp.databinding.FragmentCitiesBinding
import com.mauclores.latundanapp.ui.CitiesFoodViewModel
import com.mauclores.latundanapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesFragment: Fragment(R.layout.fragment_cities), CitiesViewAdapter.OnItemClickListener {

    private val viewModel by viewModels<CitiesFoodViewModel>()

    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.onCreate(savedInstanceState)

        _binding = FragmentCitiesBinding.bind(view)

        val citiesViewAdapter = CitiesViewAdapter(this)

        binding.apply {
            recyclerView.apply {
                adapter = citiesViewAdapter
            }

            viewModel.cities.observe(viewLifecycleOwner) { result ->
                citiesViewAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                //textViewError.text = result.error?.localizedMessage
            }
        }
    }

    override fun onItemClick(city: City) {
        val action = CitiesFragmentDirections.actionCitiesFragmentToDetailsFragment(city)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}