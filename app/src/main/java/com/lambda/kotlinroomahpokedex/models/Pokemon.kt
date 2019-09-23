package com.lambda.kotlinroomahpokedex.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_table")
data class Pokemon(
    val number: Int,
    val name: String,
    val imageUrl: String,

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)