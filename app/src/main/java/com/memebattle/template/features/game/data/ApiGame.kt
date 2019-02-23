package com.memebattle.template.features.auth.core.data


import com.memebattle.template.features.game.domain.model.LinksModel
import com.memebattle.template.features.game.domain.model.WordsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiGame {

    @GET("http://192.168.43.93:5005/api/links")
    fun getLinks(): Call<LinksModel>

    @GET("http://192.168.43.93:5005/api/words")
    fun getWords(): Call<WordsModel>


}