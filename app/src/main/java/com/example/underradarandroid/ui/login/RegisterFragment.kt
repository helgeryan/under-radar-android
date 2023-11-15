package com.example.underradarandroid.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.underradarandroid.R
import com.example.underradarandroid.Resources.AuthManager.AuthManager
import com.example.underradarandroid.databinding.FragmentAuthBinding
import com.example.underradarandroid.databinding.FragmentRegisterBinding

class RegisterFragment(private val pager: ViewPager2, private val successCompletion: () -> Unit) : Fragment() {
    private var _binding: FragmentRegisterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText = binding.username
        val firstName = binding.firstNameText
        val lastName = binding.lastNameText
        val passwordEditText = binding.password
        val loginButton = binding.login
        val loadingProgressBar = binding.loading
        val errorTextView = binding.errorTextView
        val alreadySignedUpButton = binding.alreadySignedUpButton

        loginButton.setOnClickListener {
            errorTextView.visibility = View.GONE
            loadingProgressBar.visibility = View.VISIBLE
            AuthManager.createUser(usernameEditText.text.toString(), passwordEditText.text.toString(), firstName.text.toString(), lastName.text.toString(), 1) {
                successCompletion()
            }
        }


        alreadySignedUpButton.setOnClickListener {
            showLoginFragment()
        }
    }
    private fun showLoginFragment() {
        pager.currentItem = 0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}