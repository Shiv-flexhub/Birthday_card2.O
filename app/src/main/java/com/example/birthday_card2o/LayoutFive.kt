package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}