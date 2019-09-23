package com.lambda.kotlinroomahpokedex.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.lambda.kotlinroomahpokedex.models.Pokemon
import com.lambda.kotlinroomahpokedex.repository.PokemonRepository

class PokemonViewModel (application: Application) : AndroidViewModel(application){
    private var repository: PokemonRepository =
        PokemonRepository(application)
    private var allPokemon: LiveData<List<Pokemon>> = repository.getAllPokemon()

    fun insert(itinerary: Pokemon) {
        repository.insert(itinerary)
    }

    fun update(itinerary: Pokemon) {
        repository.update(itinerary)
    }

    fun delete(itinerary: Pokemon) {
        repository.delete(itinerary)
    }

    fun deleteAllPokemon() {
        repository.deleteAllPokemon()
    }

    fun getAllPokemon(): LiveData<List<Pokemon>> {
        return allPokemon
    }
}