package com.faire.faireshop.features.home.di

import com.faire.faireshop.features.home.data.FaireHomeRepository
import com.faire.faireshop.features.home.data.FaireHomeRepositoryImpl
import com.faire.faireshop.features.home.data.service.FaireHomeService
import com.faire.faireshop.features.home.domain.FaireHomeMapper
import com.faire.faireshop.features.home.domain.FaireHomeMapperImpl
import com.faire.faireshop.features.home.domain.FaireHomeUseCase
import com.faire.faireshop.features.home.domain.FaireHomeUseCaseImpl
import com.faire.faireshop.features.home.presentation.uimapper.FaireHomeUiMapper
import com.faire.faireshop.features.home.presentation.uimapper.FaireHomeUiMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class FaireHomeModule {

    // Service
    @Provides
    fun provideFaireHomeService(
        retrofit: Retrofit
    ): FaireHomeService = retrofit.create(FaireHomeService::class.java)

    // Repository
    @Provides
    fun provideFaireHomeRepository(
        api: FaireHomeService
    ): FaireHomeRepository = FaireHomeRepositoryImpl(api)

    // Mapper
    @Provides
    fun provideFaireHomeMapper(): FaireHomeMapper = FaireHomeMapperImpl()

    // UseCase
    @Provides
    fun provideFaireHomeUseCase(
        repository: FaireHomeRepository,
        mapper: FaireHomeMapper
    ): FaireHomeUseCase = FaireHomeUseCaseImpl(repository, mapper)

    // Ui Mapper
    @Provides
    fun provideFaireHomeUiMapper(): FaireHomeUiMapper = FaireHomeUiMapperImpl()
}