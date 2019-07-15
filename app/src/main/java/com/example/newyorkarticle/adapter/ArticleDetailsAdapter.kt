package com.cashos.stockroomos.adapter

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newyorkarticle.R
import com.example.newyorkarticle.bean.ArticlesDetailsBean
import kotlinx.android.synthetic.main.row_article_details.view.*


class ArticleDetailsAdapter(var applicationContext: Activity?, private var articlesList: MutableList<ArticlesDetailsBean>
                         ): RecyclerView.Adapter<ArticleDetailsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(applicationContext).inflate(R.layout.row_article_details, parent, false))
    }

    override fun getItemCount(): Int {
        return articlesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val articlesDetailsBean = articlesList.get(position)
        holder.tvSnippet.setText(articlesDetailsBean.snippet)
        holder.tvSource.setText(articlesDetailsBean.source)

    }




    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

      /*  var web_url:String=""
        var snippet: String=""
        var lead_paragraph: String=""
        var print_page:Int=0
        var source : String = ""*/
        val tvSnippet=view.tv_snippet
        val tvSource=view.tv_source

    }
}



