package com.minhbka.unsplashapitest.repository

import com.minhbka.unsplashapitest.network.SafeApiRequest
import com.minhbka.unsplashapitest.network.UnsplashApi

class UnsplashPhotosRepository (
    private val api: UnsplashApi
):SafeApiRequest(){
    suspend fun getUnsplashPhotos() = apiRequest{api.getPhotos()}
}