package com.e.bpjs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val url = "https://www.youtube.com/embed/gS-TAO7DbwA"
    //buat konstanta

    //    carouselView
    val sampleImages = intArrayOf(
        R.drawable.satu,
        R.drawable.dua,
        R.drawable.tiga
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carouselView.setPageCount(3)
//        posisi and image
        carouselView.setImageListener { position, imageView ->
            Glide.with(this@MainActivity).load(sampleImages[position]).into(imageView)
        }

        buttonCariTahu.setOnClickListener {
            var i: Intent
            i = Intent(this@MainActivity, TenagaKerja::class.java)
            i.putExtra("URL", "https://www.bpjsketenagakerjaan.go.id/tentang-kami.html")
            startActivity(i)
        }
        buttonMasukTenaga.setOnClickListener {
            var i: Intent
            i = Intent(this@MainActivity, TenagaKerja::class.java)
            i.putExtra("URL", "https://sso.bpjsketenagakerjaan.go.id/")
            startActivity(i)
        }
        buttonPerusahaan.setOnClickListener {
            var i: Intent
            i = Intent(this@MainActivity, TenagaKerja::class.java)
            i.putExtra("URL", "https://sipp.bpjsketenagakerjaan.go.id/")
            startActivity(i)
        }
        buttonMitra.setOnClickListener {
            var i: Intent
            i = Intent(this@MainActivity, TenagaKerja::class.java)
            i.putExtra("URL", "https://tc.bpjsketenagakerjaan.go.id/login.bpjs")
            startActivity(i)
        }


//   mengload gambar
        Glide.with(this@MainActivity).load(R.drawable.icon_pu).into(imagesatu)
        Glide.with(this@MainActivity).load(R.drawable.icon_perusahaan).into(imagedua)
        Glide.with(this@MainActivity).load(R.drawable.icon_mitra).into(imagetiga)


        // youtube
        webViewYoutube.settings.javaScriptEnabled = true
        webViewYoutube.settings.loadsImagesAutomatically = true
        webViewYoutube.settings.javaScriptCanOpenWindowsAutomatically = true
        webViewYoutube.loadUrl(url)

//membuka aplikasi aplikasi youtube
        webViewYoutube.setOnTouchListener { v, event ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(Intent.createChooser(intent, "Lanjutkan dengan ..."))
            return@setOnTouchListener true
        }
    }


}
