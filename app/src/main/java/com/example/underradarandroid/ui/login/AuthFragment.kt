package com.example.underradarandroid.ui.login

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.underradarandroid.Resources.AuthManager.AuthManager
import com.example.underradarandroid.databinding.FragmentAuthBinding

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AuthFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentAuthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.login
        val loadingProgressBar = binding.loading

        loginButton.setOnClickListener {
            loadingProgressBar.visibility = View.VISIBLE
            AuthManager.login(usernameEditText.text.toString(), passwordEditText.text.toString()) { success ->
                if (success) {
                    dismiss()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "ModalBottomSheetDialog"
    }
}