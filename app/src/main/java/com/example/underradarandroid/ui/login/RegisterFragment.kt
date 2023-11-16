package com.example.underradarandroid.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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

        configureSignUpButton()
        configureSpinner()
        configureAlreadySignedUpButton()
    }
    private fun showLoginFragment() {
        pager.currentItem = 0
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getProfileType(): Int {
        return binding.profileTypeSpinner.selectedItemPosition
    }

    private fun configureSpinner() {
        val spinner = binding.profileTypeSpinner
        val profileTypes = resources.getStringArray(R.array.profile_types)
        if (spinner != null) {
            context?.let {context ->
                val adapter = ArrayAdapter(
                    context,
                    androidx.transition.R.layout.support_simple_spinner_dropdown_item, profileTypes
                )
                spinner.adapter = adapter
            }
        }
    }

    private fun configureAlreadySignedUpButton() {
        val alreadySignedUpButton = binding.alreadySignedUpButton
        alreadySignedUpButton.setOnClickListener {
            showLoginFragment()
        }
    }

    private fun configureSignUpButton() {

        val usernameEditText = binding.username
        val firstName = binding.firstNameText
        val lastName = binding.lastNameText
        val passwordEditText = binding.password
        val confirmedPasswordEditText = binding.confirmedPassword
        val loginButton = binding.signinButton
        val loadingProgressBar = binding.loading
        val errorTextView = binding.errorTextView

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmedPasswordEditText.text.toString()
            val firstname = firstName.text.toString()
            val lastname = lastName.text.toString()

//            errorTextView.visibility = View.INVISIBLE
//            loadingProgressBar.visibility = View.VISIBLE

            if (username.isEmpty() ||
                password.isEmpty() ||
                firstname.isEmpty() ||
                lastname.isEmpty() ||
                confirmPassword != password) {
//                errorTextView.visibility = View.VISIBLE
//                loadingProgressBar.visibility = View.INVISIBLE
                return@setOnClickListener
            }
            AuthManager.createUser(username, password, firstname, lastname, getProfileType()) {
                successCompletion()
            }
        }
    }
}