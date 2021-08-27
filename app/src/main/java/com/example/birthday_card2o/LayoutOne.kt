package com.example.birthday_card2o

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.graphics.drawable.toBitmap
import com.example.birthday_card2o.databinding.LayoutOneBinding

class LayoutOne : AppCompatActivity() {

    private lateinit var binding: LayoutOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameOne = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveOne.text = "Click on share to get a birthday quote along"



        binding.btnShareOne.setOnClickListener {
            // Step 1: Create Share intent
            val intent = Intent(Intent.ACTION_SEND).setType("image/*")

            // Step 2: Get Bitmap Drawable file from imageView
            val bitmapDrawable = binding.ivLayoutOne.drawable.toBitmap() // your imageView here.

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
                "Count not the candles…see the lights they give. Count not the " +
                        "years, but the life you live. Wishing you a wonderful time ahead. Happy birthday " +
                        "*_${nameOne}_*!!!"
            )

            // Step 6: Put Uri as extra to share intent
            intent.putExtra(Intent.EXTRA_STREAM, uri)

            // Step 7: Start Activity with chooser and pass the intent
            startActivity(Intent.createChooser(intent, "Share Image"))

        }
    }
}