package ru.itis.summerpractice

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import ru.itis.summerpractice.databinding.ItemSongBinding


class SongAdapter(
    private var list: List<Song>,
    private val glide: RequestManager,
    private val onClick: (Song) -> Unit
): RecyclerView.Adapter<SongHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SongHolder = SongHolder(
        binding = ItemSongBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )
    override fun onBindViewHolder(holder: SongHolder, position: Int) {
        val song = list[position]
        holder.onBind(song)
        Log.d("->->",song.toString())

//        val fragment = SongDescriptionFragment.newInstance(song.id)
//        requireActivity().supportFragmentManager.beginTransaction()
//            .replace(R.id.musicFragment, fragment)
//            .addToBackStack(null)
//            .commit()
    }

    override fun getItemCount(): Int = list.size

}