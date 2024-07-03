package ru.itis.summerpractice

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

import ru.itis.summerpractice.databinding.ItemSongDescriptionBinding

class SongDescriptionFragment : Fragment(R.layout.item_song_description) {
    private var binding: ItemSongDescriptionBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ItemSongDescriptionBinding.bind(view)


        val songId = arguments?.getInt(SONG_ID) ?: return


        val song = SongRepo.songs.find { it.id == songId }
        song?.let { updateUi(it) }


        binding?.backButton?.setOnClickListener {
            requireActivity().onBackPressed()
        }



    }
    private fun updateUi(song: Song) {
        with(binding!!) {
            songTitle.text = song.name
            songShortDescription.text = song.short_description
            songLongDescription.text = song.long_description
            view?.let {
                Glide.with(it)
                    .load(song.url)
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_music_note_24)
                    .into(songImage)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    companion object {
        private const val SONG_ID = "song_id"

        fun newInstance(songId: Int): SongDescriptionFragment {
            return SongDescriptionFragment().apply {
                arguments = Bundle().apply {
                    putInt(SONG_ID, songId)
                }
            }
        }
    }
}