package com.mauclores.latundanapp.ui.cities

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.mauclores.latundanapp.R
import com.mauclores.latundanapp.databinding.FragmentCityDetailsBinding

class DetailsFragment: Fragment(R.layout.fragment_city_details) {

    private val args by navArgs<DetailsFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentCityDetailsBinding.bind(view)

        binding.apply {
            val city = args.city

            Glide.with(this@DetailsFragment)
                    .load(city.image)
                    .error(R.drawable.ic_error)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?,
                                                  isFirstResource: Boolean): Boolean {
                            progressBar.isVisible = false
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?,
                                                     dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            progressBar.isVisible = false
                            textViewFoodName.isVisible = true
                            textViewFoodDesc.isVisible = true
                            return false
                        }
                    })
                    .into(imageViewCityPhoto)

            textViewFoodName.text = city.name
            textViewFoodDesc.text = city.description
        }
    }
}