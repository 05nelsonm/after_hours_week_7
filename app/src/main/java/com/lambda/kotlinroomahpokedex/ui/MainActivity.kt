package com.lambda.kotlinroomahpokedex.ui


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lambda.kotlinroomahpokedex.R
import com.lambda.kotlinroomahpokedex.adapters.PokemonListAdapter
import com.lambda.kotlinroomahpokedex.models.Pokemon
import com.lambda.kotlinroomahpokedex.viewModels.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
    }



    private fun setupRecyclerView() {
        rv_pokemon_list.layoutManager = LinearLayoutManager(this)
        rv_pokemon_list.setHasFixedSize(true)

        var adapter = PokemonListAdapter()

        rv_pokemon_list.adapter = adapter
        pokemonViewModel = ViewModelProviders.of(this).get(PokemonViewModel::class.java)

        pokemonViewModel.getAllPokemon().observe(this, Observer<List<Pokemon>> {
            updateRecyclerView(adapter, it as MutableList<Pokemon>)
        })

        adapter.setOnItemClickListener(object : PokemonListAdapter.OnItemClickListener {
            override fun onItemClick(itinerary: Pokemon) {
                //TODO: onClickStuffHere
            }
        })
    }

    fun updateRecyclerView(adapter: PokemonListAdapter, pokemonList: MutableList<Pokemon>) {
        adapter.submitList(pokemonList as List<Pokemon>)
    adapter.notifyDataSetChanged()
    }
}
