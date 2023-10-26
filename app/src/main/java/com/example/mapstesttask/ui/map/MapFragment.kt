package com.example.mapstesttask.ui.map

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import com.example.mapstesttask.R
import com.example.mapstesttask.data.network.NetworkResponse
import com.example.mapstesttask.databinding.FragmentMapBinding
import com.example.mapstesttask.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.Polyline

class MapFragment : Fragment(R.layout.fragment_map) {

    private val binding by viewBinding(FragmentMapBinding::bind)
    private val mapViewModel: MapViewModel by viewModel()

    private val startPosition = GeoPoint(50.4501, 30.5234)
    private val zoomMap = 13.0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapViewModel.getRoad()

        initMap()
        observeDirectionUpdate()
    }

    private fun observeDirectionUpdate() {
        mapViewModel.directionLD.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Success -> {
                    with(binding) {
                        val polyline = Polyline()
                        polyline.setPoints(it.data)
                        polyline.color = Color.RED
                        map.overlayManager.add(polyline)
                        map.invalidate()
                    }
                }

                is NetworkResponse.Failure -> {
                    Toast.makeText(requireContext(), it.throwable.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun initMap() {
        Configuration.getInstance()
            .load(requireContext(), getDefaultSharedPreferences(requireContext()))

        with(binding) {
            map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
            map.controller.setCenter(startPosition)
            map.controller.setZoom(zoomMap)
            map.setMultiTouchControls(true)
        }
    }
}
