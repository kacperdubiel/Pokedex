package com.example.pokedex.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedex.R
import com.example.pokedex.pokemon.Pokemon
import kotlinx.android.synthetic.main.fragment_info_screen.view.*

class InfoScreen(val pokemon: Pokemon) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_info_screen, container, false)

        view.pokemonInfoIV.setImageResource(pokemon.images[0])
        view.pokedexIdInfoTV.text = pokemon.pokedexId
        view.pokemonNameInfoTV.text = pokemon.name
        view.firstTypeInfoIV.setImageResource(pokemon.elementTypes[0].image)
        if (pokemon.elementTypes.size > 1)
            view.secondTypeInfoIV.setImageResource(pokemon.elementTypes[1].image)
        else
            view.secondTypeInfoIV.setImageDrawable(null)

        return view
    }

}