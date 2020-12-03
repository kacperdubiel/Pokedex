package com.example.pokedex.screens.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.data.Data
import com.example.pokedex.pokemon.ElementType
import com.example.pokedex.pokemon.Pokemon

class ListViewModel : ViewModel() {
    // All pokemons
    private var _pokemonList = ArrayList<Pokemon>()

    // Pokemons to show in recyclerview
    var currentPokemonList = ArrayList<Pokemon>()

    // Array of booleans to represent pokemon element type filters
    private var _menuFilter = MutableLiveData<ArrayList<Boolean>>()
    val menuFilter: LiveData<ArrayList<Boolean>>
        get() = _menuFilter

    init {
        _pokemonList = Data.pokemons
        currentPokemonList = _pokemonList
        _menuFilter.value = ArrayList()

        // menuFilter at index 0 -> "favourite"
        // menuFilter at indexes from 1 to Data.elementTypes.size -> pokemon types
        for (i in 0..Data.elementTypes.size)
            _menuFilter.value?.add(false)

        Log.i("ListViewModel", "ListModelView created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("ListViewModel", "ListViewModel destroyed!")
    }

    fun filtersOn(): Boolean {
        for (i in 0 until (_menuFilter.value?.size ?: 0)) {
            if (_menuFilter.value?.get(i) == true)
                return true
        }
        return false
    }

    fun checkIfFilterActive(index: Int): Boolean {
        return _menuFilter.value?.get(index) ?: false
    }

    fun removeFilters() {
        val temp = _menuFilter.value
        for (i in 0 until (temp?.size ?: 0)) {
            if (temp?.get(i) == true)
                temp[i] = false
        }
        _menuFilter.value = temp
    }

    fun toggleMenuItem(index: Int) {
        val temp = _menuFilter.value
        temp!![index] = !temp[index]
        _menuFilter.value = temp
    }

    fun removePokemonAt(index: Int) {
        val pokemonToRemove = currentPokemonList[index]
        _pokemonList.remove(pokemonToRemove)
        filterCurrentPokemonList()
    }

    fun toggleFavourite(index: Int) {
        val pokemonToFav = currentPokemonList[index]
        val actualFavVal = _pokemonList.find { it == pokemonToFav }?.favourite
        _pokemonList.find { it == pokemonToFav }?.favourite = !actualFavVal!!
    }

    fun filterCurrentPokemonList() {
        val tempPokemonList: ArrayList<Pokemon> = _pokemonList.map { it.deepCopy() } as ArrayList<Pokemon>
        currentPokemonList = ArrayList()

        val lookForFavourites: Boolean = _menuFilter.value?.get(0) ?: false

        // Get selected types
        val typesToLookFor = ArrayList<ElementType>()
        if (_menuFilter.value?.size ?: 0 > 1) {
            for (i in 0 until Data.elementTypes.size) {
                if (_menuFilter.value?.get(i + 1) == true)
                    typesToLookFor.add(Data.elementTypes[i])
            }
        }

        if (typesToLookFor.size > 0) {
            for (pokeId in tempPokemonList.size - 1 downTo 0) {
                var foundPokemon = false
                for (typeId in 0 until typesToLookFor.size) {
                    if (!foundPokemon) {
                        if (((lookForFavourites && tempPokemonList[pokeId].favourite) || !lookForFavourites) &&
                                tempPokemonList[pokeId].elementTypes.contains(typesToLookFor[typeId])) {
                            currentPokemonList.add(_pokemonList.find { p -> p.name == tempPokemonList[pokeId].name }!!)
                            tempPokemonList.removeAt(pokeId)
                            foundPokemon = true
                        }
                    }
                }
            }

            currentPokemonList.sortBy { it.pokedexId }
        } else if (lookForFavourites) {
            currentPokemonList = _pokemonList.filter { p -> p.favourite } as ArrayList<Pokemon>
        } else if (!lookForFavourites) {
            currentPokemonList = _pokemonList
        }
    }

}