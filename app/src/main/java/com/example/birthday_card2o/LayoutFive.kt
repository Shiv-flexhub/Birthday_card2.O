package com.example.birthday_card2o

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.graphics.drawable.toBitmap
import com.example.birthday_card2o.databinding.LayoutFiveBinding
import com.google.android.gms.ads.*

class LayoutFive : AppCompatActivity() {
    private lateinit var binding: LayoutFiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this){}

        //Banner Ads Initialization
        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"


        val adRequest = AdRequest.Builder().build()
        binding.adView5.loadAd(adRequest)

        binding.adView5.adListener= object : AdListener(){
            override fun onAdLoaded() {
                super.onAdLoaded()
            }
        }

        val nameFive = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveFive.text = "Click on share to get a birthday quote along"



        binding.btnShareFive.setOnClickListener{
            // Step 1: Create Share intent
            val intent = Intent(Intent.ACTION_SEND).setType("image/*")

            // Step 2: Get Bitmap Drawable file from imageView
            val bitmapDrawable = binding.ivLayoutFive.drawable.toBitmap() // your imageView here.

            /* Step 3: Convert Drawable File to Bitmap
            val bitmap=bitmapDrawable.bitmap */

            // Step 4: Save image & get path of it
            val path = MediaStore.Images.Media.insertImage(contentResolver, bitmapDrawable, "tempimage", null)

            // Step 5: Get URI of saved image
            val uri = Uri.parse(path)

            intent.putExtra(Intent.EXTRA_TEXT, "You are the sweetest person I know, and this birthday" +
                    " is a fresh beginning. I wish you confidence, courage, and capability. " +
                    "Happy bornday *_${nameFive}_*!!@@!!")

            // Step 6: Put Uri as extra to share intent
            intent.putExtra(Intent.EXTRA_STREAM, uri)

            // Step 7: Start Activity with chooser and pass the intent
            startActivity(Intent.createChooser(intent,"Share Image"))

        }
    }
}