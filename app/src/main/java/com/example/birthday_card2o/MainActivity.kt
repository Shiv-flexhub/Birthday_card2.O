package com.example.birthday_card2o

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.birthday_card2o.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnCardOne.setOnClickListener {
            val name = binding.textinputedit.text.toString()
            Intent(this, LayoutOne::class.java).also {
                it.putExtra("EXTRA_NAME", name)
                startActivity(it)

            }
        }

            binding.btnCardTwo.setOnClickListener {
                val name = binding.textinputedit.text.toString()
                Intent(this, LayoutTwo::class.java).also {
                    it.putExtra("EXTRA_NAME", name)
                    startActivity(it)
            }
        }

        binding.btnCardThree.setOnClickListener {
            val name = binding.textinputedit.text.toString()
            Intent(this, LayoutThree::class.java).also {
                it.putExtra("EXTRA_NAME",name)
                startActivity(it)
            }
        }

        binding.btnCardFour.setOnClickListener {
            val name = binding.textinputedit.text.toString()
            Intent(this, LayoutFour::class.java).also {
                it.putExtra("EXTRA_NAME",name)
                startActivity(it)
            }
        }

        binding.btnCardFIve.setOnClickListener {
            val name = binding.textinputedit.text.toString()
            Intent(this,LayoutFive::class.java).also{
                it.putExtra("EXTRA_NAME",name)
                startActivity(it)
            }
        }

        binding.btnCardSix.setOnClickListener {
            val name = binding.textinputedit.text.toString()
            Intent(this,LayoutSix::class.java).also {
                it.putExtra("EXTRA_NAME",name)
                startActivity(it)
            }
        }

    }
}