package com.example.feature_settings

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment

class SettingsFlowFirstFragment : BaseFragment(R.layout.fragment_settings_flow_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.next_step_button).setOnClickListener {
            findNavController().navigate(
                    SettingsFlowFirstFragmentDirections.actionSettingsFlowFirstFragmentToSettingsFlowSecondFragment()
            )
        }
    }
}