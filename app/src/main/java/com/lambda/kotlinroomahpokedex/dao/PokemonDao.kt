package com.lambda.kotlinroomahpokedex.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lambda.kotlinroomahpokedex.models.Pokemon


@Dao
interface PokemonDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: Pokemon)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(itinerary: Pokemon)

    @Delete
    fun delete(itinerary: Pokemon)

    @Query(value = "SELECT * FROM pokemon_table WHERE id = :id")
    fun getPokemonById(id:Long):LiveData<Pokemon>

    @Query(value = "SELECT * FROM pokemon_table WHERE number = :num")
    fun getPokemonByNum(num:Int):LiveData<Pokemon>

    @Query(value = "SELECT * FROM pokemon_table WHERE name = :name")
    fun getPokemonByName(name:String):LiveData<Pokemon>

    @Query("DELETE FROM pokemon_table")
    fun deleteAllPokemon()

    @Query("SELECT * FROM pokemon_table")
    fun getAllPokemon(): LiveData<List<Pokemon>>
}