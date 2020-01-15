package com.arch.qvikapplication.adapter.article

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arch.qvikapplication.R
import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.interfaces.OnArticleClickListener

class ArticleListAdapter(
    private val onArticleClickListener: OnArticleClickListener
) : RecyclerView.Adapter<ArticleViewHolder>() {
    private var articleList = ArrayList<Articles>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_single_article_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList[position], onArticleClickListener)
    }

    fun setData(list: List<Articles>) {
        articleList.clear()
        articleList.addAll(list)
        notifyDataSetChanged()
    }
}