package com.example.pastapizzatest.data.dto

import com.example.pastapizzatest.domain.model.Pasta
import com.google.gson.annotations.SerializedName

data class PastaDto(
    @SerializedName("idMeal") val id: String,
    @SerializedName("strMeal") val pastaName: String,
    @SerializedName("strMealThumb") val pastaImageUrl: String
)

fun PastaDto.toPasta() =
    Pasta(
        id = this.id,
        pastaName = this.pastaName,
        pastaImageUrl = this.pastaImageUrl
    )