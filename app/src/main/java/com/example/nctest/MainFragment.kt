package com.example.nctest

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment

class MainFragment : BaseFragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.second_activity).setOnClickListener {
            findNavController().navigate(R.id.secondActivity)
        }
        view.findViewById<Button>(R.id.buy_button).setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.host_global)
                .navigate(R.id.action_global_buy_flow_navigation)
        }
    }
}