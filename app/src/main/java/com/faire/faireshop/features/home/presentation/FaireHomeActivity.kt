package com.faire.faireshop.features.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.faire.faireshop.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FaireHomeActivity : AppCompatActivity() {

    private val viewModel by viewModels<FaireHomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(viewModel)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.stateLiveData.observe(this) { state ->
            when(state) {
                is FaireHomeViewState.HomeLoaded ->
                    Toast.makeText(this, state.response, Toast.LENGTH_LONG).show()
            }
        }
    }
}