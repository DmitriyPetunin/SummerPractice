package ru.itis.summerpractice

import android.view.LayoutInflater
import android.view.ViewGroup
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
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateDataset(newList: List<Song>) {
        list = newList
        notifyDataSetChanged()
    }
}