package com.memebattle.template.features.game.presentation

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.memebattle.template.R
import com.memebattle.template.features.game.domain.model.ImageCardModel
import kotlinx.android.synthetic.main.custom_image_view_item.view.*

class CustomImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr) {


    init {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.custom_image_view_item, this)
    }
    fun setText(text: String) {

    }
    fun setImage(image : Int){

    }

}
