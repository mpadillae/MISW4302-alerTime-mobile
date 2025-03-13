package com.mfpe.alertime

import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.mfpe.alertime.databinding.ActivitySelectLocationBinding
import org.osmdroid.config.Configuration.getInstance
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController


class SelectLocationActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectLocationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this))
        binding = ActivitySelectLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            finish()
        }

        binding.mapView.zoomController.setVisibility(CustomZoomButtonsController.Visibility.ALWAYS)
        binding.mapView.setMultiTouchControls(true)
        binding.mapView.controller.setZoom(18.0)
        val gPt = GeoPoint(-14.06777, -75.72861)
        binding.mapView.controller.setCenter(gPt)

    }
}