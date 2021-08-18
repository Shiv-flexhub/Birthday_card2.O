package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birthday_card2o.databinding.LayoutSixBinding

class LayoutSix : AppCompatActivity() {
    private lateinit var binding: LayoutSixBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutSixBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameSix = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveSix.text = "Many many happy returns of the day dear $nameSix"

        binding.btnLayoutSixBack.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}