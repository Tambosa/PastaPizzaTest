package com.example.pastapizzatest.domain

import com.example.pastapizzatest.domain.model.Pasta

interface PastaRepository {
    suspend fun getPasta(): List<Pasta>
}