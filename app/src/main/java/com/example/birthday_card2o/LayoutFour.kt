package com.example.birthday_card2o

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.core.graphics.drawable.toBitmap
import com.example.birthday_card2o.databinding.LayoutFourBinding
import com.google.android.gms.ads.*

class LayoutFour : AppCompatActivity() {

    private lateinit var binding: LayoutFourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this){} //Banner Ads Initialization

        val adView = AdView(this) //
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"


        val adRequest = AdRequest.Builder().build()
        binding.adView4.loadAd(adRequest)

        binding.adView4.adListener= object : AdListener(){
            override fun onAdLoaded() {
                super.onAdLoaded()
            }
        }

        val nameFour = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveFour.text = "Click on share to get a birthday quote along"



        binding.btnShareFour.setOnClickListener{
            // Step 1: Create Share intent
            val intent = Intent(Intent.ACTION_SEND).setType("image/*")

            // Step 2: Get Bitmap Drawable file from imageView
            val bitmapDrawable = binding.ivLayoutFour.drawable.toBitmap() // your imageView here.

            /* Step 3: Convert Drawable File to Bitmap
            val bitmap=bitmapDrawable.bitmap */

            // Step 4: Save image & get path of it
            val path = MediaStore.Images.Media.insertImage(contentResolver, bitmapDrawable, "tempimage", null)

            // Step 5: Get URI of saved image
            val uri = Uri.parse(path)

            intent.putExtra(Intent.EXTRA_TEXT, "Happy birthday to one of my best friends. Here’s " +
                    "to another year of laughing at our own jokes and keeping each other sane! Love you " +
                    "and once again many many happy returns of the day *_${nameFour}_*!")

            // Step 6: Put Uri as extra to share intent
            intent.putExtra(Intent.EXTRA_STREAM, uri)

            // Step 7: Start Activity with chooser and pass the intent
            startActivity(Intent.createChooser(intent,"Share Image"))

        }
    }
}