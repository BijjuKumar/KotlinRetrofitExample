package com.example.newyorkarticle.bean

import java.io.Serializable

open class ArticlesDetailsBean : Serializable {

    /*"web_url": "https:\/\/www.nytimes.com\/2019\/01\/02\/obituaries\/daryl-dragon-dead.html",
    "snippet": "He and his wife, Toni Tennille, were one of the most successful hit-making combinations of the 1970s. Their \u201cLove Will Keep Us Together\u201d went to No. 1.",
    "lead_paragraph": "He and his wife, Toni Tennille, were one of the most successful hit-making combinations of the 1970s. Their \u201cLove Will Keep Us Together\u201d went to No. 1.",
    "print_page": "10",
    "blog": [],
    "source": "The New York Times",*/

    var web_url:String=""
    var snippet: String=""
    var lead_paragraph: String=""
    var print_page:Int=0
    var source : String = ""




}