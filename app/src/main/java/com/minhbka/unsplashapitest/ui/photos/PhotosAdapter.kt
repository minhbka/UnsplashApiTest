package com.minhbka.unsplashapitest.ui.photos

import android.database.DatabaseUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.minhbka.unsplashapitest.R
import com.minhbka.unsplashapitest.databinding.RecycleviewPhotoBinding
import com.minhbka.unsplashapitest.network.responses.UnsplashPhoto

class PhotosAdapter(
    private val photos:List<UnsplashPhoto>
):RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        PhotoViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recycleview_photo,
                parent,
                false
            )
        )

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.recycleviewPhotoBinding.photo = photos[position]
    }

    class PhotoViewHolder(
        val recycleviewPhotoBinding: RecycleviewPhotoBinding
    ) : RecyclerView.ViewHolder(recycleviewPhotoBinding.root)
}