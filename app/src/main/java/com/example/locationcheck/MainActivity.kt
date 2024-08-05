package com.example.locationapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.locationcheck.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class MainActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var permissionStatus: TextView
    private lateinit var permissionStatusState: TextView
    private lateinit var latitude: TextView
    private lateinit var longitude: TextView
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        permissionStatus = findViewById(R.id.permissionStatus)
        permissionStatusState = findViewById(R.id.permissionStatusState)
        latitude = findViewById(R.id.latitude)
        longitude = findViewById(R.id.longitude)
        startButton = findViewById(R.id.startButton)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        checkLocationPermission()

        startButton.setOnClickListener {
            if (checkLocationPermission()) {
                getLastKnownLocation()
            }
        }
    }

    private fun checkLocationPermission(): Boolean {
        return if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )
            false
        } else {
            true
        }
    }

    private fun permissionGranted() {
        permissionStatusState.text = "Granted"
        permissionStatusState.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
    }

    @SuppressLint("MissingPermission")
    private fun getLastKnownLocation() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            location?.let {
                latitude.text = "Lat: ${it.latitude}"
                longitude.text = "Lng: ${it.longitude}"
                permissionGranted()
                startButton.backgroundTintList = ContextCompat.getColorStateList(this, android.R.color.darker_gray)
                startButton.isEnabled = false
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                permissionGranted()
            }
        }
    }

    companion object {
        private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1
    }
}
