package com.example.dictionary.ui

import android.animation.Animator
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.dictionary.databinding.FragmentSplashScreenBinding
import com.example.dictionary.utils.BaseFragment

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : BaseFragment<FragmentSplashScreenBinding>(FragmentSplashScreenBinding::inflate) {
    override fun startCreating(inflater: LayoutInflater, container: ViewGroup?) {
        binding.animationView.playAnimation()
        binding.animationView.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {

            }
            override fun onAnimationEnd(animation: Animator?) {
                val action = SplashScreenFragmentDirections.actionSplashScreenFragmentToWelcomeScreenFragment()
                findNavController().navigate(action)
            }
            override fun onAnimationStart(animation: Animator?) {

            }
            override fun onAnimationCancel(animation: Animator?) {

            }
        })
    }

}