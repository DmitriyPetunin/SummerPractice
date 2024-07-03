package ru.itis.summerpractice.otherfragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.itis.summerpractice.R
import ru.itis.summerpractice.databinding.FragmentBookBinding

class BookFragment : Fragment(R.layout.fragment_book) {
    private var binding: FragmentBookBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBookBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}