package com.mauclores.latundanapp.ui.food

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.mauclores.latundanapp.R
import com.mauclores.latundanapp.databinding.FragmentFoodBinding
import com.mauclores.latundanapp.ui.CitiesFoodViewModel
import com.mauclores.latundanapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodFragment: Fragment(R.layout.fragment_food) {
    private val viewModel by viewModels<CitiesFoodViewModel>()

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.onCreate(savedInstanceState)

        _binding = FragmentFoodBinding.bind(view)

        val foodViewAdapter = FoodViewAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = foodViewAdapter
            }

            viewModel.food.observe(viewLifecycleOwner) { result ->
                foodViewAdapter.submitList(result.data)

                progressBar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                //textViewError.text = result.error?.localizedMessage
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}