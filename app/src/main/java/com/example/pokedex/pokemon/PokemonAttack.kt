package com.example.pokedex.pokemon

data class PokemonAttack(
        val id: Int,
        val name: String,
        val elementType: ElementType,
        val levelNeeded: Int,
        val power: Int,
        val accuracy: Int,
        val pp: Int
)