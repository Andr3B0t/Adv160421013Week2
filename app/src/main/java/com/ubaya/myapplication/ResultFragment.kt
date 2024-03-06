package com.ubaya.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.myapplication.databinding.FragmentGameBinding
import com.ubaya.myapplication.databinding.FragmentMainBinding
import com.ubaya.myapplication.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding:FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val score =
                ResultFragmentArgs.fromBundle(requireArguments()).score
            binding.txtScore.text = "Your score is $score"
        }


        binding.btnBackMain.setOnClickListener {
            val action = ResultFragmentDirections.actionResultFragmentToMainFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}