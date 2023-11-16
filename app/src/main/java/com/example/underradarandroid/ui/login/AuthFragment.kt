package com.example.underradarandroid.ui.login

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.underradarandroid.Resources.AuthManager.AuthManager
import com.example.underradarandroid.databinding.FragmentAuthBinding

class AuthFragment(private val pager: ViewPager2, private val successCompletion: () -> Unit) : Fragment() {
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
        val errorTextView = binding.errorTextView
        val signUpButton = binding.newUserButton

        loginButton.setOnClickListener {

            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            errorTextView.visibility = View.GONE
            loadingProgressBar.visibility = View.VISIBLE

            if (username.isEmpty() ||
                password.isEmpty()) {
                errorTextView.visibility = View.VISIBLE
                loadingProgressBar.visibility = View.GONE
                return@setOnClickListener
            }

            AuthManager.login(usernameEditText.text.toString(), passwordEditText.text.toString()) { success ->
                loadingProgressBar.visibility = View.INVISIBLE
                if (success) {
                    successCompletion()
                } else {
                    errorTextView.visibility = View.VISIBLE
                }
            }
        }


        signUpButton.setOnClickListener {
            showRegisterFragment()
        }
    }
    private fun showRegisterFragment() {
        pager.currentItem = 1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}