package com.mauclores.latundanapp.ui.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mauclores.latundanapp.data.food.Food
import com.mauclores.latundanapp.databinding.FoodItemBinding

class FoodViewAdapter() : ListAdapter<Food, FoodViewAdapter.FoodViewHolder>(FoodComparator()) {

    class FoodViewHolder(private val binding: FoodItemBinding):
            RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Food) {
            binding.apply {
                Glide.with(itemView)
                    .load(food.image)
                    .into(imageViewFoodPhoto)

                textViewFoodName.text = food.name
            }
        }
    }

    class FoodComparator: DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Food, newItem: Food) =
            oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding =
            FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }
}