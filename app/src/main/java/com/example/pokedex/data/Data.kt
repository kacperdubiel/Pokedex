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
                PokemonAttack(12, "Gust", elementTypes[0], 1, 40, 100, 35),
                PokemonAttack(13, "Wing attack", elementTypes[9], 28, 35, 100, 35),
                PokemonAttack(14, "Agility", elementTypes[10], 36, 0, 0, 20),
                PokemonAttack(15, "ThunderShock", elementTypes[3], 1, 40, 100, 30),
                PokemonAttack(16, "Thunder Wave", elementTypes[3], 8, 0, 100, 20),
                PokemonAttack(17, "Quick attack", elementTypes[0], 11, 40, 100, 30),
                PokemonAttack(18, "Thunderbolt", elementTypes[3], 26, 95, 100, 15),
                PokemonAttack(19, "Leech Life", elementTypes[11], 1, 20, 100, 15),
                PokemonAttack(20, "Supersonic", elementTypes[0], 10, 0, 55, 20),
                PokemonAttack(21, "Bite", elementTypes[0], 15, 60, 100, 25),
                PokemonAttack(22, "Confuse Ray", elementTypes[13], 21, 0, 100, 10),
                PokemonAttack(23, "Haze", elementTypes[5], 36, 0, 0, 30),
                PokemonAttack(24, "Defense Curl", elementTypes[0], 11, 0, 0, 40),
                PokemonAttack(25, "Rock Throw", elementTypes[12], 16, 50, 65, 15),
                PokemonAttack(26, "Earthquake", elementTypes[8], 31, 100, 100, 10),
                PokemonAttack(27, "Explosion", elementTypes[0], 36, 170, 100, 5),
                PokemonAttack(28, "Amnesia", elementTypes[10], 40, 0, 0, 20),
                PokemonAttack(29, "Swift", elementTypes[0], 41, 60, 0, 20),
                PokemonAttack(30, "Lick", elementTypes[13], 1, 20, 100, 30),
                PokemonAttack(31, "Night Shade", elementTypes[13], 1, 0, 100, 15),
                PokemonAttack(32, "Hypnosis", elementTypes[10], 29, 0, 60, 20),
                PokemonAttack(33, "Dream Eater", elementTypes[10], 38, 100, 100, 15),
                PokemonAttack(34, "Ice Punch", elementTypes[5], 31, 75, 100, 15),
                PokemonAttack(35, "Body Slam", elementTypes[0], 39, 85, 100, 15),
                PokemonAttack(36, "Blizzard", elementTypes[5], 58, 120, 90, 5),
        )

        val pokemons: ArrayList<Pokemon> = arrayListOf(
                Pokemon(
                        0,
                        "#001",
                        "Bulbasaur",
                        elementTypes = arrayListOf(
                                elementTypes[4],
                                elementTypes[7]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[1],
                                pokemonAttacks[2],
                                pokemonAttacks[3],
                                pokemonAttacks[4]
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
                                pokemonAttacks[8]
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
                                pokemonAttacks[11]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_squirtle_1,
                                R.drawable.pokemon_squirtle_2,
                                R.drawable.pokemon_squirtle_3,
                                R.drawable.pokemon_squirtle_4
                        ),
                        false
                ),
                Pokemon(
                        3,
                        "#016",
                        "Pidgey",
                        elementTypes = arrayListOf(
                                elementTypes[0],
                                elementTypes[9]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[12],
                                pokemonAttacks[13],
                                pokemonAttacks[14]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_pidgey_1,
                                R.drawable.pokemon_pidgey_2,
                                R.drawable.pokemon_pidgey_3
                        ),
                        false
                ),
                Pokemon(
                        4,
                        "#025",
                        "Pikachu",
                        elementTypes = arrayListOf(
                                elementTypes[3]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[15],
                                pokemonAttacks[1],
                                pokemonAttacks[16],
                                pokemonAttacks[17]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_pikachu_1,
                                R.drawable.pokemon_pikachu_2,
                                R.drawable.pokemon_pikachu_3
                        ),
                        false
                ),
                Pokemon(
                        5,
                        "#041",
                        "Zubat",
                        elementTypes = arrayListOf(
                                elementTypes[7],
                                elementTypes[9]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[19],
                                pokemonAttacks[20],
                                pokemonAttacks[21],
                                pokemonAttacks[22],
                                pokemonAttacks[23]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_zubat_1,
                                R.drawable.pokemon_zubat_2,
                                R.drawable.pokemon_zubat_3
                        ),
                        false
                ),
                Pokemon(
                        6,
                        "#074",
                        "Geodude",
                        elementTypes = arrayListOf(
                                elementTypes[12],
                                elementTypes[8]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[24],
                                pokemonAttacks[25],
                                pokemonAttacks[26],
                                pokemonAttacks[27]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_geodude_1,
                                R.drawable.pokemon_geodude_2,
                                R.drawable.pokemon_geodude_3
                        ),
                        false
                ),
                Pokemon(
                        7,
                        "#079",
                        "Slowpoke",
                        elementTypes = arrayListOf(
                                elementTypes[2],
                                elementTypes[10]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[1],
                                pokemonAttacks[10],
                                pokemonAttacks[11],
                                pokemonAttacks[28]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_slowpoke_1,
                                R.drawable.pokemon_slowpoke_2,
                                R.drawable.pokemon_slowpoke_3
                        ),
                        false
                ),
                Pokemon(
                        8,
                        "#081",
                        "Magnemite",
                        elementTypes = arrayListOf(
                                elementTypes[3],
                                elementTypes[15]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[15],
                                pokemonAttacks[16],
                                pokemonAttacks[29]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_magnemite_1,
                                R.drawable.pokemon_magnemite_2,
                                R.drawable.pokemon_magnemite_3
                        ),
                        false
                ),
                Pokemon(
                        9,
                        "#094",
                        "Gengar",
                        elementTypes = arrayListOf(
                                elementTypes[13],
                                elementTypes[7]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[30],
                                pokemonAttacks[31],
                                pokemonAttacks[22],
                                pokemonAttacks[32],
                                pokemonAttacks[33]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_gengar_1,
                                R.drawable.pokemon_gengar_2,
                                R.drawable.pokemon_gengar_3
                        ),
                        false
                ),
                Pokemon(
                        10,
                        "#124",
                        "Jynx",
                        elementTypes = arrayListOf(
                                elementTypes[5],
                                elementTypes[10]
                        ),
                        attacks = arrayListOf(
                                pokemonAttacks[0],
                                pokemonAttacks[30],
                                pokemonAttacks[34],
                                pokemonAttacks[35],
                                pokemonAttacks[36]
                        ),
                        images = arrayListOf(
                                R.drawable.pokemon_jynx_1,
                                R.drawable.pokemon_jynx_2,
                                R.drawable.pokemon_jynx_3
                        ),
                        false
                )
        )


    }
}