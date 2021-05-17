package com.example.feature_frw

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.shared.BaseFragment

class FrwThirdStepFragment : BaseFragment(R.layout.fragment_frw_third_step) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val prefs = PrefsHolder.holder
        prefs.setFrwStage(2)
        val isStartFrw = arguments?.getBoolean(FrwRootFragment.ARG_IS_START_FRW) ?: false
        val navOptions = if (isStartFrw) {
            navOptions {
                popUpTo(R.id.frwThirdStepFragment) {
                    inclusive = true
                }
            }
        } else {
            navOptions {
                popUpTo(R.id.frwFirstStepFragment) {
                    inclusive = true
                }
            }
        }
        view.findViewById<Button>(R.id.complete_frw_button).setOnClickListener {
            prefs.setFrwCompleted(true)
            findNavController().navigate(
                    FrwThirdStepFragmentDirections.actionFrwThirdStepFragmentToFrwCompleteFragment()
                            .setIsStartFrw(isStartFrw),
                    navOptions
            )
        }
    }
}