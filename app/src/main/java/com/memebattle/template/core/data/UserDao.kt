package com.memebattle.template.core.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.memebattle.template.core.domain.model.UserEntity
import io.reactivex.Single

@Dao
interface UserDao {

    @Insert
    fun addCurrent(current: UserEntity)

    @Query("SELECT * FROM userentity WHERE login = :login")
    fun getByLogin(login: String): Single<UserEntity>

    @Query("DELETE FROM userentity")
    fun deleteAll()

}