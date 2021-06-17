package com.example.nctest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.feature_frw.FrwRootFragment
import com.example.feature_frw.PrefsHolder

class MainActivity : AppCompatActivity() {

    private val destinationChangedListener =
        NavController.OnDestinationChangedListener { controller, destination, _ ->
            val intentWithDeeplink = DeeplinkIntentHolder.intentWithDeeplink
            if (destination.id == R.id.mainHostFragment && intentWithDeeplink != null) {
                intent = intentWithDeeplink
                DeeplinkIntentHolder.intentWithDeeplink = null
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            changeNavGraph()
        }
    }

    override fun onStart() {
        super.onStart()
        findNavController(R.id.host_global).addOnDestinationChangedListener(destinationChangedListener)
    }

    override fun onStop() {
        findNavController(R.id.host_global).removeOnDestinationChangedListener(destinationChangedListener)
        super.onStop()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeNavGraph() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.host_global) as NavHostFragment
        val navController = navHostFragment.navController
        val inflater = navController.navInflater
        val graph = inflater.inflate(R.navigation.global_graph)
        val startBundle: Bundle?
        if (PrefsHolder.holder.isFrwCompleted()) {
            graph.startDestination = R.id.mainHostFragment
            startBundle = null
        } else {
            DeeplinkIntentHolder.intentWithDeeplink = Intent(intent).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            intent?.data = null
            graph.startDestination = R.id.frwRootFragment
            startBundle = FrwRootFragment.getArgs(true)
        }
        navController.setGraph(graph, startBundle)
    }

}