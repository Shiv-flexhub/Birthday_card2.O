package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birthday_card2o.databinding.LayoutThreeBinding

class LayoutThree : AppCompatActivity() {

    private lateinit var binding: LayoutThreeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameThree = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveThree.text = "Happy Birthday dear $nameThree"

        binding.btnLayoutThreeBack.setOnClickListener {
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}