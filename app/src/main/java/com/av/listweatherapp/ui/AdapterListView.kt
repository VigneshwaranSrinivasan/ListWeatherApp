package com.av.listweatherapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.av.listweatherapp.databinding.ListItemBinding
import com.av.listweatherapp.room.DetailsData

class AdapterListView(val listner: OnItemClickListener) :
    ListAdapter<DetailsData, AdapterListView.MyViewHolder>(DiffUtillCallBack()) {

    var items = ArrayList<DetailsData>()

    /*fun setlistItem(data: ArrayList<DetailsData>){
        this.items = data
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class MyViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(detailsData: DetailsData) {
            binding.apply {
                /*Glide.with(itemView)*/
                firstName.text = detailsData.firstName
                lastName.text = detailsData.lastName
                emailAddress.text = detailsData.emailAddress
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(detailsData: DetailsData)
    }

    class DiffUtillCallBack : DiffUtil.ItemCallback<DetailsData>() {
        override fun areItemsTheSame(oldItem: DetailsData, newItem: DetailsData) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: DetailsData, newItem: DetailsData) = oldItem == newItem
    }
}