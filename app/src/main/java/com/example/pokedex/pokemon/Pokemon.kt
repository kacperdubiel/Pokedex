package com.example.pokedex.pokemon

import com.google.gson.Gson

data class Pokemon(
        val id: Int,
        val pokedexId: String,
        val name: String,
        val elementTypes: ArrayList<ElementType>,
        val attacks: ArrayList<PokemonAttack>,
        val images: ArrayList<Int>,
        var favourite: Boolean
) {

    fun deepCopy(): Pokemon {
        val json = Gson().toJson(this)
        return Gson().fromJson(json, Pokemon::class.java)
    }
}
