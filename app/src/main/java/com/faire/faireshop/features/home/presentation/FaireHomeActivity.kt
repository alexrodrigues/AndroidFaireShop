package com.faire.faireshop.features.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.faire.faireshop.R
import com.faire.faireshop.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FaireHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<FaireHomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        ).apply {
            lifecycleOwner = this@FaireHomeActivity
        }.also {
            lifecycle.addObserver(viewModel)
        }

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.stateLiveData.observe(this) { state ->
            when(state) {
                is FaireHomeViewState.HomeLoaded ->
                    binding.faireProductList.bind(state.vos)
            }
        }
    }
}