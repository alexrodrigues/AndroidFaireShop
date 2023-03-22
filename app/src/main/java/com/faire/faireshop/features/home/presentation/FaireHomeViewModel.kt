package com.faire.faireshop.features.home.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faire.faireshop.features.home.domain.FaireHomeUseCase
import com.faire.faireshop.features.home.presentation.uimapper.FaireHomeUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class FaireHomeViewModel @Inject constructor(
    private val faireHomeUseCase: FaireHomeUseCase,
    private val uiMapper: FaireHomeUiMapper
): ViewModel(), DefaultLifecycleObserver {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    val stateLiveData = MutableLiveData<FaireHomeViewState>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        fetchHome()
    }


    private fun fetchHome() {
        compositeDisposable.add(
            faireHomeUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    stateLiveData.value = FaireHomeViewState.Loading
                }
                .subscribe({ list ->
                    val vos = list.map { uiMapper.transform(it) }
                    stateLiveData.value = FaireHomeViewState.HomeLoaded(vos)
                }, {
                    it.printStackTrace()
                    stateLiveData.value = FaireHomeViewState.PresentError
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    fun retry() {
        fetchHome()
    }

}