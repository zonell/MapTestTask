package com.example.mapstesttask.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mapstesttask.R
import com.example.mapstesttask.data.model.pointListResponse.ClubNewsStatusesItem
import com.example.mapstesttask.databinding.ItemPontListBinding

/**
 * Created by O.Dziuba on 26.10.2023.
 */
class PointListAdapter : RecyclerView.Adapter<PointListAdapter.PointListVH>() {

    private lateinit var binding: ItemPontListBinding

    class PointListVH(binding: ItemPontListBinding) : RecyclerView.ViewHolder(binding.root)

    private val callback = object : DiffUtil.ItemCallback<ClubNewsStatusesItem>() {

        override fun areItemsTheSame(
            oldItem: ClubNewsStatusesItem,
            newItem: ClubNewsStatusesItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ClubNewsStatusesItem,
            newItem: ClubNewsStatusesItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    val list = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PointListVH {
        return PointListVH(
            ItemPontListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.currentList.size

    override fun onBindViewHolder(holder: PointListVH, position: Int) {
        val item = list.currentList[position]
        binding = ItemPontListBinding.bind(holder.itemView)
        binding.apply {
            tvId.text = tvId.context.getString(R.string.tv_id, item.id)
            tvTitle.text = tvId.context.getString(R.string.tv_title, item.title)
        }
    }
}