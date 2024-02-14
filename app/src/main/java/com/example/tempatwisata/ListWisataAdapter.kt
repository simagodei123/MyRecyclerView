package com.example.tempatwisata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tempatwisata.databinding.ItemRowWisataBinding

class ListWisataAdapter(private val listWisatas: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRowWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name,description,photo) = listWisatas[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(listWisatas[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listWisatas.size

    class ListViewHolder(var binding: ItemRowWisataBinding) : RecyclerView.ViewHolder(binding.root)

    interface OnItemClickCallback{
        fun onItemClicked(data: Wisata)
    }

}