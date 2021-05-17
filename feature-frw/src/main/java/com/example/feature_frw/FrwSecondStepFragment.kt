package com.example.feature_frw

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import com.example.shared.BaseFragment

class FrwSecondStepFragment : BaseFragment(R.layout.fragment_frw_second_step) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        PrefsHolder.holder.setFrwStage(1)
        val isStartFrw = arguments?.getBoolean(FrwRootFragment.ARG_IS_START_FRW) ?: false
        val navOptions = if (isStartFrw) {
            navOptions {
                popUpTo(R.id.frwSecondStepFragment) {
                    inclusive = true
                }
            }
        } else {
            null
        }
        view.findViewById<Button>(R.id.next_button).setOnClickListener {
            val controller = Navigation.findNavController(view)
            controller.navigate(
                    FrwSecondStepFragmentDirections.actionFrwSecondStepFragmentToFrwThirdStepFragment()
                            .setIsStartFrw(isStartFrw),
                    navOptions
            )
        }
    }
}