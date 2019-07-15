package com.example.newyorkarticle.bean

import java.io.Serializable

open class AllDocsBean : Serializable {

    val docs : MutableList<ArticlesDetailsBean> = ArrayList<ArticlesDetailsBean>()
}