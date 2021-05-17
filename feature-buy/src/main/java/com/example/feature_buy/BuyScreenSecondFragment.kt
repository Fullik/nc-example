package com.example.feature_buy

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment
import com.google.android.material.appbar.MaterialToolbar

class BuyScreenSecondFragment : BaseFragment(R.layout.fragment_buy_screen_second) {

    private lateinit var toolbar: MaterialToolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        view.findViewById<Button>(R.id.next_button).setOnClickListener {
            findNavController()
                .navigate(R.id.action_buyScreenSecondFragment_to_buyScreenThirdFragment)
        }
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