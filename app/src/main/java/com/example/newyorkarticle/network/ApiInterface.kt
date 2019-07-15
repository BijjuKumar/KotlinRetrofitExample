package com.example.newyorkarticle


import com.example.newyorkarticle.bean.ClientRespBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by aziz on 28/08/18.
 */
interface ApiInterface {

    @Headers("Content-Type: application/json")
    @GET("{year}/{month}.json")
    fun getArticles(@Path("year") section :Int,
                    @Path("month") period :Int,
                    @Query("api-key") apiKey: String ): Call<ClientRespBean>



}

