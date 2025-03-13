package com.mfpe.alertime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mfpe.alertime.databinding.ActivitySelectRepeatCustomBinding

class SelectRepeatCustomActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectRepeatCustomBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectRepeatCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            finish()
        }
    }
}