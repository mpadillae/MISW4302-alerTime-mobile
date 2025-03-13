package com.mfpe.alertime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mfpe.alertime.databinding.ActivitySelectFilterBinding

class SelectFilterActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectFilterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnApply.setOnClickListener {
            finish()
        }

        binding.btnClean.setOnClickListener {
            finish()
        }
    }
}