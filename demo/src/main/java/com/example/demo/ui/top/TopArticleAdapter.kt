package com.example.demo.ui.top

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.demo.pojo.Article
import com.example.demo.R

/**
 * author: Pan
 * date: 2020/7/12
 */
class TopArticleAdapter : BaseQuickAdapter<Article, BaseViewHolder>(R.layout.item_top_article) {

    override fun convert(holder: BaseViewHolder, item: Article) {
        holder.setText(R.id.item_title, item.title)
        holder.setText(R.id.item_author, item.author)
        holder.setText(R.id.item_date, item.niceDate)
        holder.setText(R.id.item_link, item.link)
    }
}