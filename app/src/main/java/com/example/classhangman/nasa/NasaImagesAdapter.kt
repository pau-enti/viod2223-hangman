package com.example.classhangman.nasa

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.classhangman.R
import com.example.classhangman.databinding.ItemImageNasaBinding
import com.squareup.picasso.Picasso

class NasaImagesAdapter(val context: Context) : RecyclerView.Adapter<NasaImagesAdapter.ImageViewHolder>() {

    private var imagesList = listOf<NasaImage>()

    fun updateImagesList(list: List<NasaImage>) {
        imagesList = list
        notifyDataSetChanged()
    }

    inner class ImageViewHolder(binding: ItemImageNasaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val title = binding.nasaImageTitle
//        val description = binding.imageDescription
        val image = binding.nasaImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageNasaBinding.inflate(inflater)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val img = imagesList[position]
        holder.title.text = img.title
//        holder.description.text = img.description

        Picasso.Builder(context)
            .build()
            .load(img.link)
            .placeholder(R.drawable.placeholder)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }


}