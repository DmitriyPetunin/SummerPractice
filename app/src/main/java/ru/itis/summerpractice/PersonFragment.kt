package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice.databinding.FragmentPersonBinding

class PersonFragment : Fragment(R.layout.fragment_person) {

    private var binding: FragmentPersonBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPersonBinding.bind(view)

        binding?.run {
            sendButton.setOnClickListener {
                val text = etPassword.text.toString()
                if (text.isEmpty()) {
                    Snackbar.make(view, "password is empty", Snackbar.LENGTH_LONG).setAnchorView(R.id.bottomNavigation).show()
                } else {
                    findNavController().navigate(R.id.action_personFragment_to_emptyFragment,EmptyFragment.bundle(text))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}