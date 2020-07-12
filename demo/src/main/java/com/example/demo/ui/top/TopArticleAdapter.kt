package com.example.demo.ui.top

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.demo.pojo.TopArticle
import com.example.demo.R

/**
 * author: Pan
 * date: 2020/7/12
 */
class TopArticleAdapter : BaseQuickAdapter<TopArticle, BaseViewHolder>(R.layout.item_top_article) {

    override fun convert(helper: BaseViewHolder, bean: TopArticle) {
        helper.setText(R.id.tvTitle, bean.chapterName)
    }
}