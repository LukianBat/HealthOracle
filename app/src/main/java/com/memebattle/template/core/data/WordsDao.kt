package com.memebattle.template.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.memebattle.template.core.domain.model.WordsEntity
import io.reactivex.Single

@Dao
interface WordsDao {
    @Insert
    fun addCurrent(current: WordsEntity)

    @Query("SELECT * FROM wordsentity WHERE wordCurrent = :wordCurrent")
    fun getByCurrent(wordCurrent: String): Single<WordsEntity>

    @Query("SELECT * FROM wordsentity WHERE wordCurrent = :theme")
    fun getByTheme(theme: String): Single<List<WordsEntity>>

    @Query("SELECT * FROM wordsentity WHERE level = :level")
    fun getByLevel(level: Int): Single<List<WordsEntity>>

    @Query("SELECT * FROM wordsentity WHERE imageLink = :imageLink")
    fun getByLink(imageLink: String): Single<List<WordsEntity>>

    @Query("DELETE FROM wordsentity")
    fun deleteAll()

}