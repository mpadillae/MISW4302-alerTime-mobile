package com.mfpe.alertime

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mfpe.alertime.databinding.ActivityIntrusiveModeBinding

class IntrusiveModeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntrusiveModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntrusiveModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            finish()
        }
    }
}