package com.example.underradarandroid.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.underradarandroid.R
import com.example.underradarandroid.databinding.FragmentAuthManagerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AuthManagerFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAuthManagerBinding

    var pageObservable = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAuthManagerBinding.inflate(layoutInflater)
        binding.viewPager.adapter = AuthAdapter(this, binding.viewPager) {
            dismiss()
        }
        return binding.root
    }
    companion object {
        const val TAG = "ModalBottomSheetDialog"
    }
}

class AuthAdapter( fm: Fragment, private val pager: ViewPager2, private val successCompletion: () -> Unit) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> AuthFragment(pager, successCompletion)
            1 -> RegisterFragment(pager, successCompletion)
            else -> AuthFragment(pager, successCompletion)
        }
    }
}