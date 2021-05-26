package com.mauclores.latundanapp.ui.cities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mauclores.latundanapp.data.cities.City
import com.mauclores.latundanapp.databinding.CityItemBinding

class CitiesViewAdapter(private val listener: OnItemClickListener) :
    ListAdapter<City, CitiesViewAdapter.CityViewHolder>(CityComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding =
            CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class CityViewHolder(private val binding: CityItemBinding):
            RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(city: City) {
            binding.apply {
                Glide.with(itemView)
                    .load(city.image)
                    .into(imageViewFoodPhoto)

                textViewFoodName.text = city.name
                textViewCityDesc.text = city.description
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(city: City)
    }

    class CityComparator: DiffUtil.ItemCallback<City>() {
        override fun areItemsTheSame(oldItem: City, newItem: City) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: City, newItem: City) =
            oldItem == newItem

    }
}