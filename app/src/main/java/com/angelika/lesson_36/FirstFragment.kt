package com.angelika.lesson_36

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.angelika.lesson_36.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var initialCount = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        plusClick()
        minusClick()

        savedInstanceState?.let {
            initialCount = it.getInt("count", 0)
            binding.tvNumbers.text = initialCount.toString()
        }
    }

    private fun plusClick() = with(binding) {
        btnPlus.setOnClickListener {
            if (initialCount < 10) {
                initialCount++
                tvNumbers.text = initialCount.toString()
            } else {
                parentFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, SecondFragment())
                    .addToBackStack("First Fragment")
                    .commit()
            }
        }
    }

    private fun minusClick() = with(binding) {
        btnMinus.setOnClickListener {
            if (initialCount > 0) {
                initialCount--
                tvNumbers.text = initialCount.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", initialCount)
    }
}