package com.example.pastapizzatest.domain.model

data class MenuState(
    val isLoading: Boolean = false,
    val pastaList: List<Pasta> = listOf()
)