package com.arch.qvikapplication.presentation.channel

import androidx.lifecycle.MutableLiveData
import com.arch.base.presentation.BaseViewModel
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.repository.ChannelListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ChannelListViewModel @Inject constructor(private val channelListRepository: ChannelListRepository) :
    BaseViewModel() {
    val channelListLiveData = MutableLiveData<List<Channel>>()
    val responseErrorLiveData = MutableLiveData<Boolean>()

    init {
        getAllChannels()
    }

    private fun getAllChannels() {
        disposables.add(
            channelListRepository.getAllChannels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    channelListLiveData.postValue(it)
                }, {
                    responseErrorLiveData.postValue(true)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}
