package com.faire.faireshop.features.home.presentation

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faire.faireshop.features.home.domain.FaireHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class FaireHomeViewModel @Inject constructor(
    private val faireHomeUseCase: FaireHomeUseCase
): ViewModel(), DefaultLifecycleObserver {

    private val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }
    val stateLiveData = MutableLiveData<FaireHomeViewState>()

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)

        compositeDisposable.add(
            faireHomeUseCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    stateLiveData.value = FaireHomeViewState.HomeLoaded(it.toString())
                }, {
                    it.printStackTrace()
                })
        )
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

}