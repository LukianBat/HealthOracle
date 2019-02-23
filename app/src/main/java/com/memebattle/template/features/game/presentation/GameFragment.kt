package com.memebattle.template.features.game.presentation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

import com.memebattle.template.core.domain.BaseCallback
import kotlinx.android.synthetic.main.game_fragment.*
import com.memebattle.template.R
import com.memebattle.template.features.game.domain.model.ImageCardModel


class GameFragment : Fragment() {


    private lateinit var viewModel: GameViewModel
    private lateinit var wordsArrayList : ArrayList<String>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        return inflater.inflate(R.layout.game_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getWords()

    }
    fun getLinks(){
        viewModel.getLinks(object : BaseCallback<ArrayList<String>>{
            override fun onSuccess(data: ArrayList<String>?) {
                initImageView(data!!)
            }

            override fun onError(t: Throwable) {

            }

        })
    }
    fun getWords(){
        viewModel.getWords(object : BaseCallback<ArrayList<String>>{
            override fun onSuccess(data: ArrayList<String>?) {
                wordsArrayList = data!!
                getLinks()
            }

            override fun onError(t: Throwable) {

            }
        })
    }
    fun initImageView(array : ArrayList<String>){
        for (i in 0..array.size){
            val imageView = ImageView(activity!!.applicationContext)
            Glide.with(activity)
                    .load(array[i])
                    .into(imageView)
            imageViewContainer.addView(imageView)
            val secretImageView = CustomImageView(activity!!.applicationContext)
            secretImageView.setData(ImageCardModel(wordsArrayList[i], R.drawable.ic_settings))
            secretImageViewContainer.addView(secretImageView)
        }
    }

}
