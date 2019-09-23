package com.lambda.kotlinroomahpokedex.repository

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.lambda.kotlinroomahpokedex.PokemonDatabase
import com.lambda.kotlinroomahpokedex.dao.PokemonDao
import com.lambda.kotlinroomahpokedex.models.Pokemon

class PokemonRepository(context: Context) {
    private var pokemonDao: PokemonDao

    private var allPokemon: LiveData<List<Pokemon>>

    init {
        val database: PokemonDatabase = PokemonDatabase.getInstance(
            context
        )!!

        pokemonDao = database.pokemonDao()
        allPokemon = pokemonDao.getAllPokemon()
    }


    //Pokemon

    fun insert(pokemon: Pokemon) {
        val insertPokemonAsyncTask = InsertPokemonAsyncTask(
            pokemonDao
        ).execute(pokemon)
    }

    fun update(pokemon: Pokemon) {
        val updatePokemonAsyncTask = UpdatePokemonAsyncTask(
            pokemonDao
        ).execute(pokemon)
    }


    fun delete(pokemon: Pokemon) {
        val deletePokemonAsyncTask = DeletePokemonAsyncTask(
            pokemonDao
        ).execute(pokemon)
    }

    fun deleteAllPokemon() {
        val deleteAllPokemonAsyncTask = DeleteAllPokemonAsyncTask(
            pokemonDao
        ).execute()
    }

    fun getAllPokemon(): LiveData<List<Pokemon>> {
        return allPokemon
    }


    companion object {

        //Pokemon
        private class InsertPokemonAsyncTask(pokemonDao: PokemonDao) :
            AsyncTask<Pokemon, Unit, Unit>() {
            val PokemonDao = pokemonDao

            override fun doInBackground(vararg p0: Pokemon?) {
                PokemonDao.insert(p0[0]!!)
            }
        }

        private class UpdatePokemonAsyncTask(pokemonDao: PokemonDao) :
            AsyncTask<Pokemon, Unit, Unit>() {
            val PokemonDao = pokemonDao

            override fun doInBackground(vararg p0: Pokemon?) {
                PokemonDao.update(p0[0]!!)
            }
        }

        private class DeletePokemonAsyncTask(pokemonDao: PokemonDao) :
            AsyncTask<Pokemon, Unit, Unit>() {
            val PokemonDao = pokemonDao

            override fun doInBackground(vararg p0: Pokemon?) {
                PokemonDao.delete(p0[0]!!)
            }
        }

        private class DeleteAllPokemonAsyncTask(pokemonDao: PokemonDao) :
            AsyncTask<Unit, Unit, Unit>() {
            val PokemonDao = pokemonDao

            override fun doInBackground(vararg p0: Unit?) {
                PokemonDao.deleteAllPokemon()
            }
        }

    }
}
