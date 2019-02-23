package com.memebattle.template.core.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordsEntity(val wordCurrent: String, val theme: String, val level : Int, val imageLink: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}