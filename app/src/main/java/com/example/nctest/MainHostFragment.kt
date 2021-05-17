package com.example.nctest

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.shared.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainHostFragment : BaseFragment(R.layout.fragment_main_host) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomView = view.findViewById<BottomNavigationView>(R.id.bottom_view)
        val host = childFragmentManager.findFragmentById(R.id.host_main) as NavHostFragment
        NavigationUI.setupWithNavController(bottomView, host.navController)
    }
}