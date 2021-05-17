package com.example.feature_frw

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment

class FrwCompleteFragment : BaseFragment(R.layout.fragment_frw_complete) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments?.getBoolean(FrwRootFragment.ARG_IS_START_FRW) == true) {
            view.findViewById<Button>(R.id.complete_frw_button).apply {
                visibility = View.VISIBLE
                setOnClickListener {
                    Navigation.findNavController(requireActivity(), R.id.host_global)
                        .navigate(R.id.action_frwCompleteFragment_to_mainFragment)
                }
            }
        }
        view.findViewById<Button>(R.id.reset_frw_button).setOnClickListener {
            PrefsHolder.holder.run {
                setFrwCompleted(false)
                setFrwStage(0)
            }

            findNavController().navigate(
                    FrwCompleteFragmentDirections.actionFrwCompleteFragmentToFrwFirstStepFragment()
                            .setIsStartFrw(arguments?.getBoolean(FrwRootFragment.ARG_IS_START_FRW) ?: false)
            )
        }
    }
}