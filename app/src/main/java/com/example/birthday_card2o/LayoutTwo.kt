package com.example.birthday_card2o

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import com.example.birthday_card2o.databinding.ActivityMainBinding.bind
import com.example.birthday_card2o.databinding.ActivityMainBinding.inflate
import com.example.birthday_card2o.databinding.LayoutTwoBinding
import com.google.android.gms.ads.*
import java.io.ByteArrayOutputStream
import java.io.File

class LayoutTwo : AppCompatActivity() {

    private lateinit var binding: LayoutTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this){} //Banner Ads Initialization

        val adView = AdView(this) //
        adView.adSize = AdSize.BANNER
        adView.adUnitId = "ca-app-pub-3940256099942544/6300978111"


        val adRequest = AdRequest.Builder().build()
        binding.adView2.loadAd(adRequest)

        binding.adView2.adListener= object : AdListener(){
            override fun onAdLoaded() {
                super.onAdLoaded()
            }
        }

        val nameTwo = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveTwo.text = "Click on share to get a birthday quote along"



        binding.btnShareTwo.setOnClickListener {
            // Step 1: Create Share intent
            val intent = Intent(Intent.ACTION_SEND).setType("image/*")

            // Step 2: Get Bitmap Drawable file from imageView
            val bitmapDrawable = binding.ivLayoutTwo.drawable.toBitmap() // your imageView here.

            /* Step 3: Convert Drawable File to Bitmap
            val bitmap=bitmapDrawable.bitmap */

            // Step 4: Save image & get path of it
            val path = MediaStore.Images.Media.insertImage(
                contentResolver,
                bitmapDrawable,
                "tempimage",
                null
            )

            // Step 5: Get URI of saved image
            val uri = Uri.parse(path)

            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Just wanted to be the first one to wish you happy birthday so I can feel superior " +
                        "to your other well-wishers. So,Happiest Birthday *_${nameTwo}_*"
            )

            // Step 6: Put Uri as extra to share intent
            intent.putExtra(Intent.EXTRA_STREAM, uri)

            // Step 7: Start Activity with chooser and pass the intent
            startActivity(Intent.createChooser(intent, "Share Image"))

        }
    }
}
