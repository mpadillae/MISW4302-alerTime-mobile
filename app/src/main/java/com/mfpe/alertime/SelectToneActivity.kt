package com.mfpe.alertime

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mfpe.alertime.databinding.ActivitySelectToneBinding

class SelectToneActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectToneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectToneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.card1.setOnClickListener {
            binding.ivCard1.visibility = View.VISIBLE
            binding.ivCard2.visibility = View.GONE
            binding.ivCard3.visibility = View.GONE
            binding.ivCard4.visibility = View.GONE
            binding.ivCard5.visibility = View.GONE
            binding.ivCard6.visibility = View.GONE
        }

        binding.card2.setOnClickListener {
            binding.ivCard1.visibility = View.GONE
            binding.ivCard2.visibility = View.VISIBLE
            binding.ivCard3.visibility = View.GONE
            binding.ivCard4.visibility = View.GONE
            binding.ivCard5.visibility = View.GONE
            binding.ivCard6.visibility = View.GONE
        }

        binding.card3.setOnClickListener {
            binding.ivCard1.visibility = View.GONE
            binding.ivCard2.visibility = View.GONE
            binding.ivCard3.visibility = View.VISIBLE
            binding.ivCard4.visibility = View.GONE
            binding.ivCard5.visibility = View.GONE
            binding.ivCard6.visibility = View.GONE
        }

        binding.card4.setOnClickListener {
            binding.ivCard1.visibility = View.GONE
            binding.ivCard2.visibility = View.GONE
            binding.ivCard3.visibility = View.GONE
            binding.ivCard4.visibility = View.VISIBLE
            binding.ivCard5.visibility = View.GONE
            binding.ivCard6.visibility = View.GONE
        }

        binding.card5.setOnClickListener {
            binding.ivCard1.visibility = View.GONE
            binding.ivCard2.visibility = View.GONE
            binding.ivCard3.visibility = View.GONE
            binding.ivCard4.visibility = View.GONE
            binding.ivCard5.visibility = View.VISIBLE
            binding.ivCard6.visibility = View.GONE
        }

        binding.card6.setOnClickListener {
            binding.ivCard1.visibility = View.GONE
            binding.ivCard2.visibility = View.GONE
            binding.ivCard3.visibility = View.GONE
            binding.ivCard4.visibility = View.GONE
            binding.ivCard5.visibility = View.GONE
            binding.ivCard6.visibility = View.VISIBLE
        }

    }
}