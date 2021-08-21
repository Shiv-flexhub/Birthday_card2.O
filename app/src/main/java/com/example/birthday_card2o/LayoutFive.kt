package com.example.birthday_card2o

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.graphics.drawable.toBitmap
import com.example.birthday_card2o.databinding.LayoutFiveBinding

class LayoutFive : AppCompatActivity() {
    private lateinit var binding: LayoutFiveBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutFiveBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameFive = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveFive.text = "Happy born day \n $nameFive"

        binding.btnLayoutFiveBack.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }

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

            intent.putExtra(Intent.EXTRA_TEXT, "Happy Birthday $nameFive")

            // Step 6: Put Uri as extra to share intent
            intent.putExtra(Intent.EXTRA_STREAM, uri)

            // Step 7: Start Activity with chooser and pass the intent
            startActivity(Intent.createChooser(intent,"Share Image"))

        }
    }
}