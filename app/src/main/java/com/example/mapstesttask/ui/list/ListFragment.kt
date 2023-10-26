package com.example.mapstesttask.ui.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mapstesttask.R
import com.example.mapstesttask.data.network.NetworkResponse
import com.example.mapstesttask.databinding.FragmentListBinding
import com.example.mapstesttask.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private val binding by viewBinding(FragmentListBinding::bind)
    private val viewModel: ListViewModel by viewModel()
    private var pointListAdapter: PointListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        observePointListUpdate()
    }

    private fun observePointListUpdate() {
        viewModel.pointList.observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResponse.Success -> {
                    pointListAdapter?.list?.submitList(it.data)
                }

                is NetworkResponse.Failure -> {
                    Toast.makeText(requireContext(), it.throwable.message, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun initAdapter() {
        pointListAdapter = PointListAdapter()
        binding.rvPointList.adapter = pointListAdapter
    }
}