package com.mfpe.alertime

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mfpe.alertime.databinding.ActivitySelectTypeBinding

class SelectTypeActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.card1.setOnClickListener {
            binding.ivCard1.visibility = View.VISIBLE
            binding.ivCard2.visibility = View.GONE
            binding.ivCard3.visibility = View.GONE
        }

        binding.card2.setOnClickListener {
            binding.ivCard1.visibility = View.GONE
            binding.ivCard2.visibility = View.VISIBLE
            binding.ivCard3.visibility = View.GONE
        }

        binding.card3.setOnClickListener {
            binding.ivCard1.visibility = View.GONE
            binding.ivCard2.visibility = View.GONE
            binding.ivCard3.visibility = View.VISIBLE
            val intent = Intent(this, SelectLocationActivity::class.java)
            startActivity(intent)
        }

    }
}