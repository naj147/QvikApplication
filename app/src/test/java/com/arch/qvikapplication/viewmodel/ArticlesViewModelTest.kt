package com.arch.qvikapplication.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.arch.qvikapplication.BaseTest
import com.arch.qvikapplication.RxImmediateSchedulerRule
import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.presentation.articles.ArticleListViewModel
import com.arch.qvikapplication.repository.ArticleListRepository
import com.arch.qvikapplication.utils.MockedData
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Assert.*
import org.junit.Before
import org.junit.ClassRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner.Silent::class)
class ArticlesViewModelTest : BaseTest() {
    @Rule @JvmField
    val rule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: ArticleListViewModel
    @Mock lateinit var repository: ArticleListRepository

    @Mock private lateinit var articleListLiveDataObserver: Observer<List<Articles>>
    @Mock private lateinit var articleDetailLiveDataObserver: Observer<Articles>
    @Mock private lateinit var errorObserver: Observer<Boolean>
    @Mock private lateinit var channelLiveDataObserver : Observer<Channel>

    companion object {
        @ClassRule @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Before
    override fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = ArticleListViewModel(repository)
        viewModel.articleListLiveData.observeForever(articleListLiveDataObserver)
        viewModel.articleDetailLiveData.observeForever(articleDetailLiveDataObserver)
        viewModel.channelLiveData.observeForever(channelLiveDataObserver)
        viewModel.responseErrorLiveData.observeForever(errorObserver)
    }

    @Test
    fun testFetchArticlesNullValueTest() {
        `when`(repository.getAllArticles(ArgumentMatchers.anyInt())).thenReturn(null)
        assertNull(viewModel.articleListLiveData.value)
        assertTrue(viewModel.articleListLiveData.hasObservers())
    }

    @Test
    fun testFetchArticlesPositiveResponseTest() {
        `when`(repository.getAllArticles(1)).thenReturn(
            Flowable.just(MockedData.mockedArticleList))
        viewModel.articleListLiveData.observeForever(articleListLiveDataObserver)
        assertNotNull(viewModel.articleListLiveData)
    }

    @Test
    fun testFetchArticlesErrorResponseTest() {
        `when`(repository.getAllArticles(ArgumentMatchers.anyInt())).thenReturn(
            Flowable.error(Throwable()))
        assertNotNull(viewModel.responseErrorLiveData)

    }

    @Test
    fun testFetchChannelPositiveResponseTest() {
        `when`(repository.getChannelInfo(1)).thenReturn(
            Flowable.just(MockedData.mockedChannel))
        viewModel.channelLiveData.observeForever(channelLiveDataObserver)
        assertNotNull(viewModel.channelLiveData)
    }


    override fun tearDown() {
    }
}
