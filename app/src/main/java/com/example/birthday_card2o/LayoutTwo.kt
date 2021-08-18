package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birthday_card2o.databinding.ActivityMainBinding.inflate
import com.example.birthday_card2o.databinding.LayoutTwoBinding

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
    }
}