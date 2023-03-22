package com.faire.faireshop.features.home.presentation

import com.faire.faireshop.components.fairelist.viewobject.FaireProductItemVO

sealed class FaireHomeViewState {
    object PresentError: FaireHomeViewState()
    object Loading: FaireHomeViewState()
    data class HomeLoaded(val vos: List<FaireProductItemVO>): FaireHomeViewState()
}