package com.faire.faireshop.features.home.di

import com.faire.faireshop.features.home.data.FaireHomeRepository
import com.faire.faireshop.features.home.data.FaireHomeRepositoryImpl
import com.faire.faireshop.features.home.data.service.FaireHomeService
import com.faire.faireshop.features.home.domain.FaireHomeUseCase
import com.faire.faireshop.features.home.domain.FaireHomeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class FaireHomeModule {

    @Provides
    fun provideFaireHomeRepository(
        api: FaireHomeService
    ): FaireHomeRepository = FaireHomeRepositoryImpl(api)

    @Provides
    fun provideFaireHomeUseCase(
        repository: FaireHomeRepository
    ): FaireHomeUseCase = FaireHomeUseCaseImpl(repository)


    @Provides
    fun provideFaireHomeService(
        retrofit: Retrofit
    ): FaireHomeService = retrofit.create(FaireHomeService::class.java)
}