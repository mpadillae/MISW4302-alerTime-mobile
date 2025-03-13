package com.mfpe.alertime

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mfpe.alertime.adapters.AlarmAdapter
import com.mfpe.alertime.databinding.ActivityMainBinding
import com.mfpe.alertime.model.Alarm
import kotlin.random.Random

class MainActivity : AppCompatActivity(), AlarmAdapter.SelectionListener  {

    private lateinit var binding: ActivityMainBinding
    private lateinit var alarmAdapter: AlarmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSearchView()
        setupRecyclerView()

        binding.btnCreateAlarm.setOnClickListener {
            val intent = Intent(this, CreateAlarmActivity::class.java)
            startActivity(intent)
        }

        binding.btnFilter.setOnClickListener {
            val intent = Intent(this, SelectFilterActivity::class.java)
            startActivity(intent)
        }

        binding.btnDelete.setOnClickListener {
            showDeleteConfirmationDialog()
        }
    }

    private fun setupSearchView() {
        val linearLayout1 = binding.searchBar.getChildAt(0) as LinearLayout
        val linearLayout2 = linearLayout1.getChildAt(2) as LinearLayout
        val linearLayout3 = linearLayout2.getChildAt(1) as LinearLayout
        val autoComplete = linearLayout3.getChildAt(0) as AutoCompleteTextView
        autoComplete.textSize = 14f
    }

    private fun setupRecyclerView() {
        alarmAdapter = AlarmAdapter(generateRandomAlarms(), this)
        binding.recyclerAlarmas.layoutManager = LinearLayoutManager(this)
        binding.recyclerAlarmas.adapter = alarmAdapter
    }

    private fun generateRandomAlarms(): List<Alarm> {
        val alarms = mutableListOf<Alarm>()
        for (i in 1..4) {
            val name = "Alarma #$i"
            val subtitle = "Descripción de alarma #$i"
            val isEnabled = Random.nextBoolean()
            alarms.add(Alarm(i, name, subtitle, isEnabled))
        }
        return alarms
    }

    private fun showDeleteConfirmationDialog() {
        AlertDialog.Builder(this)
            .setTitle("Eliminar alarmas")
            .setMessage("¿Estás seguro que desea eliminar las alarmas seleccionadas?")
            .setPositiveButton("Eliminar") { dialog, _ ->
                alarmAdapter.clearSelection()
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }

    override fun onSelectionChanged(selectedCount: Int) {
        if (selectedCount > 0) {
            binding.btnCreateAlarm.hide()
            binding.btnDelete.visibility = View.VISIBLE
        } else {
            binding.btnCreateAlarm.show()
            binding.btnDelete.visibility = View.GONE
        }
    }

}