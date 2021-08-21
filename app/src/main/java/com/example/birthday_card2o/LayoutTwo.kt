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
import java.io.ByteArrayOutputStream
import java.io.File

class LayoutTwo : AppCompatActivity() {

    private lateinit var binding: LayoutTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameTwo = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveTwo.text = "Happy Birthday $nameTwo!!"

        binding.btnLayoutTwoBack.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.btnShareTwo.setOnClickListener{
                // Step 1: Create Share intent
                val intent = Intent(Intent.ACTION_SEND).setType("image/*")

                // Step 2: Get Bitmap Drawable file from imageView
                val bitmapDrawable = binding.ivLayoutTwo.drawable.toBitmap() // your imageView here.

                /* Step 3: Convert Drawable File to Bitmap
                val bitmap=bitmapDrawable.bitmap */

                // Step 4: Save image & get path of it
                val path = MediaStore.Images.Media.insertImage(contentResolver, bitmapDrawable, "tempimage", null)

                // Step 5: Get URI of saved image
                val uri = Uri.parse(path)

                intent.putExtra(Intent.EXTRA_TEXT, "Happy Birthday $nameTwo")

                // Step 6: Put Uri as extra to share intent
                intent.putExtra(Intent.EXTRA_STREAM, uri)

                // Step 7: Start Activity with chooser and pass the intent
                startActivity(Intent.createChooser(intent,"Share Image"))

        }
    }
}
