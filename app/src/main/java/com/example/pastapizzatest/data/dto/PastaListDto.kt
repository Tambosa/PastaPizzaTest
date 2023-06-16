package com.example.pastapizzatest.data.dto

import com.google.gson.annotations.SerializedName

data class PastaListDto(
    @SerializedName("meals") val pastaDtoList: List<PastaDto>
)