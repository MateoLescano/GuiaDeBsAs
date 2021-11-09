package com.citesoftware.guiadebsas.ui.home

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.citesoftware.guiadebsas.MainActivity
import com.citesoftware.guiadebsas.R
import com.citesoftware.guiadebsas.databinding.FragmentHomeBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class HomeFragment : Fragment() {

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var lastLocation: Location


    @SuppressLint("MissingPermission")
    private val callback = OnMapReadyCallback { googleMap ->

        setUpMap()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext())

        googleMap.uiSettings.isMyLocationButtonEnabled = true
        googleMap.uiSettings.isRotateGesturesEnabled = true
        googleMap.uiSettings.isCompassEnabled = true

        val locDefault = LatLng(-34.608416, -58.372251)

        val checkPermisos = context?.checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)

        if(checkPermisos == PackageManager.PERMISSION_GRANTED){

            googleMap.isMyLocationEnabled = true

            fusedLocationClient.lastLocation.addOnSuccessListener(requireActivity()) { location ->

                if (location != null) {
                    lastLocation = location
                    val currentLatLng = LatLng(location.latitude, location.longitude)
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 14f))
                }
            }
        }else{
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locDefault, 13.0f))
        }

        //Marcadores de Locaciones
        val casa = googleMap.addMarker(MarkerOptions().position(LatLng(-34.575801, -58.463913)).title("Casa"))
        val laMezzeta = googleMap.addMarker(MarkerOptions().position(LatLng( -34.5781574,  -58.4608209)).title("Pizzería La Mezzetta"))


        googleMap.setOnInfoWindowClickListener {
            when (it) {
                casa -> {
                    Toast.makeText(context, "Mi casa", Toast.LENGTH_SHORT).show()
                }
                laMezzeta -> {
                    Toast.makeText(context, "La mejor pizza", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
    }





}