package com.minhbka.unsplashapitest.ui.photos

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.minhbka.unsplashapitest.R
import com.minhbka.unsplashapitest.network.UnsplashApi
import com.minhbka.unsplashapitest.repository.UnsplashPhotosRepository
import kotlinx.android.synthetic.main.photos_fragment.*

class PhotosFragment : Fragment() {

    private lateinit var factory: PhotosViewModelFactory
    private lateinit var viewModel: PhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.photos_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = UnsplashApi()
        val repository = UnsplashPhotosRepository(api)
        factory = PhotosViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(PhotosViewModel::class.java)
        viewModel.getPhotos()
        viewModel.photos.observe(viewLifecycleOwner, Observer {photos->
            recycle_view_photos.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = PhotosAdapter(photos)
            }
        })

    }

}
