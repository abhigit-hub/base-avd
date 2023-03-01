package com.footinit.baseavd

import android.app.Application
import com.footinit.baseavd.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AvdApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AvdApp)
            androidLogger()
            modules(appModule)
        }
    }
}