package com.arch.qvikapplication.presentation.articles

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.arch.base.presentation.BaseFragment
import com.arch.base.presentation.BaseViewModelFactory
import com.arch.qvikapplication.R
import com.arch.qvikapplication.adapter.article.ArticleListAdapter
import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.datamodel.Channel
import com.arch.qvikapplication.interfaces.OnArticleClickListener
import com.arch.qvikapplication.utils.Utility
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_article_list_fragment.*
import javax.inject.Inject

class ArticleListFragment : BaseFragment(), OnArticleClickListener {
    @Inject lateinit var viewModelFactory: BaseViewModelFactory
    lateinit var articleListAdapter: ArticleListAdapter
    private val onArticleClickListener = this
    private var channelNameValue: String = ""
    private val viewModel: ArticleListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ArticleListViewModel::class.java)
    }

    override fun layoutRes(): Int {
        return R.layout.layout_article_list_fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        val bundle = arguments
        val channelId = bundle?.getInt("channelId")

        navCloseBtn.setOnClickListener {
            view?.let { rootView -> Navigation.findNavController(rootView).navigateUp() }
        }

        articleListRecyclerView.layoutManager = LinearLayoutManager(context)
        articleListAdapter = ArticleListAdapter(onArticleClickListener)
        articleListRecyclerView.adapter = articleListAdapter

        channelId?.let { viewModel.getAllArticles(it) }
        channelId?.let { viewModel.getChannelInfo(channelId) }
        viewModel.articleListLiveData.observe(this, Observer {
            setupRecyclerViewAdapter(it)
        })

        viewModel.channelLiveData.observe(this, Observer {
            setupView(it)
        })

        viewModel.responseErrorLiveData.observe(this, Observer {
            Toast.makeText(context,"Error fetching data, Try again later", Toast.LENGTH_LONG).show()
        })
    }

    private fun setupView(channel: Channel) {
        if (context != null && view != null) {
            Glide.with(view!!).load(Utility.getChannelImage(channel.id, context!!))
                .into(channelImageView)
        }
        channelName.text = channel.name
        followerCount.text = channel.followers
        channelNameValue = channel.name
    }

    private fun setupRecyclerViewAdapter(articleList: List<Articles>?) {
        articleList?.let { articleListAdapter.setData(articleList) }
    }

    override fun onArticleClick(item: Articles) {
        val bundle = Bundle()
        bundle.putInt("articleId", item.id)
        bundle.putString("channelName", channelNameValue)
        view?.let {
            Navigation.findNavController(it).navigate(
                R.id.action_channelArticleList_to_articleDetailFragment,
                bundle,
                null,
                null
            )
        }
    }

}