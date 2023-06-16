package com.example.pastapizzatest.domain

import com.example.pastapizzatest.domain.model.Pasta

interface PastaCacheRepository {
    suspend fun getPasta(): List<Pasta>
    suspend fun savePastaList(pastaList: List<Pasta>)
}