package ru.itis.summerpractice

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import ru.itis.summerpractice.databinding.ItemSongBinding

class SongHolder(
    private val binding: ItemSongBinding,
    private val glide: RequestManager,
    private val onClick: (Song) -> Unit,
) : ViewHolder(binding.root) {
    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context get() = itemView.context

    fun onBind(song: Song) {
        binding.run {
            itemTitle.text = song.name
            itemGenre.text = song.genre
            Log.d("holder",itemGenre.text.toString())

            glide
                .load(song.url)
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .apply(requestOptions)
                .into(itemImage)

            root.setOnClickListener {
                onClick(song)
            }

            itemGenre.setTextColor(context.getColor(song.getTitleColor()))
        }
    }

    private fun Song.getTitleColor(): Int = if (url.length > 120) {
        R.color.purple_200
    } else {
        R.color.purple_700
    }
}