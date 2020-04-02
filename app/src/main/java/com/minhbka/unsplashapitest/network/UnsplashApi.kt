package com.minhbka.unsplashapitest.network

import com.minhbka.unsplashapitest.network.responses.UnsplashPhoto
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.unsplash.com/"
const val CLIENT_ID = "a9fee60afe94322d07edcbf04ae263f2ba173a1c6c11040692082daea5691760"
interface UnsplashApi {
    @GET("photos")
    suspend fun getPhotos(
        @Query("client_id") client_id : String = CLIENT_ID,
        @Query("page") page:Int = 1
    ):Response<List<UnsplashPhoto>>

    companion object{
        operator fun invoke():UnsplashApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(UnsplashApi::class.java)
        }
    }

}