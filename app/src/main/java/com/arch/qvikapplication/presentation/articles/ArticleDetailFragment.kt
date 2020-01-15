package com.arch.qvikapplication.presentation.articles

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.arch.base.presentation.BaseFragment
import com.arch.base.presentation.BaseViewModelFactory
import com.arch.qvikapplication.R
import com.arch.qvikapplication.datamodel.Articles
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_article_detail_fragment.*
import kotlinx.android.synthetic.main.layout_article_list_fragment.channelImageView
import kotlinx.android.synthetic.main.layout_article_list_fragment.navCloseBtn
import kotlinx.android.synthetic.main.list_single_article_layout.*
import javax.inject.Inject

class ArticleDetailFragment : BaseFragment() {
    @Inject lateinit var viewModelFactory: BaseViewModelFactory

    private val viewModel: ArticleListViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ArticleListViewModel::class.java)
    }

    override fun layoutRes(): Int {
        return R.layout.layout_article_detail_fragment
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    @SuppressLint("SetTextI18n")
    private fun init() {
        val bundle = arguments
        val articleId = bundle?.getInt("articleId")
        val channelName = bundle?.getString("channelName")

        channelNameTextView.text = "$channelName CHANNEL"
        channelInfo.visibility = View.VISIBLE
        channelInfo.text = channelName
        title.visibility = View.GONE

        navCloseBtn.setOnClickListener {
            view?.let { rootView -> Navigation.findNavController(rootView).navigateUp() }
        }

        articleId?.let { viewModel.getArticleDetail(it) }

        viewModel.articleDetailLiveData.observe(this, Observer {
            setupView(it)
        })

        viewModel.responseErrorLiveData.observe(this, Observer {
            Toast.makeText(context,"Error fetching data, Try again later", Toast.LENGTH_LONG).show()
        })
    }

    private fun setupView(article: Articles) {
        if (context != null && view != null) {
            Glide.with(view!!).load(context!!.getDrawable(R.drawable.background_article_header))
                .into(channelImageView)
        }
        articleTitle.text = article.title
        articleDesc.text = article.content
        broadcasterTitle.text = article.broadcaster
        publishedAt.text = article.publishedAt
    }
}