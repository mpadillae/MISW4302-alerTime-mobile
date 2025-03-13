package com.mfpe.alertime

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.mfpe.alertime.databinding.ActivityCreateAlarmBinding

class CreateAlarmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateAlarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val hours = Array(24) { i -> String.format("%02d", i) }
        val minutes = Array(60) { i -> String.format("%02d", i) }

        binding.hourPicker.minValue = 0
        binding.hourPicker.maxValue = hours.size - 1
        binding.hourPicker.displayedValues = hours
        binding.minutePicker.minValue = 0
        binding.minutePicker.maxValue = minutes.size - 1
        binding.minutePicker.displayedValues = minutes

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            finish()
        }

        binding.cardTono.setOnClickListener {
            val intent = Intent(this, SelectToneActivity::class.java)
            startActivity(intent)
        }

        binding.cardTipoAlarma.setOnClickListener {
            val intent = Intent(this, SelectTypeActivity::class.java)
            startActivity(intent)
        }

        binding.cardRepetir.setOnClickListener {
            val intent = Intent(this, SelectRepeatActivity::class.java)
            startActivity(intent)
        }

        binding.alarmEnabled.setOnCheckedChangeListener { _, b ->
            if (b) {
                val intent = Intent(this, IntrusiveModeActivity::class.java)
                startActivity(intent)
            }
        }

        binding.cardTag.setOnClickListener {
            val editText = EditText(this)
            val dialog = AlertDialog.Builder(this)
                .setTitle("Ingresar etiqueta")
                .setView(editText)
                .setPositiveButton("Aceptar") { dialog, which ->
                    val tag = editText.text.toString()
                    binding.tagText.text = tag
                }
                .setNegativeButton("Cancelar", null)
                .create()
            dialog.show()
        }

    }

}