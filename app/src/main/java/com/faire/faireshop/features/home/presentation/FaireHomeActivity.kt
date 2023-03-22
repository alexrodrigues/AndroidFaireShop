package com.faire.faireshop.features.home.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        binding.faireErrorView.retryClickListener = {
            viewModel.retry()
        }
    }

    private fun setupObservers() {
        viewModel.stateLiveData.observe(this) { state ->
            when(state) {
                is FaireHomeViewState.Loading -> {
                    binding.pbFaireHome.visibility = View.VISIBLE
                    binding.faireProductList.visibility = View.GONE
                    binding.faireErrorView.visibility = View.GONE
                }

                is FaireHomeViewState.HomeLoaded -> {
                    binding.pbFaireHome.visibility = View.GONE
                    binding.faireProductList.bind(state.vos)
                    binding.faireProductList.visibility = View.VISIBLE
                    binding.faireErrorView.visibility = View.GONE
                }

                is FaireHomeViewState.PresentError -> {
                    binding.pbFaireHome.visibility = View.GONE
                    binding.faireProductList.visibility = View.GONE
                    binding.faireErrorView.visibility = View.VISIBLE
                }
            }
        }
    }
}