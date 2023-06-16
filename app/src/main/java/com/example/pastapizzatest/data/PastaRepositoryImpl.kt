package com.example.pastapizzatest.data

import com.example.pastapizzatest.data.dto.toPasta
import com.example.pastapizzatest.domain.model.Pasta
import com.example.pastapizzatest.domain.model.PastaRepository

class PastaRepositoryImpl(private val api: PastaApi) : PastaRepository {
    override suspend fun getPasta(): List<Pasta> {
        return api.getPastaList().pastaDtoList.map { it.toPasta() }
    }
}