package com.arch.qvikapplication.adapter.article

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.arch.qvikapplication.datamodel.Articles
import com.arch.qvikapplication.interfaces.OnArticleClickListener
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_single_article_layout.*

class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {
    override val containerView: View?
        get() = itemView

    fun bind(item: Articles, onArticleClickListener: OnArticleClickListener) {
        broadcasterTitle.text = item.broadcaster
        title.text = item.title
        publishedAt.text = item.publishedAt

        itemView.setOnClickListener {
            onArticleClickListener.onArticleClick(item)
        }
    }
}