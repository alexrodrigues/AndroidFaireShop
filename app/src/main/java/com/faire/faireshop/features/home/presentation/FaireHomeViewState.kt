package com.faire.faireshop.features.home.presentation

sealed class FaireHomeViewState {
    data class HomeLoaded(val response: String): FaireHomeViewState()
}