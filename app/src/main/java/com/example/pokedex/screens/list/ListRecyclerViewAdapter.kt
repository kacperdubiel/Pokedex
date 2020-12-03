package com.example.pokedex.screens.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.pokemon.Pokemon
import kotlinx.android.synthetic.main.rv_item_pokemon.view.*

class ListRecyclerViewAdapter(
        private var actualPokemonList: ArrayList<Pokemon>,
        private var clickListener: OnListItemClickListener
) : RecyclerView.Adapter<ListRecyclerViewAdapter.ListRecycleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecycleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_item_pokemon, parent, false)

        return ListRecycleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListRecycleViewHolder, position: Int) {
        val currentItem = actualPokemonList[position]

        if (currentItem.images.size > 0)
            holder.pokemonIV.setImageResource(currentItem.images[0])
        else
            holder.pokemonIV.setImageResource(R.drawable.ic_launcher_background)

        holder.pokedexIdTV.text = currentItem.pokedexId
        holder.pokemonNameTV.text = currentItem.name

        if (currentItem.favourite)
            holder.favouriteIV.setImageResource(R.drawable.icon_red_heart)
        else
            holder.favouriteIV.setImageResource(R.drawable.icon_black_heart)

        if (currentItem.elementTypes.size > 0)
            holder.firstTypeIV.setImageResource(currentItem.elementTypes[0].image)
        else
            holder.firstTypeIV.setImageResource(R.drawable.ic_launcher_foreground)

        if (currentItem.elementTypes.size > 1)
            holder.secondTypeIV.setImageResource(currentItem.elementTypes[1].image)
        else
            holder.secondTypeIV.setImageResource(R.drawable.type_blank)

        holder.initialize(actualPokemonList[position], clickListener)
    }

    override fun getItemCount() = actualPokemonList.size

    fun updateToNewData(newData: ArrayList<Pokemon>) {
        actualPokemonList = ArrayList()
        notifyDataSetChanged()
        for (pokemon in newData) {
            actualPokemonList.add(pokemon)
            notifyItemInserted(itemCount - 1)
        }
    }

    class ListRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pokemonIV: ImageView = itemView.pokemonIV
        val pokedexIdTV: TextView = itemView.pokedexIdTV
        val pokemonNameTV: TextView = itemView.pokemonNameTV
        val favouriteIV: ImageView = itemView.favouriteIV
        val firstTypeIV: ImageView = itemView.firstTypeIV
        val secondTypeIV: ImageView = itemView.secondTypeIV

        fun initialize(item: Pokemon, action: OnListItemClickListener) {
            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }

            favouriteIV.setOnClickListener {
                action.onFavouriteClick(item, adapterPosition)
            }
        }
    }
}

interface OnListItemClickListener {
    fun onItemClick(item: Pokemon, position: Int)
    fun onFavouriteClick(item: Pokemon, position: Int)
}