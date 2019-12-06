package com.e.bpjs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ProgressBar

class TenagaKerja : AppCompatActivity() {
    lateinit var webView: WebView
    lateinit var pb: ProgressBar
    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tenaga_kerja)

        webView = findViewById(R.id.webView)
        pb = findViewById(R.id.pb)
        webView.settings.javaScriptEnabled = true

        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                if (newProgress == 100) {
                    pb.visibility = View.GONE
                }
            }
        }
        url = intent.getStringExtra("URL")
        webView.loadUrl(url)

    }
}
