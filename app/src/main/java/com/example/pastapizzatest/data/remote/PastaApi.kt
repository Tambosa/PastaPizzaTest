package com.example.pastapizzatest.data.remote

import com.example.pastapizzatest.data.remote.dto.PastaListDto
import retrofit2.http.GET

interface PastaApi {
    @GET("/api/json/v1/1/filter.php?c=Pasta")
    suspend fun getPastaList(): PastaListDto
}