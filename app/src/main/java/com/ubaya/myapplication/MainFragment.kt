package com.ubaya.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ubaya.myapplication.databinding.FragmentMainBinding
import kotlin.random.Random


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    var score = 0
    var answer =0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(
            inflater,
            container, false
        )
        return binding.root

    }
    fun updateQuestion() {
        var number1 = Random.nextInt(1,69)
        var number2 = Random.nextInt(1,69)
        answer = number1 + number2
        var question = number1.toString()+" + "+number2.toString()
        binding.txtQuestion.setText(question)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        score = 0
        updateQuestion()
        binding.btnStart.setOnClickListener {
            val playerName = binding.txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(playerName)
            Navigation.findNavController(it).navigate(action)
        }
        binding.btnAnswer.setOnClickListener {
            if (binding.txtAnswer.text.toString()==answer.toString()){
                score++
                updateQuestion()
            } else {
                val action = MainFragmentDirections.actionResultFragment(score.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }

    }
}