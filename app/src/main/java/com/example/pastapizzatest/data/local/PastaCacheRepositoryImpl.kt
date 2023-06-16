package com.example.pastapizzatest.data.local

import com.example.pastapizzatest.domain.PastaCacheRepository
import com.example.pastapizzatest.domain.model.Pasta

class PastaCacheRepositoryImpl(private val dao: PastaDao) : PastaCacheRepository {
    override suspend fun getPasta() = dao.getAll().map { it.toPasta() }

    override suspend fun savePastaList(pastaList: List<Pasta>) {
        pastaList.forEach {
            dao.insertPasta(
                PastaEntity(
                    pastaId = it.id,
                    pastaName = it.pastaName,
                    pastaImageUrl = it.pastaImageUrl
                )
            )
        }
    }
}