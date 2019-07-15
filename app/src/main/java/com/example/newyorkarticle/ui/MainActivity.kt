package com.example.newyorkarticle.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.LinearLayout
import com.cashos.stockroomos.adapter.ArticleDetailsAdapter
import com.example.newyorkarticle.R
import com.example.newyorkarticle.Retrofit2Client
import com.example.newyorkarticle.bean.AllDocsBean
import com.example.newyorkarticle.bean.ArticlesDetailsBean
import com.example.newyorkarticle.bean.ClientRespBean
import com.example.newyorkarticle.utils.Constants
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progress_circular.visibility = View.VISIBLE
        callGetArchiveApi()
    }

    override fun onResume() {
        super.onResume()
        progress_circular.visibility = View.VISIBLE
        callGetArchiveApi()
    }

    private fun callGetArchiveApi() {

        val retrofit = Retrofit2Client.getInstance(getApplicationContext())
        val call = retrofit.apiInterface.getArticles(2019,7,Constants.API_KEY)
        call.enqueue(object : Callback<ClientRespBean> {
            override fun onResponse(call: Call<ClientRespBean>, response: Response<ClientRespBean>) {
                if (response.isSuccessful()) {
                    progress_circular.visibility = View.GONE
                    val respBean = response.body()
                    if (respBean!!.response!=null) {
                        val gson = Gson()
                        val clientResponseStr = gson.toJson(respBean.response)
                        val respBean = gson.fromJson<AllDocsBean>(clientResponseStr, AllDocsBean::class.java)
                        if (respBean != null) {

                            var listArticles: MutableList<ArticlesDetailsBean> = ArrayList<ArticlesDetailsBean>()


                            for (i in 1..100) {
                                listArticles.add(respBean.docs.get(i))
                            }

                            val adapter=ArticleDetailsAdapter(this@MainActivity,listArticles)
                            recyclerview.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)

                            recyclerview.adapter=adapter

                        }
                    } else if (respBean.response== null) {
                        val errorDesc = respBean.fault
                        if (errorDesc != null) {
                        }
                    } else {
                    }

                } else {
                }
            }

            override fun onFailure(call: Call<ClientRespBean>, t: Throwable) {
                if (t is IOException) {
                } else {
                }
            }
        })
    }
}
