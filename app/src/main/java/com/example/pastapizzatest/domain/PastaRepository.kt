package com.example.pastapizzatest.domain.model

interface PastaRepository {
    suspend fun getPasta(): List<Pasta>
}