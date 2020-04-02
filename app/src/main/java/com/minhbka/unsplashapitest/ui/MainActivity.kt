package com.minhbka.unsplashapitest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.minhbka.unsplashapitest.R
import com.minhbka.unsplashapitest.network.UnsplashApi
import com.minhbka.unsplashapitest.repository.UnsplashPhotosRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = UnsplashPhotosRepository(UnsplashApi())
        GlobalScope.launch (Dispatchers.Main){
            val photos = repository.getUnsplashPhotos()

            Log.d("DEBUG", photos.size.toString())
            photos.forEach {
                text.append("${it.id} - ${it.user.name}\n")
            }
        }
    }
}
