package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.birthday_card2o.databinding.LayoutFourBinding

class LayoutFour : AppCompatActivity() {

    private lateinit var binding: LayoutFourBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LayoutFourBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameFour = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveFour.text = "Happy bday bestie!! \n $nameFour"

        binding.btnLayoutFourBack.setOnClickListener {
            Intent(this,MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}