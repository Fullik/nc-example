package com.example.feature_login

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class LoginResultDialogFragment : BottomSheetDialogFragment() {

    private val args: LoginResultDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_fragment_login_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.isLoginSucceded) {
            view.findViewById<TextView>(R.id.login_result_text_view).text = "Login succeeded!"
            view.findViewById<Button>(R.id.navigate_button).setOnClickListener {
                findNavController().popBackStack(R.id.loginFragment, true)
            }
        } else {
            view.findViewById<TextView>(R.id.login_result_text_view).text = "Login failed :("
            view.findViewById<Button>(R.id.navigate_button).run {
                text = "Retry"
                setOnClickListener {
                    findNavController().popBackStack()
                }
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (args.isLoginSucceded) {
            findNavController().popBackStack(R.id.loginFragment, true)
        }
    }
}