package com.example.feature_buy

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment
import com.google.android.material.appbar.MaterialToolbar

class BuyScreenThirdFragment : BaseFragment(R.layout.fragment_buy_screen_third) {

    private lateinit var toolbar: MaterialToolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar)
        view.findViewById<Button>(R.id.complete_button).setOnClickListener {
            findNavController()
                .popBackStack(R.id.buyScreenFirstFragment, true)
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