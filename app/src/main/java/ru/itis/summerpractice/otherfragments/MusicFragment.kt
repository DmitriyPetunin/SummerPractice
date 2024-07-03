package ru.itis.summerpractice.otherfragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import ru.itis.summerpractice.R
import ru.itis.summerpractice.SongAdapter
import ru.itis.summerpractice.SongDescriptionFragment
import ru.itis.summerpractice.SongRepo
import ru.itis.summerpractice.databinding.FragmentMusicBinding

class MusicFragment : Fragment(R.layout.fragment_music) {
    private var binding: FragmentMusicBinding? = null

    private var adapter: SongAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)
        initAdapter()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        binding?.run {
            adapter = SongAdapter(
                list = SongRepo.songs,
                glide = Glide.with(this@MusicFragment),
                onClick = { song ->
                    val fragment = SongDescriptionFragment.newInstance(song.id)
                    //findNavController().navigate(R.id.action_musicFragment_to_songDescriptionFragment,fragment)
                }
            )

            tvSong.adapter = adapter

//          по-умолчанию линерлайоутманагер строит вертикальный список
            tvSong.layoutManager = LinearLayoutManager(requireContext())
//            tvSong.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//            tvSong.layoutManager = GridLayoutManager(requireContext(), 2)

//            tvTitle.setOnClickListener {
//                adapter?.updateDataset(SongRepo.citiesNew)
//            }
        }
    }
}