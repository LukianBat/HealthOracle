package com.memebattle.template.features.auth.core.data


import com.memebattle.template.features.game.domain.model.LinksModel
import com.memebattle.template.features.game.domain.model.WordsModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiGame {

    @GET("/pictures")
    fun getLinks(): Call<LinksModel>

    @GET("/words")
    fun getWords(): Call<WordsModel>
}