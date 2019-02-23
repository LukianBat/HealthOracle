package com.memebattle.template.core.di.core

import com.memebattle.template.core.di.core.module.RoomModule

import com.memebattle.template.core.di.core.module.AppModule
import com.memebattle.template.core.di.core.module.RetrofitModule
import com.memebattle.template.core.di.core.module.SharedPreferencesModule
import com.memebattle.template.features.game.presentation.GameViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class, SharedPreferencesModule::class, RoomModule::class])
interface AppComponent {
    fun inject(gameViewModel: GameViewModel)
}