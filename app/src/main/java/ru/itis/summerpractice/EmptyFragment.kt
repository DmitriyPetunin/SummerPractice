package ru.itis.summerpractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.summerpractice.databinding.FragmentEmptyBinding

class EmptyFragment : Fragment(R.layout.fragment_empty) {
    private var binding: FragmentEmptyBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEmptyBinding.bind(view)

        val password = arguments?.getString(ARG_PASS) ?: "ERROR"

        binding?.successTextView?.text = password
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private const val ARG_PASS = "ARG_PASS"

        fun bundle(password: String): Bundle = Bundle().apply {
            putString(ARG_PASS,password)
        }
    }
}