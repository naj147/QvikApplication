package com.arch.qvikapplication.presentation.articles

import androidx.lifecycle.MutableLiveData
import com.arch.base.presentation.BaseViewModel
import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.repository.ArticleListRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ArticleListViewModel @Inject constructor(private val articleListRepository: ArticleListRepository) :
    BaseViewModel() {
    val articleListLiveData = MutableLiveData<List<Articles>>()
    val articleDetailLiveData = MutableLiveData<Articles>()

    val responseErrorLiveData = MutableLiveData<Boolean>()
    val channelLiveData = MutableLiveData<Channel>()
    fun getAllArticles(channelId: Int) {
        disposables.add(
            articleListRepository.getAllArticles(channelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    articleListLiveData.postValue(it)
                }, {
                    responseErrorLiveData.postValue(true)
                })
        )
    }

    fun getChannelInfo(channelId: Int) {
        disposables.add(
            articleListRepository.getChannelInfo(channelId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    channelLiveData.postValue(it)
                }, {
                    responseErrorLiveData.postValue(true)
                })
        )
    }

    fun getArticleDetail(articleId: Int) {
        disposables.add(
            articleListRepository.getArticleInfo(articleId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    articleDetailLiveData.postValue(it)
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
