package com.example.feature_frw

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.shared.BaseFragment

class FrwRootFragment : BaseFragment(R.layout.fragment_frw_root) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_frw_root, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val inflater = hostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.frw_graph)
        val prefs = PrefsHolder.holder
        val isFrwComplete = prefs.isFrwCompleted()
        val frwStage = prefs.frwStage()
        if (isFrwComplete) {
            graph.startDestination = R.id.frwCompleteFragment
            hostFragment.navController.graph = graph
        } else {

            if (arguments?.getBoolean(ARG_IS_START_FRW) == false) {
                graph.startDestination = R.id.frwFirstStepFragment
                hostFragment.navController.setGraph(graph, arguments)
                when (frwStage) {
                    1 -> hostFragment.navController.navigate(R.id.frwSecondStepFragment)
                    2 -> {
                        hostFragment.navController.navigate(R.id.frwSecondStepFragment)
                        hostFragment.navController.navigate(R.id.frwThirdStepFragment)
                    }
                }
            } else {
                graph.startDestination = when (frwStage) {
                    0 -> R.id.frwFirstStepFragment
                    1 -> R.id.frwSecondStepFragment
                    2 -> R.id.frwThirdStepFragment
                    else -> R.id.frwFirstStepFragment
                }
                hostFragment.navController.setGraph(graph, arguments)
            }
        }
    }

    companion object {
        const val ARG_IS_START_FRW = "is_start_frw"

        fun getArgs(isStartFrw: Boolean) = Bundle().apply {
            putBoolean(ARG_IS_START_FRW, isStartFrw)
        }
    }
}