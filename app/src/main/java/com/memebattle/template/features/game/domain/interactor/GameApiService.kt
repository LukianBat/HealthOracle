package com.memebattle.template.features.auth.core.domain.interactor

import com.memebattle.template.core.domain.BaseCallback
import com.memebattle.template.features.auth.core.data.ApiGame
import com.memebattle.template.features.game.domain.model.LinksModel
import com.memebattle.template.features.game.domain.model.WordsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GameApiService(var api: ApiGame) {

    fun getLinks(callback : BaseCallback<LinksModel>) {
        api.getLinks().enqueue(object : Callback<LinksModel> {
            override fun onFailure(call: Call<LinksModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<LinksModel>, response: Response<LinksModel>) {
                callback.onSuccess(response.body())
            }
        })
    }
    fun getWords(callback : BaseCallback<WordsModel>) {
        api.getWords().enqueue(object : Callback<WordsModel> {
            override fun onFailure(call: Call<WordsModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<WordsModel>, response: Response<WordsModel>) {
                callback.onSuccess(response.body())
            }
        })
    }
}