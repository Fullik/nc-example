package com.example.nctest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import com.example.feature_frw.FrwRootFragment
import com.example.feature_frw.PrefsHolder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            changeNavGraph()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeNavGraph() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host_global) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.global_graph)
        val startBundle: Bundle?
        if (PrefsHolder.holder.isFrwCompleted()) {
            graph.startDestination = R.id.mainHostFragment
            startBundle = null
        } else {
            graph.startDestination = R.id.frwRootFragment
            startBundle = FrwRootFragment.getArgs(true)
        }
        navHostFragment.navController.setGraph(graph, startBundle)
    }

}