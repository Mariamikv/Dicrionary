package com.example.dictionary.app

import android.app.Application
import android.content.Context
import com.example.dictionary.BuildConfig
import com.example.dictionary.api.di.apiModule
import com.example.dictionary.api.di.repositoryModule
import com.example.dictionary.api.di.retrofitModule
import com.example.dictionary.api.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import org.koin.core.logger.Level

class App: Application() {
    companion object{
        lateinit var instance: App
        //private var instance: App? = null

        fun applicationContext() : Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(
                viewModelModule,
                apiModule,
                repositoryModule,
                retrofitModule
            ))
        }
        instance = this
    }
}