package com.memebattle.template.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memebattle.template.core.domain.model.UserEntity
import com.memebattle.template.core.domain.model.WordsEntity

@Database(entities = [UserEntity::class, WordsEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun wordsDao(): WordsDao

}