package com.example.feature_login

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.shared.BaseFragment

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.login_success_button).setOnClickListener {
            findNavController().previousBackStackEntry?.savedStateHandle?.set(LOGIN_SUCCESS, true)
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToLoginResultDialogFragment()
                    .setIsLoginSucceded(true)
            )
        }
        view.findViewById<Button>(R.id.login_failed_button).setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToLoginResultDialogFragment()
                    .setIsLoginSucceded(false)
            )
        }
    }

    companion object {
        const val LOGIN_SUCCESS = "LOGIN_SUCCESS"
    }
}