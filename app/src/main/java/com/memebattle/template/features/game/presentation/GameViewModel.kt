package com.memebattle.template.features.game.presentation

import androidx.lifecycle.ViewModel;
import com.memebattle.template.App
import com.memebattle.template.core.domain.BaseCallback
import com.memebattle.template.features.auth.core.domain.interactor.GameApiService
import com.memebattle.template.features.game.domain.model.LinksModel
import com.memebattle.template.features.game.domain.model.WordsModel
import javax.inject.Inject

class GameViewModel : ViewModel() {
    @Inject
    lateinit var gameApiService: GameApiService

    init {
        App.instance.daggerComponentHelper.appComponent.inject(this)
    }

    fun getLinks(callback: BaseCallback<ArrayList<String>>) {
        gameApiService.getLinks(object : BaseCallback<LinksModel> {
            override fun onSuccess(data: LinksModel?) {
                callback.onSuccess(data!!.links)
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }
        })
    }
    fun getWords(callback: BaseCallback<ArrayList<String>>){
        gameApiService.getWords(object : BaseCallback<WordsModel>{
            override fun onSuccess(data: WordsModel?) {
                callback.onSuccess(data!!.words)
            }

            override fun onError(t: Throwable) {
                callback.onError(t)
            }
        })
    }
}
