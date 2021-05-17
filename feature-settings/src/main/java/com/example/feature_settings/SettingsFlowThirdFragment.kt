package com.example.feature_settings

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.shared.BaseFragment
import com.google.android.material.appbar.MaterialToolbar

class SettingsFlowThirdFragment : BaseFragment(R.layout.fragment_settings_flow_third) {

    private lateinit var toolbar: MaterialToolbar
    private val args: SettingsFlowThirdFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.settings_id_tv).text = args.settingsName
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