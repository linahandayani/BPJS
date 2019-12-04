package com.e.bpjs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.synnapps.carouselview.CarouselView

class MainActivity : AppCompatActivity() {
    lateinit var carouselView: CarouselView
    val sampleImages = intArrayOf(
        R.drawable.satu,
        R.drawable.dua,
        R.drawable.tiga
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        carouselView = findViewById(R.id.carouselView)
        carouselView.setPageCount(3)
//        posisi and image
        carouselView.setImageListener { position, imageView ->
            Glide.with(this@MainActivity).load(sampleImages[position]).into(imageView)
        }
    }


}
