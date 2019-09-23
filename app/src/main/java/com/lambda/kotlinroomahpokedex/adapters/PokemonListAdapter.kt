package com.lambda.kotlinroomahpokedex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.lambda.kotlinroomahpokedex.R
import com.lambda.kotlinroomahpokedex.models.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_content.view.*
import java.util.*

class PokemonListAdapter :
    androidx.recyclerview.widget.ListAdapter<Pokemon, PokemonListAdapter.PokemonHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Pokemon>() {
            override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.name == newItem.name &&
                        oldItem.number == newItem.number &&
                        oldItem.imageUrl == newItem.imageUrl
            }
        }
    }

    private var listener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_content, parent, false)
        return PokemonHolder(itemView)
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val currentPokemon: Pokemon = getItem(position)
        holder.tvName.text = currentPokemon.name
        holder.tvNum.text = currentPokemon.number.toString()

    }


    fun getPokemonAt(position: Int): Pokemon {
        return getItem(position)
    }

    inner class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName = itemView.tv_pokemon_name
        var tvNum = itemView.tv_pokemon_num
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener?.onItemClick(getItem(position))
                }
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(itinerary: Pokemon)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }
}