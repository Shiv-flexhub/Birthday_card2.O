package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.birthday_card2o.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.generateButton.setOnClickListener {
            val name = binding.textinputedit.text.toString()
            Intent(this, SecondActivity::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                startActivity(it)
            }
        }
            binding.thirdBtn.setOnClickListener {
                Intent(this,third_activity::class.java).also {
                    startActivity(it)
                }
            }

    }
}