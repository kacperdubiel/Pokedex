package com.example.pokedex.data

import com.example.pokedex.R
import com.example.pokedex.pokemon.ElementType
import com.example.pokedex.pokemon.Pokemon
import com.example.pokedex.pokemon.PokemonAttack


class Data {
    companion object {
        val elementTypes: ArrayList<ElementType> = arrayListOf(
                ElementType(0, "Normal", R.drawable.type_normal),
                ElementType(1, "Fire", R.drawable.type_fire),
                ElementType(2, "Water", R.drawable.type_water),
                ElementType(3, "Electric", R.drawable.type_electric),
                ElementType(4, "Grass", R.drawable.type_grass),
                ElementType(5, "Ice", R.drawable.type_ice),
                ElementType(6, "Fighting", R.drawable.type_fighting),
                ElementType(7, "Poison", R.drawable.type_poison),
                ElementType(8, "Ground", R.drawable.type_ground),
                ElementType(9, "Flying", R.drawable.type_flying),
                ElementType(10, "Psychic", R.drawable.type_psychic),
                ElementType(11, "Bug", R.drawable.type_bug),
                ElementType(12, "Rock", R.drawable.type_rock),
                ElementType(13, "Ghost", R.drawable.type_ghost),
                ElementType(14, "Dragon", R.drawable.type_dragon),
                ElementType(15, "Steel", R.drawable.type_steel),
                ElementType(16, "Dark", R.drawable.type_dark),
                ElementType(17, "Fairy", R.drawable.type_fairy)
        )

        private val pokemonAttacks: ArrayList<PokemonAttack> = arrayListOf(
                PokemonAttack(0, "Tackle", elementTypes[0], 1, 35, 95, 35),
                PokemonAttack(1, "Growl", elementTypes[0], 1, 0, 100, 40),
                PokemonAttack(2, "Leech Seed", elementTypes[4], 7, 0, 90, 10),
                PokemonAttack(3, "Vine Whip", elementTypes[4], 13, 35, 100, 10),
                PokemonAttack(4, "Poison Powder", elementTypes[7], 20, 0, 75, 35),
                PokemonAttack(5, "Scratch", elementTypes[0], 1, 40, 100, 35),
                PokemonAttack(6, "Ember", elementTypes[1], 9, 40, 100, 25),
                PokemonAttack(7, "Leer", elementTypes[0], 15, 0, 100, 30),
                PokemonAttack(8, "Rage", elementTypes[0], 22, 20, 100, 20),
                PokemonAttack(9, "Tail whip", elementTypes[0], 1, 0, 100, 30),
                PokemonAttack(10, "Bubble", elementTypes[2], 8, 20, 100, 30),
                PokemonAttack(11, "Water Gun", elementTypes[2], 15, 40, 100, 25),
        )

        val pokemons: ArrayList<Pokemon> = arrayListOf(
                Pokemon(
                        0,
                        "#001",
                        "Bulbasaur",
                        elementTypes = arrayListOf(
                                elementTypes[1],
                                elementTypes[7]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[1],
                                pokemonAttacks[2],
                                pokemonAttacks[3],
                                pokemonAttacks[4],
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_bulbasaur_1,
                                R.drawable.pokemon_bulbasaur_2,
                                R.drawable.pokemon_bulbasaur_3
                        ),
                        false
                ),
                Pokemon(
                        1,
                        "#004",
                        "Charmander",
                        elementTypes = arrayListOf(
                                elementTypes[1]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[5],
                                pokemonAttacks[1],
                                pokemonAttacks[6],
                                pokemonAttacks[7],
                                pokemonAttacks[8],
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_charmander_1,
                                R.drawable.pokemon_charmander_2
                        ),
                        false
                ),
                Pokemon(
                        2,
                        "#007",
                        "Squirtle",
                        elementTypes = arrayListOf(
                                elementTypes[2]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[9],
                                pokemonAttacks[10],
                                pokemonAttacks[11],
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_squirtle_1,
                                R.drawable.pokemon_squirtle_2,
                                R.drawable.pokemon_squirtle_3,
                                R.drawable.pokemon_squirtle_4
                        ),
                        false
                )
        )


    }
}