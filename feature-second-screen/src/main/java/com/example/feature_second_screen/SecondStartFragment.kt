package com.example.feature_second_screen

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment

class SecondStartFragment : BaseFragment(R.layout.fragment_start_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.profile_button).setOnClickListener {
            findNavController().navigate(
                SecondStartFragmentDirections.actionSecondStartFragmentToProfileGraph()
            )
        }
    }
}