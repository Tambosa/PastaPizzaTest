package com.example.pastapizzatest.presentation.screens.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pastapizzatest.R
import com.example.pastapizzatest.domain.PastaCacheRepository
import com.example.pastapizzatest.domain.PastaRepository
import com.example.pastapizzatest.domain.model.MenuState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val pastaRemoteRepo: PastaRepository,
    private val pastaCacheRepo: PastaCacheRepository,
) : ViewModel() {
    private val _menuState = MutableStateFlow(MenuState())
    val menuState = _menuState.asStateFlow()

    fun getMenu() {
        viewModelScope.launch {
            _menuState.value = _menuState.value.copy(isLoading = true)

            try {
                val remoteData = pastaRemoteRepo.getPasta()
                if (remoteData.isNotEmpty()) {
                    pastaCacheRepo.savePastaList(remoteData)
                    _menuState.value = _menuState.value.copy(
                        isLoading = false,
                        pastaList = remoteData
                    )
                }
            } catch (e: Exception) {
                val localData = pastaCacheRepo.getPasta()
                if (localData.isNotEmpty()) {
                    _menuState.value = _menuState.value.copy(
                        isLoading = false,
                        pastaList = localData
                    )
                }
            }
        }
    }

    fun setSelectedCategory(selected: FoodCategories) {
        _menuState.value = _menuState.value.copy(selectedCategory = selected)
    }

    enum class FoodCategories(val resId: Int) {
        PASTA(R.string.pasta),
        COMBO(R.string.combo),
        DESSERTS(R.string.desserts),
        DRINKS(R.string.drinks)
    }
}