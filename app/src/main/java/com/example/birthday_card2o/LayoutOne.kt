package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birthday_card2o.databinding.LayoutOneBinding

class LayoutOne : AppCompatActivity() {

    private lateinit var binding: LayoutOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= LayoutOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameOne = intent.getStringExtra("EXTRA_NAME")
        binding.tvReceiveOne.text = "Happy Birthday $nameOne!!!"

        binding.btnLayoutOneBack.setOnClickListener {
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}