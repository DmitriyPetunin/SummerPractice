package ru.itis.summerpractice

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

import ru.itis.summerpractice.databinding.ItemSongDescriptionBinding

class SongDescriptionFragment : Fragment(R.layout.item_song_description) {
    private var binding: ItemSongDescriptionBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ItemSongDescriptionBinding.bind(view)
        val id = arguments?.getInt("ID")
        val song = SongRepo.songs.find { s -> s.id == id }
        binding?.run {
            song?.let {
                songTitle.text = song.name
                Log.d("check",songTitle.text.toString())
                songShortDescription.text = song.short_description
                songLongDescription.text = song.long_description
                view.let {
                    Glide.with(it)
                        .load(song.url)
                        .error(R.drawable.ic_launcher_foreground)
                        .placeholder(R.drawable.ic_music_note_24)
                        .into(songImage)
                }
            }
            backButton.setOnClickListener{
                findNavController().navigateUp()
            }
        }
    }



    private fun updateUi(song: Song) {
        with(binding!!) {
            songTitle.text = song.name
            Log.d("check",songTitle.text.toString())
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
        private const val SONG_ID = "ID"

        fun newInstance(songId: Int): Bundle {
            return Bundle().apply { putInt(SONG_ID,songId) }
        }
    }
}