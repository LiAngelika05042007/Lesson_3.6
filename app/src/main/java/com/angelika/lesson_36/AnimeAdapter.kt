package com.angelika.lesson_36

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelika.lesson_36.databinding.ItemAnimeBinding

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var anime = emptyList<Anime>()

    fun setData(anime: List<Anime>) {
        this.anime = anime
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(anime: Anime) = with(binding) {
            animePicture.setImageResource(anime.picture)
            tvName.text = anime.name
            tvPlot.text = anime.plot
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val item = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(item)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(anime[position])
    }

    override fun getItemCount(): Int {
        return anime.size
    }
}