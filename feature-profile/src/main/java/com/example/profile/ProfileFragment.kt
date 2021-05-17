package com.example.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.feature_login.LoginFragment
import com.example.shared.BaseFragment

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

    private var isLoginCalled = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isLoginCalled) {
            findNavController().navigate(ProfileFragmentDirections.actionLoginFlow())
            isLoginCalled = true
        } else {
            val login = findNavController().currentBackStackEntry?.savedStateHandle
                ?.get<Boolean>(LoginFragment.LOGIN_SUCCESS)
            if (login == null) {
                findNavController().popBackStack()
            }
        }
    }
}