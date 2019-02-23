package com.memebattle.template.core.di.core.module

import android.content.Context
import androidx.room.Room
import com.memebattle.template.core.data.AppDatabase
import com.memebattle.template.core.data.UserDao
import com.memebattle.template.core.data.WordsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideWordsDao(appDatabase: AppDatabase): WordsDao {
        return appDatabase.wordsDao()
    }

}