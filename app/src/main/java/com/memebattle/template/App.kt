package com.memebattle.template

import android.app.Application
import com.memebattle.template.core.di.core.AppComponent
import com.memebattle.template.core.di.core.DaggerAppComponent
import com.memebattle.template.core.di.core.module.AppModule
import com.memebattle.template.core.di.core.module.RetrofitModule
import com.memebattle.template.core.di.core.module.RoomModule
import com.memebattle.template.core.di.core.module.SharedPreferencesModule

class App : Application() {

    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        val url = resources.getString(R.string.url)
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(instance))
                .retrofitModule(RetrofitModule(url)).roomModule(RoomModule()).sharedPreferencesModule(SharedPreferencesModule())
                .build()
    }
}