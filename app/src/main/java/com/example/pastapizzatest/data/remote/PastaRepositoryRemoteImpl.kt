package com.example.pastapizzatest.data.remote

import com.example.pastapizzatest.data.remote.dto.toPasta
import com.example.pastapizzatest.domain.model.Pasta
import com.example.pastapizzatest.domain.PastaRepository

class PastaRepositoryRemoteImpl(private val api: PastaApi) : PastaRepository {
    override suspend fun getPasta(): List<Pasta> {
        return api.getPastaList().pastaDtoList.map { it.toPasta() }
    }
}