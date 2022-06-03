package com.harshilpadsala.newsapp

import android.app.Application
import com.harshilpadsala.newsapp.di.generalModule
import com.harshilpadsala.newsapp.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NewsApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@NewsApplication)
            modules(
                listOf(generalModule, vmModule)
            )
        }
    }

}