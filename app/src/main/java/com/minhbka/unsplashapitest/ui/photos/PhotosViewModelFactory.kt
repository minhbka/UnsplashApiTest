package com.minhbka.unsplashapitest.ui.photos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minhbka.unsplashapitest.repository.UnsplashPhotosRepository

@Suppress("UNCHECKED_CAST")
class PhotosViewModelFactory(
    private val repository: UnsplashPhotosRepository
) : ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PhotosViewModel(repository) as T
    }
}