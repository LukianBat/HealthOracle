package com.memebattle.template.features.game.presentation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

import com.memebattle.template.core.domain.BaseCallback
import kotlinx.android.synthetic.main.fragment_game.*
import com.memebattle.template.R
import com.memebattle.template.features.game.domain.model.ImageCardModel


class GameFragment : Fragment() {


    private lateinit var viewModel: GameViewModel
    private lateinit var wordsArrayList: ArrayList<String>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getWords()
    }

    fun getLinks() {
        viewModel.getLinks(object : BaseCallback<ArrayList<String>> {
            override fun onSuccess(data: ArrayList<String>?) {
                Log.i("TAG", data!![0])
                initImageView(data)
            }

            override fun onError(t: Throwable) {

            }

        })
    }

    fun getWords() {
        viewModel.getWords(object : BaseCallback<ArrayList<String>> {
            override fun onSuccess(data: ArrayList<String>?) {
                wordsArrayList = data!!
                Log.i("TAG", wordsArrayList[0])
                getLinks()
            }

            override fun onError(t: Throwable) {
                //Log.i("TAG", t.message)

            }
        })
    }

    fun initImageView(array: ArrayList<String>) {
        Log.i("TAG", array.size.toString())
        for (i in 0 until array.size) {
            activity?.let {
                val imageView = ImageView(it)
                Glide.with(activity)
                        .load(array[i])
                        .into(imageView)
                imageViewContainer.addView(imageView)
                val secretImageView = CustomImageView(it)
                secretImageView.setData(ImageCardModel(wordsArrayList[i], R.drawable.ic_settings))
                secretImageViewContainer.addView(secretImageView)
            }
        }
    }

}
