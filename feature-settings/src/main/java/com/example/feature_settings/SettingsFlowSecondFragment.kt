package com.example.feature_settings

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment
import com.google.android.material.appbar.MaterialToolbar
import java.util.*

class SettingsFlowSecondFragment : BaseFragment(R.layout.fragment_settings_flow_second) {

    private lateinit var toolbar: MaterialToolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.next_step_button).setOnClickListener {
            findNavController().navigate(
                    SettingsFlowSecondFragmentDirections
                            .actionSettingsFlowSecondFragmentToSettingsFlowThirdFragment()
                            .setSettingsName(UUID.randomUUID().toString())
            )
        }
        view.findViewById<Button>(R.id.buy_button).setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.host_global)
                .navigate(R.id.action_global_buy_flow_navigation)
        }
        toolbar = view.findViewById(R.id.toolbar)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        with(requireActivity() as AppCompatActivity) {
            setSupportActionBar(toolbar)
            supportActionBar?.title = ""
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }
}