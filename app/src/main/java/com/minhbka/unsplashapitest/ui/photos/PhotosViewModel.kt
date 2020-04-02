package com.minhbka.unsplashapitest.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.minhbka.unsplashapitest.network.responses.UnsplashPhoto
import com.minhbka.unsplashapitest.repository.UnsplashPhotosRepository
import com.minhbka.unsplashapitest.utils.Coroutines
import kotlinx.coroutines.Job

class PhotosViewModel(
    private val repository: UnsplashPhotosRepository
) : ViewModel() {
    private lateinit var job: Job
    private val _photos = MutableLiveData<List<UnsplashPhoto>>()
    val photos : LiveData<List<UnsplashPhoto>>
        get() = _photos


    fun getPhotos() {
        job = Coroutines.ioThenMain(
            {repository.getUnsplashPhotos()},
            {
                _photos.value = it ?: arrayListOf()
            }
        )


    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }


}
