package com.example.pokedex.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.pokemon.Pokemon
import kotlinx.android.synthetic.main.fragment_attacks_screen.view.*

class AttacksScreen(val pokemon: Pokemon) : Fragment() {

    private lateinit var attackRVAdapter: AttackRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_attacks_screen, container, false)

        attackRVAdapter = AttackRecyclerViewAdapter(pokemon.attacks)
        view.pokemonAttackListRV.adapter = attackRVAdapter
        view.pokemonAttackListRV.layoutManager = LinearLayoutManager(this.context)
        view.pokemonAttackListRV.setHasFixedSize(true)

        return view
    }

}