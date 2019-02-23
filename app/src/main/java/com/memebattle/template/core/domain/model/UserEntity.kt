package com.memebattle.template.core.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(val name: String, val login: String, val level: Int, val accuracy: Int, val wordCount: Int) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}