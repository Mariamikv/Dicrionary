package com.example.dictionary.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dictionary.databinding.FragmentWelcomeScreenBinding
import com.example.dictionary.utils.BaseFragment

class WelcomeScreenFragment : BaseFragment<FragmentWelcomeScreenBinding>(FragmentWelcomeScreenBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        init()
    }

    private fun init(){

        //add how to disable back pressed button in navigation fragment

        with(binding){
            getStartedBtn.setOnClickListener {
                val action = WelcomeScreenFragmentDirections.actionWelcomeScreenFragmentToSearchScreenFragment()
                findNavController().navigate(action)
            }
        }
    }
}